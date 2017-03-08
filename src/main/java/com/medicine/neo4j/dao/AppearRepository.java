package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.Appear;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearRepository extends GraphRepository<Appear>{

}
