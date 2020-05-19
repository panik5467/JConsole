package com.cleantutorials.jconsole.jmx;

public interface JMXTutorialMBean {

	public int getNoOfStudents(); // Reading the value of the attribute (Getter method)

	public void setNoOfStudents(int x); // Writing the value of the attribute (Setter Method)

	public void incrementNoOfStudents(); // Any operation

}
