package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.*;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/upref")
public class UPreferenceController {

    @Autowired
    private UPreferenceRepository uprefRepository;
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public UPreferenceController(UPreferenceRepository ur) {
        this.uprefRepository = ur;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<UserPreferences> addNewUPreferences(@RequestBody UserPreferences up) {
        UserPreferences n = new UserPreferences();
        n.setId(up.getId());
        n.setPrice(up.getPrice());
        n.setProximity(up.getProximity());
        n.setLikes(up.getLikes());

        for (UserPreferences uP : uprefRepository.findAll()) {
            if (uP.getId().equals(up.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        UserPreferences generatedUser = uprefRepository.save(n);
        return new ResponseEntity<UserPreferences>(generatedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<UserPreferences> getAllUPreferences() {
        // This returns a JSON or XML with the users
        return uprefRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllUPreferences() {
        uprefRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "/getUPreferencesByID")
    public @ResponseBody
    UserPreferences findUPreferencesByID(Long id) {
        return uprefRepository.findUserPreferencesById(id);
    }

    @PutMapping(value = "updateByUPreferences", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPreferences> updateUPreferences(@RequestBody UserPreferences up) {

        if (uprefRepository.existsById(up.getId())) {
            UserPreferences n = new UserPreferences();
            n.setId(up.getId());
            n.setPrice(up.getPrice());
            n.setProximity(up.getProximity());
            n.setLikes(up.getLikes());

            UserPreferences generatedUser = uprefRepository.save(n);
            return new ResponseEntity<UserPreferences>(generatedUser, HttpStatus.OK);
        } else {
            return null;
        }
    }

    //added should return list of dislikes whatever that is
    @GetMapping(path = "/getPreferred")
    public @ResponseBody
    List<Long> findTruckPreferences(@RequestParam("id") Long id, @RequestParam("lon") Double lon, @RequestParam("lat") Double lat) {

        //retrieve all relevant data to the preference computation
        Optional<UserPreferences> pref = uprefRepository.findById(id);
        //List<Schedule> sched = scheduleRepository.findAll().stream().filter(x -> x.getDay().equals(getDayOfWeek(Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK)))).collect(Collectors.toList());
        List<Schedule> sched = scheduleRepository.findAll();

        //only look at schedules that pertain to today
        int dayOfWeekNumber = Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK);
        sched.removeIf(s -> !s.getDay().equals(dayOfWeekNumber));

        //remove all trucks that do not have a schedule for today
        List<Truck> truckList = new ArrayList();
        Iterable<Truck> iTrucks = truckRepository.findAll();
        truckList = iteratorToList(iTrucks.iterator());

        if (pref.isEmpty()) {
            return new ArrayList<Long>();
        }

        //the result will be kept in a map of the truck and its ranking
        Map<Long, Double> ranking = new HashMap<>();

        //the list of values we are going to normalize
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Double> prices = new HashMap<>();
        Map<Long, Double> ratings = new HashMap<>();

        //get a list of the distances between here and the current location of the truck
        for (int j = 0; j < sched.stream().count(); j++) {
            distances.put(sched.get(j).getTruckID(), distance(sched.get(j).getLatitude(), sched.get(j).getLongitude(), lat, lon));
        }

        //only use trucks who have a schedule for today
        List<Long> scheduledTrucks = new ArrayList<>();
        sched.forEach(s -> scheduledTrucks.add(s.getTruckID()));
        truckList.removeIf(t -> !scheduledTrucks.contains(t.getId()));

        //Get a list of the prices for each of the trucks
        for (int j = 0; j < truckList.stream().count(); j++) {
            Double price = (double) Math.abs(pref.get().getPrice() - truckList.get(j).getCost() + 1);
            prices.put(truckList.get(j).getId(), price);
        }

        /*********************************
         * TODO: we can add ratings later
         *******************************/


        prices = normalizeMap(prices);
        distances = normalizeMap(distances);
        distances = MapUtil.sortByValue(distances);

        for (Iterator<Map.Entry<Long, Double>> it = prices.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Long, Double> e = it.next();
            ranking.put(e.getKey(), distances.get(e.getKey()) + prices.get(e.getKey()) /*+ ratings.get(e.getKey())*/);
        }

        MapUtil.sortByValue(ranking);


        return new ArrayList<Long>(ranking.keySet());
    }

    private Double distance(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    private Map<Long, Double> normalizeMap(Map<Long, Double> sortedMap) {
        sortedMap = MapUtil.sortByValue(sortedMap);
        Double minSet = Collections.min(sortedMap.values());
        Double maxSet = Collections.max(sortedMap.values());
        Integer minNorm = -1;
        Integer maxNorm = 1;

        for (Map.Entry<Long, Double> pair : sortedMap.entrySet()) {
            pair.setValue(minNorm + ((Double) pair.getValue() - minSet) * (maxNorm - minNorm) / (maxSet - minSet));
            //it.remove(); // avoids a ConcurrentModificationException
        }

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

    private List<Truck> iteratorToList(Iterator<Truck> i){
        List<Truck> res = new ArrayList<>();

        for (Iterator<Truck> it = i; it.hasNext(); ) {
            Truck t = it.next();
            res.add(t);
        }
        return res;
    }
}
