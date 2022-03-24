package com.football.resultsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.dto.BaseStatsDto;
import com.football.dto.ScoreDto;
import com.football.resultsms.service.StatisticsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statistic")
public class StatisticsController {
@Autowired
StatisticsService statisticsService;

@GetMapping("/score/{team}")
public Mono<Integer> handleGetScore(@PathVariable String team) {
    return statisticsService.calculateScore(team);
}	

@GetMapping("/score")
public Flux<ScoreDto> handleGetAllScore() {
    return statisticsService.allTeamScore();
}

@GetMapping("/goals/{team}")
public Mono<BaseStatsDto> handleGalculateGoalsDiff(@PathVariable String team) {
	return statisticsService.calculateGoalsDiff(team);
}
}

