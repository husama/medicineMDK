package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="IS_ALIAS_OF")
public class IsAliasOf {
    @GraphId
    Long id;
    @StartNode
    Disease disease;
    @EndNode
    Alias alias;

    private int weight;//权值

    public IsAliasOf(){
        weight=0;
    }

    public IsAliasOf(Disease disease,Alias alias,int weight){
        this();
        this.disease=disease;
        this.alias=alias;
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

    public Alias getAlias() {
        return alias;
    }

    public void setAlias(Alias alias) {
        this.alias = alias;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
