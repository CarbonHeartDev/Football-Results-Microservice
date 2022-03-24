package com.football.resultsms.controller;

import com.football.resultsms.entity.Match;
import com.football.resultsms.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/match")
public class MatchesController {

    @Autowired
    MatchesService matchesService;

    @GetMapping
    public Flux<Match> handleGetByTeam(@RequestParam(required = false) String team) {
        return (team == null) ?
                matchesService.getAllMatches() :
                matchesService.getMatchesFromTeam(team);
    }

    @GetMapping("/{id}")
    public Mono<Match> handleGetMatch(@PathVariable Long id) {
        return matchesService.getMatchById(id);
    }
}