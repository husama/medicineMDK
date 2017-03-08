package com.medicine.neo4j.dao;


import com.medicine.neo4j.domain.Alias;
import com.medicine.neo4j.domain.IsAliasOf;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository  extends GraphRepository<Alias>{

    Alias findByName(String name);

    @Query("MATCH (disease:Disease)-[r:IS_ALIAS_OF]->(alias) where ID(disease)={0} AND ID(alias)={1} RETURN r")
    IsAliasOf findAliasForDisease(long diseaseId, long aliasId);
}
