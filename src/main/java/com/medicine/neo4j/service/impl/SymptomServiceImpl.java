package com.medicine.neo4j.service.impl;


import com.medicine.neo4j.dao.SymptomRepository;
import com.medicine.neo4j.domain.Symptom;
import com.medicine.neo4j.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "symptomService")
public class SymptomServiceImpl implements SymptomService{

    @Autowired
    private SymptomRepository symptomRepository;
    public Symptom save(Symptom symptom){
        Symptom temp=symptomRepository.findByName(symptom.getName());
        if(temp==null)
            return symptomRepository.save(symptom);
        return temp;
    }
}
