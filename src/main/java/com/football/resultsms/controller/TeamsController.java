package com.football.resultsms.controller;

import com.football.resultsms.entity.Team;
import com.football.resultsms.service.TeamsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/team")
public class TeamsController {

    @Autowired
    TeamsServices teamsServices;

    @GetMapping
    public Flux<Team> handleGetAll() {
        return teamsServices.getAllTeams();
    }
}