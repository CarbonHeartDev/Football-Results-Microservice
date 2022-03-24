package com.football.resultsms.service;

import com.football.resultsms.entity.Match;
import com.football.resultsms.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;

    public Flux<Match> getAllMatches() {
        return matchesRepository.findAll();
    }

    public Flux<Match> getMatchesFromTeam(String team) {
        return Flux.concat(
                matchesRepository.findByHomeTeam(team),
                matchesRepository.findByAwayTeam(team)
        );
    }

    public Mono<Match> getMatchById(Long id) {
        return matchesRepository.findById(id);
    }

}