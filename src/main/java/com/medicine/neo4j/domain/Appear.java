package com.medicine.neo4j.domain;


import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type="APPEAR")
public class Appear {
    @GraphId
    Long id;
    @StartNode
    Disease disease;
    @EndNode
    Symptom symptom;
    @Property
    private int weight;//权值

    public Appear(){
        weight=0;
    }

    public Appear(Disease disease,Symptom symptom,int weight){
        this();
        this.disease=disease;
        this.symptom=symptom;
        this.weight+=weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appear appear = (Appear) o;

        if (disease != null ? !disease.equals(appear.disease) : appear.disease != null) return false;
        return symptom != null ? symptom.equals(appear.symptom) : appear.symptom == null;
    }

    @Override
    public int hashCode() {
        int result = disease != null ? disease.hashCode() : 0;
        result = 31 * result + (symptom != null ? symptom.hashCode() : 0);
        return result;
    }
}
