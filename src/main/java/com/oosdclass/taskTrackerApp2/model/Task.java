package com.oosdclass.taskTrackerApp2.model;

public class Task {

	private int taskId;

	private String description;

	private String status;

	private String assignedTo;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskID(int taskID) {
		this.taskId = taskID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

}