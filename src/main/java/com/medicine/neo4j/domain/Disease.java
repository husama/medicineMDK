package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Disease {
    @GraphId
    Long id;

    String name;

    @Relationship(type="APPEAR", direction = Relationship.OUTGOING)
    Set<Symptom> symptoms;
    @Relationship(type="TREAT", direction = Relationship.OUTGOING)
    Set<Treatment> treatments;
    @Relationship(type="IS_ALIAS_OF", direction = Relationship.OUTGOING)
    Set<Alias> aliases;

    public Disease(){
        symptoms=new HashSet<Symptom>();
        treatments=new HashSet<Treatment>();
        aliases=new HashSet<Alias>();
    }

    public Disease(String name){
        this();
        this.name=name;
    }

    public void addSymptom(String name){
        symptoms.add(new Symptom(name));
    }

    public void addTreatment(String name){
        treatments.add(new Treatment(name));
    }

    public void addAlias(String name){
        aliases.add(new Alias(name));
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

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Set<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(Set<Alias> aliases) {
        this.aliases = aliases;
    }
}
