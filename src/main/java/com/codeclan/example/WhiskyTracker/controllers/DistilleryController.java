package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")

    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "age", required = false) Integer age){
    {
        if (region != null) {
            return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        if (age != null)
            return new ResponseEntity<>(distilleryRepository.findDistilleryByWhiskiesAge(age), HttpStatus.OK);
        }
            return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
        }

//    @GetMapping(value = "/distilleries/region")
//    public ResponseEntity<List<Distillery>> getDistilleryByRegion(
//            @RequestParam(name = "region") String region)
//    {
//        return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
//    }

//    @GetMapping(value = "/distilleries/whisky")
//    public ResponseEntity<List<Distillery>> getDistilleryByWhiskyAge(
//            @RequestParam(name = "age") int age){
//        return new ResponseEntity<>(distilleryRepository.findDistilleryByWhiskiesAge(age), HttpStatus.OK);
//    }


}
