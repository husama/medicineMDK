package com.medicine.neo4j.service.impl;

import com.medicine.neo4j.dao.GoogleProfileRepository;
import com.medicine.neo4j.dao.MovieRepository;
import com.medicine.neo4j.domain.GoogleProfile;
import com.medicine.neo4j.domain.Movie;
import com.medicine.neo4j.service.GoogleProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("googleProfileService")
public class GoogleProfileServiceImpl implements GoogleProfileService {

    @Autowired
    private GoogleProfileRepository googleProfileRepository;

    @Autowired
    private MovieRepository movieRepository;

    public GoogleProfile create(GoogleProfile profile) {
        return googleProfileRepository.save(profile);
    }

    public void delete(GoogleProfile profile) {
        googleProfileRepository.delete(profile);
    }

    public GoogleProfile findById(long id) {
        return googleProfileRepository.findOne(id);
    }

    public Iterable<GoogleProfile> findAll() {
        return googleProfileRepository.findAll();
    }
    public Movie find(String title){
        return movieRepository.getMovieFromTitle(title);
    }
}