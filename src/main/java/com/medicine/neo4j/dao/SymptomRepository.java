package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.Appear;
import com.medicine.neo4j.domain.Symptom;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends GraphRepository<Symptom>{

    Symptom findByName(String name);

    @Query("MATCH (disease:Disease)-[r:APPEAR]->(symptom) where ID(disease)={0} AND ID(symptom)={1} RETURN r")
    Appear findSymptomAppearForDisease(long DiseaseId, long SymptomId);
}
