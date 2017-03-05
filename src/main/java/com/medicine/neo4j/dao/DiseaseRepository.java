package com.medicine.neo4j.dao;


import com.medicine.neo4j.domain.Disease;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends GraphRepository<Disease> {

    @Query("match (disease:Disease)-[:APPEAR]->(symptoms) match (disease:Disease)-[:TREAT]->(treatments) where disease.name={0} return disease,symptoms,treatments")
    Disease findDisease(String name);

    Disease findByName(String name);

 //   Disease loadByProperty(String namespace, String id, Object o);

}
