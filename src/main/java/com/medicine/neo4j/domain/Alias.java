package com.medicine.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Alias {
    @GraphId
    Long id;
    private String name;

    @Relationship(type="IS_ALIAS_OF", direction = Relationship.INCOMING)
    Set<IsAliasOf> isAliasOfs=new HashSet<IsAliasOf>();

    public Alias(){
    }

    public Alias(String name){
        this(); //lalala
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

    @Relationship(type="IS_ALIAS_OF", direction = Relationship.INCOMING)
    public Set<IsAliasOf> getIsAliasOfs() {
        return isAliasOfs;
    }

    @Relationship(type="IS_ALIAS_OF", direction = Relationship.INCOMING)
    public void setIsAliasOfs(Set<IsAliasOf> isAliasOfs) {
        this.isAliasOfs = isAliasOfs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alias alias = (Alias) o;

        return name != null ? name.equals(alias.name) : alias.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
