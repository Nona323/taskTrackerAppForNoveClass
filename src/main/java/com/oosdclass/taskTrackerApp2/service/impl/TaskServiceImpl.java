package com.oosdclass.taskTrackerApp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskDAO; 
	
	
	@Override
	public void saveTask(Task task) {
	task.setStatus("Open");
	task.setAssignedTo("Un-Assigned");
	taskDAO.saveTask(task);


}


	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskDAO.retrieveAllTasks();
	}
	
}
