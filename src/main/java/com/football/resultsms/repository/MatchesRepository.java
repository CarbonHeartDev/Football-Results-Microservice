package com.football.resultsms.repository;

import com.football.resultsms.entity.Match;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MatchesRepository extends R2dbcRepository<Match, Long> {
    Flux<Match> findByHomeTeam(String homeTeam);
    Flux<Match> findByAwayTeam(String awayTeam);
}
