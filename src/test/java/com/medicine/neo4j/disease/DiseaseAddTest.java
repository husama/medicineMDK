package com.medicine.neo4j.disease;

import com.medicine.neo4j.domain.Disease;
import com.medicine.neo4j.service.DiseaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.DiseaseServiceImpl.class
        ,com.medicine.neo4j.dao.DiseaseRepository.class})
public class DiseaseAddTest {
    //rivate static Logger logger = Logger.getLogger(com.medicine.neo4j.NeoTest.class);
    @Autowired
    DiseaseService diseaseService;

    @Test
    public void test1() {
        Disease disease=new Disease("发烧");
        disease.addAppear("发热");
        disease.addIsAliasOf("高烧");
        disease.addAppear("无力");
        disease.addTreat("喝热水");

        diseaseService.save(disease);
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
