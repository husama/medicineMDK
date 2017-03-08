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

    private String name;

    @Relationship(type="APPEAR", direction = Relationship.OUTGOING)
    Set<Appear> appears=new HashSet<Appear>();
    @Relationship(type="TREAT", direction = Relationship.OUTGOING)
    Set<Treat> treats=new HashSet<Treat>();
    @Relationship(type="IS_ALIAS_OF", direction = Relationship.OUTGOING)
    Set<IsAliasOf> isAliasOfs=new HashSet<IsAliasOf>();

    public Disease(){
    }

    public Disease(String name){
        this();
        this.name=name;
    }

    public void addIsAliasOf(IsAliasOf isAliasOf){
        isAliasOfs.add(isAliasOf);
    }
    public  void addIsAliasOf(String name){
        isAliasOfs.add(new IsAliasOf(this,new Alias(name),1));
    }

    public void addAppear(Appear appear){
        appears.add(appear);
    }
    public void addAppear(String name){
        appears.add(new Appear(this,new Symptom(name),1));
    }

    public void addTreat(Treat treat){
        treats.add(treat);
    }
    public void addTreat(String name){
        treats.add(new Treat(this,new Treatment(name),1));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        return name != null ? name.equals(disease.name) : disease.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
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

    @Relationship(type="APPEAR", direction = Relationship.OUTGOING)
    public Set<Appear> getAppears() {
        return appears;
    }

    @Relationship(type="APPEAR", direction = Relationship.OUTGOING)
    public void setAppears(Set<Appear> appears) {
        this.appears = appears;
    }

    @Relationship(type="TREAT", direction = Relationship.OUTGOING)
    public Set<Treat> getTreats() {
        return treats;
    }

    @Relationship(type="TREAT", direction = Relationship.OUTGOING)
    public void setTreats(Set<Treat> treats) {
        this.treats = treats;
    }

    @Relationship(type="IS_ALIAS_OF", direction = Relationship.OUTGOING)
    public Set<IsAliasOf> getIsAliasOfs() {
        return isAliasOfs;
    }

    @Relationship(type="IS_ALIAS_OF", direction = Relationship.OUTGOING)
    public void setIsAliasOfs(Set<IsAliasOf> isAliasOfs) {
        this.isAliasOfs = isAliasOfs;
    }
}
