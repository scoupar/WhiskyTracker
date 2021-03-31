package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(
        @RequestParam(name = "year") int year){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value ="/whiskies/age/distillery")
    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryAndAge(
            @RequestParam(name = "distillery") String name,
            @RequestParam(name = "age") int age)
    {
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryRegion(
            @RequestParam(name = "region") String region){
                return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
    }


}




