package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.Treat;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatRepository extends GraphRepository<Treat>{

}
