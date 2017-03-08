package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.IsAliasOf;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsAliasOfRepository  extends GraphRepository<IsAliasOf>{

}
