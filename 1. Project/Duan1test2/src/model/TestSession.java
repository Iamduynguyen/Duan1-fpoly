package model;

public class TestSession {
	private int course_id;
	private String test_date;
	private int testperiod_id;
	private String test_room;
	private String test_format;
	private String supervisor1_name, supervisor2_name;
	
	public TestSession() {
		super();
	}
	public TestSession(int course_id, String test_date, int testperiod_id, String test_room, String test_format,
			String supervisor1_name, String supervisor2_name) {
		super();
		this.course_id = course_id;
		this.test_date = test_date;
		this.testperiod_id = testperiod_id;
		this.test_room = test_room;
		this.test_format = test_format;
		this.supervisor1_name = supervisor1_name;
		this.supervisor2_name = supervisor2_name;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getTest_date() {
		return test_date;
	}
	public void setTest_date(String test_date) {
		this.test_date = test_date;
	}
	public int getTestperiod_id() {
		return testperiod_id;
	}
	public void setTestperiod_id(int testperiod_id) {
		this.testperiod_id = testperiod_id;
	}
	public String getTest_room() {
		return test_room;
	}
	public void setTest_room(String test_room) {
		this.test_room = test_room;
	}
	public String getTest_format() {
		return test_format;
	}
	public void setTest_format(String test_format) {
		this.test_format = test_format;
	}
	public String getSupervisor1_name() {
		return supervisor1_name;
	}
	public void setSupervisor1_name(String supervisor1_name) {
		this.supervisor1_name = supervisor1_name;
	}
	public String getSupervisor2_name() {
		return supervisor2_name;
	}
	public void setSupervisor2_name(String supervisor2_name) {
		this.supervisor2_name = supervisor2_name;
	}
	
	
}
