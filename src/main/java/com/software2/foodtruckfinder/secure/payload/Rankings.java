package com.software2.foodtruckfinder.secure.payload;

import com.software2.foodtruckfinder.secure.model.MapUtil;
import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;

import java.text.SimpleDateFormat;
import java.util.*;

public class Rankings {

    LinkedHashMap<Truck, Double> rankings;
    LinkedHashMap<Truck, Double> truckDistances;
    LinkedHashMap<Truck, Double> avgReviews;

    ArrayList<Truck> truckList;
    ArrayList<Schedule> schedules;
    ArrayList<ReviewAverages> reviews;

    UserPreferences userPref;
    Integer today;

    Long userID;
    Double latitude;
    Double longitude;

    public Rankings(Long id, Double lat, Double lon) {
        this.userID = id;
        this.latitude = lat;
        this.longitude = lon;
    }

    private void apply(Map<Truck, Double> priceRanking) {
        System.out.println("_________________________");
        for (Map.Entry<Truck, Double> entry : priceRanking.entrySet()) {
            if (this.rankings.get(entry.getKey()) == null) {
                System.err.println(entry.getKey().toString());
                System.err.println(this.rankings.entrySet().stream().filter(x -> x.getKey().getId() == entry.getKey().getId()).findFirst().get().toString());
                System.err.println("Didnt find truck to apply");
            } else {
                Double newVal = this.rankings.get(entry.getKey()) + entry.getValue();
                this.rankings.put(entry.getKey(), newVal);
            }
        }
    }

    public static int dayOfWeekToInt(String value) {
        int day;
        switch (value) {
            case "SUNDAY":
                day = 1;
                break;
            case "MONDAY":
                day = 2;
                break;
            case "TUESDAY":
                day = 3;
                break;
            case "WEDNESDAY":
                day = 4;
                break;
            case "THURSDAY":
                day = 5;
                break;
            case "FRIDAY":
                day = 6;
                break;
            case "SATURDAY":
                day = 7;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
        System.out.println(day);
        return day;
    }

    public Rankings init(TruckRepository truckRepo, UPreferenceRepository uprefrepo, ScheduleRepository schedrepo, ReviewRepository reviewrepo) throws Exception {
        this.truckList = new ArrayList<Truck>(truckRepo.findAll());
        this.schedules = new ArrayList<Schedule>(schedrepo.findAll());
        this.userPref = createUserPreferencesIfNotExists(this.userID, uprefrepo);
        this.truckDistances = new LinkedHashMap<>();
        this.reviews = new ArrayList<>(reviewrepo.getReviewAverages());

        this.today = dayOfWeekToInt(new SimpleDateFormat("EEEE").format(new Date()).toUpperCase());

        this.rankings = new LinkedHashMap<>();
        for (Truck val : this.truckList) {
            this.rankings.put(val, 0.0);
        }

        if (this.truckList.stream().count() < 1 || this.schedules.stream().count() < 1) {
            System.err.println("There is not enough information in the database;");
            throw new Exception("There is not enough information in the database;");
        }

        return this;

    }

    public Rankings prioritizeDate() {

        this.schedules.removeIf((x) -> !x.getDay().equals(this.today));

        truckList.removeIf(truck -> this.schedules.stream().noneMatch(x -> x.getTruckID() == truck.getId()));

        return this;
    }

    public Rankings prioritizeDistance() {
        Map<Truck, Double> distanceRanking = new HashMap<>();

        //System.out.println(this.latitude + " " + this.longitude);

        for (Schedule s : this.schedules) {
            Double distance = distance(s.getLatitude(), s.getLongitude(), this.latitude, this.longitude);

            double preferredDistance = this.userPref.getPrice();

            distanceRanking.put(getTruckFromId(s.getTruckID()), Math.abs(distance - preferredDistance));
            this.truckDistances.put(getTruckFromId(s.getTruckID()), distance);
        }


//        distanceRanking.replaceAll((k, v) -> v > this.userPref.getProximity() ? 1 : v);

        normalizeMap(distanceRanking);

        apply(distanceRanking);

        return this;
    }

    public Rankings prioritizePrice() {
        Map<Truck, Double> priceRanking = new HashMap<>();
        //Get a list of the prices for each of the trucks
        for (Truck t : this.truckList) {
            Double price = (double) Math.abs(this.userPref.getPrice() - t.getCost());
            priceRanking.put(t, price);
        }

        normalizeMap(priceRanking);

        apply(priceRanking);

        return this;
    }

    public Rankings prioritizeType() {
        Map<Truck, Double> typeRank = new HashMap<>();

        for (Truck t : this.truckList) {
            typeRank.put(t, 1.0);
        }

        for (Truck t : this.truckList) {
            if (userPref.getLikes().contains(t.getType())) {
                typeRank.put(t, 0.0);
            }
        }

        apply(typeRank);

        return this;
    }

    public Rankings prioritizeReview() {
        Map<Truck, Double> reviewRank = new HashMap<>();
        this.avgReviews = new LinkedHashMap<Truck, Double>();

        for (Truck t : this.truckList) {
            reviewRank.put(t, 0.0);
        }

        for (ReviewAverages ra : this.reviews) {
            reviewRank.put(getTruckFromId(ra.getId()), ra.getAvg());
            this.avgReviews.put(getTruckFromId(ra.getId()), ra.getAvg());
        }

        apply(reviewRank);

        return this;
    }

    private UserPreferences createUserPreferencesIfNotExists(Long id, UPreferenceRepository uprefrepo) {
        Optional<UserPreferences> up = uprefrepo.findById(id);
        if (up.isEmpty()) {
            UserPreferences assignedPreference = new UserPreferences();
            assignedPreference.setProximity(10.0);
            assignedPreference.setPrice(0);
            assignedPreference.setId(id);
            assignedPreference = uprefrepo.save(assignedPreference);
            return assignedPreference;
        }
        return up.get();
    }

    private Double distance(Double x1, Double y1, Double x2, Double y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0)) * 69.172; // number of miles per degree;
    }

    private Truck getTruckFromId(Long id) {
        for (Truck t : this.truckList) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }


    public Map<Truck, Double> normalizeMap(Map<Truck, Double> sortedMap) {
        sortedMap = MapUtil.sortByValue(sortedMap);
        Double maxSet = Collections.max(sortedMap.values());
        double ratio = 1.0 / maxSet;

        sortedMap.replaceAll((k, v) -> v * ratio);

        return sortedMap;
    }

    public ArrayList<TruckDistance> getResult() {
        this.rankings = MapUtil.sortByValue(this.rankings);

        //System.out.println("Sorted by rank");
        //this.rankings.entrySet().stream().forEach(System.out::println);

        return new ArrayList<TruckDistance>(TruckDistance.makeArrayFromMap(this.truckDistances, this.rankings,this.avgReviews));
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortMapByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
                map.entrySet());
        list.sort(new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1,
                               Map.Entry<K, V> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
