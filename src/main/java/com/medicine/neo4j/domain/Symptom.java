package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Symptom {
    @GraphId
    Long id;
    private String name;

    @Relationship(type="APPEAR", direction = Relationship.INCOMING)
    Set<Appear> appears;
    public Symptom(){
        appears=new HashSet<Appear>();
    }

    public Symptom(String name){
        this();
        this.name=name;
    }

    public Appear relate(Disease disease,int weight) {
        Appear appear = new Appear(disease, this, 1);
        appears.add(appear);
        disease.addAppear(appear);
        return appear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Relationship(type="APPEAR", direction = Relationship.INCOMING)
    public Set<Appear> getAppears() {
        return appears;
    }

    @Relationship(type="APPEAR", direction = Relationship.INCOMING)
    public void setAppears(Set<Appear> appears) {
        this.appears = appears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symptom symptom = (Symptom) o;

        return name != null ? name.equals(symptom.name) : symptom.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
