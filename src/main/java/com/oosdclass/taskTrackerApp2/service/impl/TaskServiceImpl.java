package com.oosdclass.taskTrackerApp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	public static final String DEFAULT_STATUS = "OPEN";
	public static final String DEFAULT_ASSIGNED = "UNASSIGNED";

	@Autowired
	TaskDAO taskdao;

	@Override
	public List<Task> getAllTask() {
		return taskdao.retrieveAllTasks();
	}

	// to be replaced by whatever the service layer creates - this is my attempt at
	// the service layer!
	@Override
	public void saveTask(Task task) {
		task.setStatus(DEFAULT_STATUS);
		task.setAssignedTo(DEFAULT_ASSIGNED);
		taskdao.saveTask(task);

	}

	@Override
	public Task getTaskById(int taskId) {
		return taskdao.retrieveByTaskID(taskId);
	}
	
	//These are the methods to update the task (using the buttons)
	//the controller and service have two separate methods for updating task: specific to STATUS and ASSIGNEDTO
	//both these methods will invoke ONLY ONE method in the DAO: TaskDAO.UpdateTask
		//Update the status: these attributes were originally stored in the URL
	@Override
	public void updateTaskStatus(int taskID, String status, String username) {
		Task task = taskdao.retrieveByTaskID(taskID);
		task.setStatus(status);
		//send to ONE METHOD in the DAO
		taskdao.updateTask(task);
	}
		
	//Update the assignedTo: these attributes were originally stored in the URL
	@Override
	public void updateTaskAssignedTo(int taskID, String username) {
		Task task = taskdao.retrieveByTaskID(taskID);
		task.setAssignedTo(username);
		// send to ONE METHOD in the DAO
		taskdao.updateTask(task);

	}
	@Override
	public void deleteTask(int taskID) {
		taskdao.deleteTask(taskID);
	
}
}