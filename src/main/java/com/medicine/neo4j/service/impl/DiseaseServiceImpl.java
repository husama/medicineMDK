package com.medicine.neo4j.service.impl;


import com.medicine.neo4j.dao.*;
import com.medicine.neo4j.domain.*;
import com.medicine.neo4j.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service(value = "diseaseService")
public class DiseaseServiceImpl implements DiseaseService{
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Autowired
    private SymptomRepository symptomRepository;
    @Autowired
    private AliasRepository aliasRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private AppearRepository appearRepository;
    @Autowired
    private TreatRepository treatRepository;
    @Autowired
    private IsAliasOfRepository isAliasOfRepository;

    public Disease save(Disease disease) {
        Disease temp=diseaseRepository.findByName(disease.getName());
        if(temp==null) {
            return diseaseRepository.save(disease);
        }
        return temp;
    }

    public Disease save(Disease disease, List<Symptom> symptoms, List<Treatment> treatments, List<Alias> aliases) {
        disease=this.save(disease);
        //保存symptom
        Iterator it = symptoms.iterator();
        while (it.hasNext()) {
            Symptom symptom=(Symptom) it.next();
            Symptom temp=symptomRepository.findByName(symptom.getName());
            if(temp==null) {//如果不存在节点
                symptom = symptomRepository.save(symptom);
                Appear appear=new Appear(disease,symptom,1);
                appearRepository.save(appear);
            }
            else {//如果存在节点
                symptom = temp;
                Appear saveAppear=symptomRepository.findSymptomAppearForDisease(disease.getId(),symptom.getId());
                if(saveAppear==null)
                    saveAppear=new Appear(disease,symptom,1);
                else
                    saveAppear.setWeight(saveAppear.getWeight()+1);
                appearRepository.save(saveAppear);
            }
        }
        //保存treatment
        it=treatments.iterator();
        while(it.hasNext()){
            Treatment treatment=(Treatment)it.next();
            Treatment temp=treatmentRepository.findByName(treatment.getName());
            if(temp==null){
                treatment=treatmentRepository.save(treatment);
                Treat treat=new Treat(disease,treatment,1);
                treatRepository.save(treat);
            }
            else{
                treatment=temp;
                Treat saveTreat=treatmentRepository.findTreatmentForDisease(disease.getId(),treatment.getId());
                if(saveTreat==null)
                    saveTreat=new Treat(disease,treatment,1);
                else
                    saveTreat.setWeight(saveTreat.getWeight()+1);
                treatRepository.save(saveTreat);
            }
        }
        //保存alias
        it= aliases.iterator();
        while(it.hasNext()){
            Alias alias=(Alias)it.next();
            Alias temp=aliasRepository.findByName(alias.getName());
            if(temp==null){
                alias=aliasRepository.save(alias);
                IsAliasOf isAliasOf=new IsAliasOf(disease,alias,1);
                isAliasOfRepository.save(isAliasOf);
            }
            else{
                alias=temp;
                IsAliasOf saveIsAliasOf=aliasRepository.findAliasForDisease(disease.getId(),alias.getId());
                if(saveIsAliasOf==null)
                    saveIsAliasOf=new IsAliasOf(disease,alias,1);
                else
                    saveIsAliasOf.setWeight(saveIsAliasOf.getWeight()+1);
                isAliasOfRepository.save(saveIsAliasOf);
            }
        }

        return null;
    }

    @Override
    public Disease findDiseaseByName(String name) {
     //   return diseaseRepository.findDisease(name);
        return  diseaseRepository.findByName(name);
    }
}
