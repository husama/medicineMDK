package com.medicine.neo4j.disease;

import com.medicine.neo4j.dao.DiseaseRepository;
import com.medicine.neo4j.domain.*;
import com.medicine.neo4j.service.DiseaseService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.DiseaseServiceImpl.class
        ,com.medicine.neo4j.dao.DiseaseRepository.class})
public class DiseaseAddTest {
    private static Logger logger = Logger.getLogger(com.medicine.neo4j.NeoTest.class);
    @Autowired
    DiseaseService diseaseService;
    @Autowired
    DiseaseRepository diseaseRepository;

    @Test
    public void test1() {

        Disease disease=new Disease();
        Symptom symptom=new Symptom();
        Symptom symptom1=new Symptom();
        Treatment treatment=new Treatment();
        Alias alias=new Alias();

        Appear appear=new Appear(2);
        IsAliasOf isAliasOf=new IsAliasOf(3);
        Treat treat=new Treat(4);

        disease.setName("发烧");
         alias.setName("发热");
        symptom.setName("无力");
        symptom1.setName("累");
        treatment.setName("喝热水");
      /*  symptom1.setName("1");
        alias.setName("发热");
        symptom.setName("3");
        treatment.setName("4");*/

        Set<Alias> aliases=new HashSet<Alias>();
        Set<Symptom> symptoms=new HashSet<Symptom>();
        Set<Treatment> treatments=new HashSet<Treatment>();
        aliases.add(alias);
        symptoms.add(symptom);
        symptoms.add(symptom1);
        treatments.add(treatment);

        disease.setAliases(aliases);
        disease.setSymptoms(symptoms);
        disease.setTreatments(treatments);

        diseaseService.save(disease);

     //   Disease temp=diseaseService.findDiseaseByName("发烧");
      //  for (Symptom s : temp.getSymptoms()) {
    //        System.out.println("症状:"+s.getType()+s.getId());
      //  }
      //  for(Treatment t: temp.getTreatments()){
     //       System.out.println("治疗:"+t.getMethod()+t.getId());
      //  }
      //  System.out.println("GoogleProfile created successfully.");
    }
}
