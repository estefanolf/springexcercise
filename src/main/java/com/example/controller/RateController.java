package com.example.controller;

import com.example.model.Rate;
import com.example.service.RateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Rate Controller", tags = "Rate Controller")
@RestController
@RequestMapping(name = "/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @ApiOperation("Find all Rates")
    @GetMapping
    public ResponseEntity<List<Rate>> findAll(){
        return new ResponseEntity<>(rateService.findAll(), HttpStatus.OK);
    }

    @ApiOperation("Find Rate by ID")
    @GetMapping("/{id}")
    public Rate findById(@PathVariable Integer id){
        return rateService.findById(id);
    }

    @ApiOperation("Create Rate")
    @PostMapping
    public ResponseEntity<Rate> create(@RequestBody Rate rate){
        return new ResponseEntity<>(rateService.save(rate), HttpStatus.CREATED);
    }

    @ApiOperation("Delete a Rate by ID")
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        rateService.delete(id);
    }

}
