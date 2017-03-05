package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class Movie {

    @GraphId
    Long id;
    String title;
    String tagline;
    Person director;

    @Relationship(type="ACTS_IN", direction = Relationship.INCOMING)
    Set<Person> actors;

    public String getTitle() {
        return title;
    }

    public String getTagline() {
        return tagline;
    }
}
