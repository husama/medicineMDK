package com.medicine.neo4j;

import com.medicine.neo4j.domain.GoogleProfile;
import com.medicine.neo4j.domain.Movie;
import com.medicine.neo4j.service.GoogleProfileService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.GoogleProfileServiceImpl.class
            ,com.medicine.neo4j.dao.GoogleProfileRepository.class})
public class NeoTest {
    private static Logger logger = Logger.getLogger(com.medicine.neo4j.NeoTest.class);
    @Autowired
    GoogleProfileService googleProfileService ;
  //  @Autowired
   // GoogleProfileRepository googleProfileRepository;

    @Test
    public void test1() {
    //    GoogleProfile profile = createPofile();
     //   createProfile(googleProfileService,profile);
        Movie m=googleProfileService.find("The Matrix");
        if(m!=null)
            System.out.println(m.getTagline());
        System.out.println("GoogleProfile created successfully.");
    }


    private static GoogleProfile createProfile(GoogleProfileService service, GoogleProfile profile){
        return service.create(profile);
    }

    private static void deleteProfile(GoogleProfileService service,GoogleProfile profile){
        service.delete(profile);
    }

    private static GoogleProfile getOneProfileById(GoogleProfileService service,Long id){
        return service.findById(id);
    }

    private static void getAllProfiles(GoogleProfileService service){
        Iterable<GoogleProfile> result = service.findAll();
        Iterator<GoogleProfile> iterator = result.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static GoogleProfile createPofile(){
        GoogleProfile profile = new GoogleProfile();
        profile.setName("Profile-2");
        profile.setAddress("Hyderabad");
        profile.setSex("Male");
        profile.setDob("02/02/1980");
        return profile;
    }
}