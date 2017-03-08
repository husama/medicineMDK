package com.medicine.neo4j.disease;

import com.medicine.neo4j.domain.Alias;
import com.medicine.neo4j.domain.Disease;
import com.medicine.neo4j.domain.Symptom;
import com.medicine.neo4j.domain.Treatment;
import com.medicine.neo4j.service.DiseaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.DiseaseServiceImpl.class
        ,com.medicine.neo4j.dao.DiseaseRepository.class})
public class DiseaseAddTest1 {
   // private static Logger logger = Logger.getLogger(com.medicine.neo4j.NeoTest.class);
    @Autowired
    DiseaseService diseaseService;

    @Test
    public void test1() {
        Disease disease=new Disease("感冒");
        Symptom symptom=new Symptom("四肢乏力");
        Symptom symptom1=new Symptom("无力");
        Treatment treatment=new Treatment("喝热水");
        Alias alias=new Alias("流行性感冒");

        List<Alias> aliases=new LinkedList<Alias>();
        List<Symptom> symptoms=new LinkedList<Symptom>();
        List<Treatment> treatments=new LinkedList<Treatment>();
        aliases.add(alias);
        symptoms.add(symptom);
        symptoms.add(symptom1);
        treatments.add(treatment);

        diseaseService.save(disease,symptoms,treatments,aliases);
        /*Disease disease=new Disease();
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
      //  symptom1.setName("1");
   //     alias.setName("发热");
    //    symptom.setName("3");
     //   treatment.setName("4");

        Set<Alias> aliases=new HashSet<Alias>();
        Set<Symptom> symptoms=new HashSet<Symptom>();
        Set<Treatment> treatments=new HashSet<Treatment>();
        aliases.add(alias);
        symptoms.add(symptom);
        symptoms.add(symptom1);
        treatments.add(treatment);

        disease.setAliases(aliases);
        disease.setSymptoms(symptoms);
        disease.setTreatments(treatments);*/
    }
}
