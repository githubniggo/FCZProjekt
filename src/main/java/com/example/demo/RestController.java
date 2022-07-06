package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http://localhost:3000")
public class RestController {
    @Autowired
    private SpielerRepository spielerRepository;
    @GetMapping("/Spieler")
    public List<Spieler> GetPlayers(){
        return (List<Spieler>) spielerRepository.findAll();
    }
    @GetMapping("/Spieler/{id}")
    public Spieler GetPlayersById(@PathVariable int id){
        return GetPlayers().stream()
                .filter(spieler -> spieler.getId() == id)
                .findFirst()
                .get();
        //return spielerRepository.findById((long) id).get();

    }

    @PostMapping("/Spieler")
    public Spieler createPlayer(@RequestBody Spieler spieler) {
        int newId = GetPlayers().stream()
                .max((t1,t2) -> Integer.compare(t1.getId(), t2.getId()))
                .get()
                .getId()+1;
        spieler.setId(newId);
        System.out.println(spieler.toString());
        spielerRepository.save(spieler);
        return spieler;
    }
}
