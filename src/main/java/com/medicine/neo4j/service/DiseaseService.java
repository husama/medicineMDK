package com.medicine.neo4j.service;


import com.medicine.neo4j.domain.Alias;
import com.medicine.neo4j.domain.Disease;
import com.medicine.neo4j.domain.Symptom;
import com.medicine.neo4j.domain.Treatment;

import java.util.List;

public interface DiseaseService {
    public Disease save(Disease disease);
    public Disease save(Disease disease, List<Symptom> symptoms, List<Treatment> treatments, List<Alias> aliases);
    public Disease findDiseaseByName(String name);
}
