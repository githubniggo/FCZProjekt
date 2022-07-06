package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielerRepository extends CrudRepository<Spieler, Long>{

}