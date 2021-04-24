package model;

public class Score {
	private int score_name;
	private double score_value;
	public Score() {
		super();
	}
	public Score(int score_name, double score_value) {
		super();
		this.score_name = score_name;
		this.score_value = score_value;
	}
	public int getScore_name() {
		return score_name;
	}
	public void setScore_name(int score_name) {
		this.score_name = score_name;
	}
	public double getScore_value() {
		return score_value;
	}
	public void setScore_value(double score_value) {
		this.score_value = score_value;
	}
	
	
}
