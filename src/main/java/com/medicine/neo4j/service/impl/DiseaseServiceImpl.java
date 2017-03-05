package com.medicine.neo4j.service.impl;


import com.medicine.neo4j.dao.DiseaseRepository;
import com.medicine.neo4j.domain.Disease;
import com.medicine.neo4j.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "diseaseService")
public class DiseaseServiceImpl implements DiseaseService{

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public void save(Disease disease) {
        Disease savedDisease;
        Disease temp=diseaseRepository.findByName(disease.getName());
        if(temp==null) {
            diseaseRepository.save(disease);
            return ;
        }

        temp.getAliases().addAll(disease.getAliases());
        temp.getSymptoms().addAll(disease.getSymptoms());
        temp.getTreatments().addAll(disease.getTreatments());
        diseaseRepository.save(temp);
    }

    @Override
    public Disease findDiseaseByName(String name) {
     //   return diseaseRepository.findDisease(name);
        return  diseaseRepository.findByName(name);
    }
}
