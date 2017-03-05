package com.medicine.neo4j.service;


import com.medicine.neo4j.domain.Disease;

public interface DiseaseService {
    public void save(Disease disease);
    public Disease findDiseaseByName(String name);
}
