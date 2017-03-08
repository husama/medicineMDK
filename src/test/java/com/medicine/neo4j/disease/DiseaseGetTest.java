package com.medicine.neo4j.disease;

import com.medicine.neo4j.domain.*;
import com.medicine.neo4j.service.DiseaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.DiseaseServiceImpl.class
        ,com.medicine.neo4j.dao.DiseaseRepository.class})
public class DiseaseGetTest {
  //  private static Logger logger = Logger.getLogger(com.medicine.neo4j.NeoTest.class);
    @Autowired
    DiseaseService diseaseService;

    @Test
    public void test1() {

       /* Disease disease=new Disease();
        Symptom symptom=new Symptom();
        Symptom symptom1=new Symptom();
        Treatment treatment=new Treatment();
        Alias alias=new Alias();

        IsAliasOf isAliasOf=new IsAliasOf();
        Appear appear=new Appear();
        Treat treat=new Treat();

        disease.setName("发烧");

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
        */
        Disease temp=diseaseService.findDiseaseByName("发烧");
        Iterator it=temp.getAppears().iterator();
        while(it.hasNext()) {
                Symptom symptom=((Appear) it.next()).getSymptom();
                System.out.println("症状:"+symptom.getName()+"   "+symptom.getId());
          }
        it=temp.getTreats().iterator();
        while(it.hasNext()){
               Treatment treatment=((Treat)it.next()).getTreatment();
               System.out.println("治疗:"+treatment.getName()+"   "+treatment.getId());
        }
        it=temp.getIsAliasOfs().iterator();
        while(it.hasNext()){
            Alias alias=((IsAliasOf)it.next()).getAlias();
            System.out.println("别名:"+alias.getName()+"    "+alias.getId());
        }
        //  System.out.println("GoogleProfile created successfully.");
    }
}

