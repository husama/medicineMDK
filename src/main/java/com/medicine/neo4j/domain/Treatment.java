package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Treatment {
    @GraphId
    Long id;
    private String name;

    @Relationship(type="TREAT", direction = Relationship.INCOMING)
    Set<Treat> treats=new HashSet<Treat>();

    public Treatment(){

    }

    public Treatment(String name){
        this();
        this.name=name;
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
    public Set<Treat> getTreats() {
        return treats;
    }

    @Relationship(type="APPEAR", direction = Relationship.INCOMING)
    public void setTreats(Set<Treat> treats) {
        this.treats = treats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treatment treatment = (Treatment) o;

        return name != null ? name.equals(treatment.name) : treatment.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
