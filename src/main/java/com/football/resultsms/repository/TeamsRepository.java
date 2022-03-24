package com.football.resultsms.repository;

import com.football.resultsms.entity.Team;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends R2dbcRepository<Team, String> {
}
