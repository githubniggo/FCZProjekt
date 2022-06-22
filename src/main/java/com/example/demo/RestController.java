package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private SpielerRepository spielerRepository;
    
    @GetMapping("/Spieler")

    public List<Spieler> GetPlayers(){
        return (List<Spieler>) spielerRepository.findAll();


    }

    @GetMapping("/Spieler/{id}")

    public Spieler GetPlayersById(@PathVariable long id){
        return spielerRepository.findById(id).get();

    }
}
