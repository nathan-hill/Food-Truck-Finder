package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/trucks/")
public class FoodTruckController {
    @Autowired
    private TruckRepository truckRepository;

    public FoodTruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @PostMapping(path = "add")
    public @ResponseBody
    ResponseEntity<Truck> addNewTruck(@RequestBody Truck newTruck) {
        Truck n = new Truck();
        n.setName(newTruck.getName());
        n.setDescription(newTruck.getDescription());
        n.setOwnerID(newTruck.getOwnerID());
        n.setMenu(newTruck.getMenu());

        for (Truck truck: truckRepository.findAll()) {
            if(truck.getName().equals(newTruck.getName())){
                return ResponseEntity.status(400).build();
            }
        }

        Truck generatedTruck = truckRepository.save(n);
        return new ResponseEntity<Truck>(generatedTruck, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public @ResponseBody
    Iterable<Truck> getAllTrucks() {
        // This returns a JSON or XML with the trucks
        return truckRepository.findAll();
    }

    @DeleteMapping(path = "delete")
    public @ResponseBody
    Boolean deleteAllTrucks() {
        truckRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "findTruckByID")
    public @ResponseBody
    Optional<Truck> findByTruckId(Integer integer){
        return truckRepository.findById(integer);
    }

    @GetMapping(path = "findTrucksByownerID")
    public @ResponseBody
    List<Truck> findTrucksByOwnerID(long l){
        return truckRepository.findTrucksByOwnerID(l);
    }

    @PutMapping(value = "updateByTruck", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Truck> updateTruck(@RequestBody Truck tdets) {

        System.out.println(tdets.getOwnerID());

        if(truckRepository.existsById(tdets.getId())){
            Truck newT = new Truck();
            newT.setId(tdets.getId());
            newT.setDescription(tdets.getDescription());
            newT.setMenu(tdets.getMenu());
            newT.setName(tdets.getName());
            newT.setOwnerID(tdets.getOwnerID());

            Truck generatedTruck = truckRepository.save(newT);
            return new ResponseEntity<Truck>(generatedTruck, HttpStatus.OK);
        }else{
            return null;
        }
    }


//    @PostMapping("/uploadMenu")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        DBFile dbFile = dbFileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(dbFile.getId())
//                .toUriString();
//
//        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//
//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
//        // Load file from database
//        DBFile dbFile = dbFileStorageService.getFile(fileId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
//                .body(new ByteArrayResource(dbFile.getData()));
//    }

}