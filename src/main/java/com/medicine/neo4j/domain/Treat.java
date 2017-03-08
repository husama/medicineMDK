package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="TREAT")
public class Treat {
    @GraphId
    Long id;
    @StartNode
    Disease disease;
    @EndNode
    Treatment treatment;

    private int weight;//权值

    public Treat(){
        weight=0;
    }

    public Treat(Disease disease,Treatment treatment,int weight){
        this();
        this.disease=disease;
        this.treatment=treatment;
        this.weight+=weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
