package com.football.dto;

public class BaseStatsDto {
	
	public BaseStatsDto() {
		super();
	}
	
	public Integer getGoalsTook() {
		return goalsTook;
	}

	public void setGoalsTook(Integer goalsTook) {
		this.goalsTook = goalsTook;
	}

	public Integer getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}

	public BaseStatsDto(Integer goalsScored, Integer goalsTook) {
		super();
		this.goalsTook = goalsTook;
		this.goalsScored = goalsScored;
	}

	private Integer goalsTook;

	private Integer goalsScored;
	
	public Integer getGoalsDiff() {
		return this.goalsScored - this.goalsTook;
	}
}
