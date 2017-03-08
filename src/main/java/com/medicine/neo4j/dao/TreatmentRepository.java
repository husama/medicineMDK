package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.Treat;
import com.medicine.neo4j.domain.Treatment;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends GraphRepository<Treatment>{

    Treatment findByName(String name);

    @Query("MATCH (disease:Disease)-[r:TREAT]->(treatment) where ID(disease)={0} AND ID(treatment)={1} RETURN r")
    Treat findTreatmentForDisease(long diseaseId, long treatmentId);
}
