package com.medicine.neo4j.service;

import com.medicine.neo4j.domain.GoogleProfile;
import com.medicine.neo4j.domain.Movie;

public interface GoogleProfileService {

    GoogleProfile create(GoogleProfile profile);
    void delete(GoogleProfile profile);
    GoogleProfile findById(long id);
    Iterable<GoogleProfile> findAll();
    Movie find(String title);
}