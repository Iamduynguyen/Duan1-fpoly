package model;

public class Enrolment {
	private String student_id;
	private int course_id;
	private boolean eligibility;

	public Enrolment() {
		super();
	}

	public Enrolment(String student_id, int course_id, boolean eligibility) {
		super();
		this.student_id = student_id;
		this.course_id = course_id;
		this.eligibility = eligibility;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}
	

}
