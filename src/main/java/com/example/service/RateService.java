package com.example.service;

import com.example.model.Rate;
import com.example.repository.RateRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    public Rate save(Rate rate){
        return rateRepository.saveAndFlush(rate);
    }

    public Rate update(Integer id, Rate rate){
        rate = findById(id);
        return rateRepository.saveAndFlush(rate);


    }

    public Rate findById(Integer id){
        return rateRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT, "No Rates founded with this ID"));
    }

    public List<Rate> findAll(){
        return rateRepository.findAll();
    }

    public void delete(Integer id){
        rateRepository.deleteById(id);
    }
}
