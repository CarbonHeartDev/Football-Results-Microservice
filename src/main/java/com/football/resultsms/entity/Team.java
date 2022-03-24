package com.football.resultsms.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("teams")
public class Team {

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
