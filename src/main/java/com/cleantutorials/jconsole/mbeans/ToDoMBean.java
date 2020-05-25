package com.cleantutorials.jconsole.mbeans;

public interface ToDoMBean {

	public void storeTask(String taskName);

	public String getTask();

	public int getTasksLeft();
}
