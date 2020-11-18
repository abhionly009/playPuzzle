package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Task;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.repository.TaskRepository;
import com.av4.playPuzzel.repository.UserInforRepository;

@Service
public class TaskManagmentService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public List<Task> getAllTaskInfo(long id){
		return taskRepository.getAllTaskByUserId(id);
	}

	public Task create(Task task) {
		

				return taskRepository.save(task);
		
		
	}
	
}
