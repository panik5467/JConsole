package com.cleantutorials.jconsole.jmx;

public class JMXTutorial implements JMXTutorialMBean {
	private int noOfStudents;

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public void incrementNoOfStudents() {
		noOfStudents++;
	}
}
