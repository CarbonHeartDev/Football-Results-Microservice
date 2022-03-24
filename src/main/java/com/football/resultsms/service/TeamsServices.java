package com.football.resultsms.service;

import com.football.resultsms.entity.Team;
import com.football.resultsms.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TeamsServices {

    @Autowired
    private TeamsRepository teamsRepository;

    public Flux<Team> getAllTeams() {
        return teamsRepository.findAll();
    }
}
