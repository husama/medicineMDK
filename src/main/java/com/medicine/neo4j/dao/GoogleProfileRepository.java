package com.medicine.neo4j.dao;

import com.medicine.neo4j.domain.GoogleProfile;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoogleProfileRepository extends GraphRepository<GoogleProfile>{

    @Query("START product=node(*) " +
            "WHERE HAS (product.productName)" +
            "RETURN product " +
            "ORDER BY product.productName")
    List<GoogleProfile> findAllProductsSortedByName();
    List<GoogleProfile> findByName(String name);
    List<GoogleProfile> findByNameLike(String name);
}