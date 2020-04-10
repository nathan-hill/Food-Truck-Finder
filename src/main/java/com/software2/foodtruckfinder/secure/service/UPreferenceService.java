package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.payload.Rankings;
import com.software2.foodtruckfinder.secure.payload.TruckDistance;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UPreferenceService {

    @Autowired
    private UPreferenceRepository _uprefrepo;
    @Autowired
    private ScheduleRepository _schedrepo;
    @Autowired
    private TruckRepository _truckRepo;

    public ArrayList<TruckDistance> getPrioritizedTrucks(Long id, Double lon, Double lat) throws Exception {
        //the result will be kept in a map of the truck and its ranking
        return RecommendedStore.getStoredPreferred(id, lat, lon, _truckRepo, _uprefrepo, _schedrepo);

//        Map<Long, Double> ranking = new LinkedHashMap<>();
//
//        ArrayList<TruckDistance> truckDistance = new Rankings(id, lat, lon)
//                .init(_truckRepo, _uprefrepo, _schedrepo)
//                .prioritizeDate()
//                .prioritizeDistance()
//                .prioritizePrice()
//                .prioritizeType()
//                .getResult();
//
//        return truckDistance;
    }

//    private List<TruckDistance> genTruckDistanceList(ArrayList<Truck> resultTruckSet, ArrayList<Double> values) {
//        ArrayList<TruckDistance> result = new ArrayList<>();
//        for (int i = 0; i < resultTruckSet.size(); i++) {
//            result.add(new TruckDistance(resultTruckSet.get(i), values.get(i)));
//        }
//
//        return result;
//    }
//
//    private ArrayList<Truck> getTrucksMatchingIds(Collection<Long> values) {
//        List<Truck> dbList = iteratorToList(_truckRepo.findAll().iterator());
//
//        List<Truck> res = new ArrayList<>();
//
//        for (Long d : values) {
//            for (Truck t : dbList) {
//                if (d.equals(t.getId())) {
//                    res.add(t);
//                }
//            }
//        }
//        return (ArrayList<Truck>) res;
//    }
//
//    private Map<Long, Double> prioritizeType(Long id, UserPreferences upref) {
//        Map<Long, Double> typeRating = new HashMap<>();
//
//        List<Truck> matchingTypeTrucks = new ArrayList<>(_truckRepo.findByTypeIn(upref.getLikes()));
//        matchingTypeTrucks.forEach(x -> typeRating.put(x.getId(), 0.5));
//
//        for (Map.Entry<Long, Double> longDoubleEntry : typeRating.entrySet()) {
//            System.out.println(longDoubleEntry);
//        }
//
//        return typeRating;
//    }
//
//    /*
//    Only returns trucks that have a schedule for today.
//    Returns a map of truck ids to their respective distance
//     */
//    public Map<Long, Double> prioritizeDistance(Long id, Double lon, Double lat, UserPreferences upref) {
//        Map<Long, Double> distance_ranking = new HashMap<>();
//
//        List<Schedule> sched = _schedrepo.findAll();
//
//        System.err.println(getToday());
//        //only look at schedules that pertain to today
//        sched.removeIf(s -> !s.getDay().equals(getToday()));
//
//        //get a list of the distances between here and the current location of the truck
//        for (int j = 0; j < (long) sched.size(); j++) {
//            double distance = distance(sched.get(j).getLatitude(), sched.get(j).getLongitude(), lat, lon);
//
//            if (distance < upref.getProximity()) {
//                System.out.println(sched.get(j).getTruckID() + " -> " + distance);
//                distance_ranking.put(sched.get(j).getTruckID(), distance);
//            }
//        }
//
//        return distance_ranking;
//    }
//
//
//    public Map<Long, Double> prioritizePrice(UserPreferences pref) {
//        Map<Long, Double> prices = new HashMap<>();
//        Iterable<Truck> truckList = _truckRepo.findAll();
//
//
//        //Get a list of the prices for each of the trucks
//        for (Truck t : truckList) {
//            Double price = (double) Math.abs(pref.getPrice() - t.getCost());
//            prices.put(t.getId(), price);
//        }
//
//        return prices;
//    }

    private int getToday() {
        //1 is sunday 7 is saturday
        return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK);
    }

    public Map<Long, Double> prioritizeRating(Long id, UserPreferences upref) {
        //retrieve all relevant data to the preference computation
        Optional<UserPreferences> pref = _uprefrepo.findById(id);
        //List<Schedule> sched = scheduleRepository.findAll().stream().filter(x -> x.getDay().equals(getDayOfWeek(Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK)))).collect(Collectors.toList());
        // TODO: implement comments and ratings
        return new HashMap<Long, Double>();
    }





    public static String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 7:
                day = "SUNDAY";
                break;
            case 1:
                day = "MONDAY";
                break;
            case 2:
                day = "TUESDAY";
                break;
            case 3:
                day = "WEDNESDAY";
                break;
            case 4:
                day = "THURSDAY";
                break;
            case 5:
                day = "FRIDAY";
                break;
            case 6:
                day = "SATURDAY";
                break;
        }
        return day;
    }

    public static <T> List<T> iteratorToList(Iterator<T> i) {
        List<T> res = new ArrayList<>();

        for (Iterator<T> it = i; it.hasNext(); ) {
            T t = it.next();
            res.add(t);
        }
        return res;
    }
}
