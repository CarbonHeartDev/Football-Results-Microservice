package com.football.resultsms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.dto.ScoreDto;
import com.football.resultsms.repository.MatchesRepository;
import com.football.resultsms.repository.TeamsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StatisticsService {

	@Autowired
	private TeamsRepository teamRepository;
	@Autowired
	private MatchesRepository matchesRepository;

	public Mono<Integer> calculateScore(String team) {

		return Flux.concat(matchesRepository.findByHomeTeam(team), matchesRepository.findByAwayTeam(team))
				.map(match -> {
					if (match.getHomeTeam().equalsIgnoreCase(team)) {
						return StatisticsService.calculateResult(match.getHomeScore(), match.getAwayScore());
					} else {
						return StatisticsService.calculateResult(match.getAwayScore(), match.getHomeScore());
					}
				}).reduce(0, (accumulator, current) -> accumulator + current);
	}

	private static Integer calculateResult(Integer yourGoals, Integer theirGoals) {
		if (yourGoals > theirGoals) {
			return 3;
		} else if (yourGoals < theirGoals) {
			return 0;
		} else {
			return 1;
		}
	}

	public Flux<ScoreDto> allTeamScore() {
		return teamRepository.findAll().flatMap(team -> {
			return this.calculateScore(team.getName()).map(score -> new ScoreDto(team.getName(), score));
		}).sort((a, b) -> b.getScore() - a.getScore());
	}

}
