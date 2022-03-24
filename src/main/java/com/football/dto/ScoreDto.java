package com.football.dto;

public class ScoreDto {

	String teamName;

	Integer score;

	public ScoreDto() {
		super();
	}

	public ScoreDto(String teamName, Integer score) {
		super();
		this.teamName = teamName;
		this.score = score;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
