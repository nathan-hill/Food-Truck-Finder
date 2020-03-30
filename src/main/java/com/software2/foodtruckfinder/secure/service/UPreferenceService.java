package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.model.MapUtil;
import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
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

    public List<Truck> getPrioritizedTrucks(Long id, Double lon, Double lat) {
        //the result will be kept in a map of the truck and its ranking
        Map<Long, Double> ranking = new LinkedHashMap<>();

        //the list of values we are going to normalize
        Map<Long, Double> distances = prioritizeDistance(id, lon, lat);
        Map<Long, Double> prices = prioritizePrice(id);
        Map<Long, Double> ratings = prioritizeRating(id);
        Map<Long, Double> matchType = prioritizeType(id);

        /*********************************
         * TODO: we can add ratings later
         *******************************/

        if (prices.size() == 0 || distances.size() == 0) {
            System.err.println("there is not data in the db");
            return new ArrayList<Truck>();
        }

        prices = normalizeMap(prices);
        distances = normalizeMap(distances);
        distances = MapUtil.sortByValue(distances);

        for(Map.Entry<Long, Double> e: distances.entrySet()){
//            System.err.println(e.getKey() + " " + e.getValue());
            ranking.put(e.getKey(), distances.get(e.getKey()) + prices.get(e.getKey()));
        }

//        for (Map.Entry<Long, Double> e : prices.entrySet()) {
//            System.err.println(distances.get(e.getKey()) + " " + e.getValue());
//            ranking.put(e.getKey(), distances.get(e.getKey()) + e.getValue() /*+ ratings.get(e.getKey())*/);
//        }

        Map<Long, Double> sorted_results = new LinkedHashMap<>(MapUtil.sortByValue(ranking));

        sorted_results.entrySet().forEach(System.err::println);

        return getTrucksMatchingIds(sorted_results.keySet());
    }

    private List<Truck> getTrucksMatchingIds(Collection<Long> values) {
        List<Truck> dbList = iteratorToList(_truckRepo.findAll().iterator());

        List<Truck> res = new ArrayList<>();

        for (Long d : values) {
            for (Truck t : dbList) {
                if (d.equals(t.getId())) {
                    res.add(t);
                }
            }
        }
        return res;
    }

    private Map<Long, Double> prioritizeType(Long id) {
        return null;
    }

    /*
    Only returns trucks that have a schedule for today.
    Returns a map of truck ids to their respective distance
     */
    public Map<Long, Double> prioritizeDistance(Long id, Double lon, Double lat) {
        Map<Long, Double> distance_ranking = new HashMap<>();

        List<Schedule> sched = _schedrepo.findAll();

        System.err.println(getToday());
        //only look at schedules that pertain to today
        sched.removeIf(s -> !s.getDay().equals(getToday()));

        //get a list of the distances between here and the current location of the truck
        for (int j = 0; j < (long) sched.size(); j++) {
            distance_ranking.put(sched.get(j).getTruckID(), distance(sched.get(j).getLatitude(), sched.get(j).getLongitude(), lat, lon));
        }

        return distance_ranking;
    }


    public Map<Long, Double> prioritizePrice(Long id) {
        Map<Long, Double> prices = new HashMap<>();
        Iterable<Truck> truckList = _truckRepo.findAll();

        UserPreferences pref = createUserPreferencesIfNotExists(id);

        //Get a list of the prices for each of the trucks
        for (Truck t : truckList) {
            Double price = (double) Math.abs(pref.getPrice() - t.getCost());
            prices.put(t.getId(), price);
        }

        return prices;
    }

    private UserPreferences createUserPreferencesIfNotExists(Long id) {
        Optional<UserPreferences> up = _uprefrepo.findById(id);
        if (up.isEmpty()) {
            UserPreferences assignedPreference = new UserPreferences();
            assignedPreference.setProximity(30.0);
            assignedPreference.setPrice(0);
            assignedPreference.setId(id);
            assignedPreference = _uprefrepo.save(assignedPreference);
            return assignedPreference;
        }
        return up.get();
    }

    private int getToday() {
        //1 is sunday 7 is saturday
        return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK);
    }

    public Map<Long, Double> prioritizeRating(Long id) {
        //retrieve all relevant data to the preference computation
        Optional<UserPreferences> pref = _uprefrepo.findById(id);
        //List<Schedule> sched = scheduleRepository.findAll().stream().filter(x -> x.getDay().equals(getDayOfWeek(Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK)))).collect(Collectors.toList());
        // TODO: implement comments and ratings
        return new HashMap<Long, Double>();
    }

    private Double distance(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    public Map<Long, Double> normalizeMap(Map<Long, Double> sortedMap) {
        sortedMap = MapUtil.sortByValue(sortedMap);
        //Double minSet = Collections.min(sortedMap.values());
        Double maxSet = Collections.max(sortedMap.values());
        double ratio = 1.0/maxSet;

        sortedMap.replaceAll((k, v) -> v * ratio);
//        for (Map.Entry<Long, Double> pair : sortedMap.entrySet()) {
//            double numerator  = ((Double) pair.getValue() - minSet) * (maxNorm - minNorm);
//            double deniminator = (maxSet - minSet) == 0? maxSet - minSet + 0.0001 : maxSet - minSet;
//            double val = numerator / deniminator;
//            pair.setValue(val);
//            //it.remove(); // avoids a ConcurrentModificationException
//        }

        return sortedMap;
    }

    private String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "SUNDAY";
                break;
            case 2:
                day = "MONDAY";
                break;
            case 3:
                day = "TUESDAY";
                break;
            case 4:
                day = "WEDNESDAY";
                break;
            case 5:
                day = "THURSDAY";
                break;
            case 6:
                day = "FRIDAY";
                break;
            case 7:
                day = "SATURDAY";
                break;
        }
        return day;
    }

    private List<Truck> iteratorToList(Iterator<Truck> i) {
        List<Truck> res = new ArrayList<>();

        for (Iterator<Truck> it = i; it.hasNext(); ) {
            Truck t = it.next();
            res.add(t);
        }
        return res;
    }
}
