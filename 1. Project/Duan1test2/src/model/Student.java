package model;

import java.util.List;

public class Student {
	private String student_id;
	private String student_name;
	private List<Score> lstScore;

	public Student() {
		super();
	}

	public Student(String student_id, String student_name, List<Score> lstScore) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.lstScore = lstScore;
	}

	public Student(String student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public List<Score> getLstScore() {
		return lstScore;
	}

	public void setLstScore(List<Score> lstScore) {
		this.lstScore = lstScore;
	}

}
