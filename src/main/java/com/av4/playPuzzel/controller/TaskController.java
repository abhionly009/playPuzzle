package com.av4.playPuzzel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Task;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.repository.UserInforRepository;
import com.av4.playPuzzel.service.TaskManagmentService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskManagmentService taskService;
	
	

	@Autowired
	private UserInforRepository userInfoRepo;
	
	@GetMapping("/getAll")
	public List<Task> getTask(@Param(value="authToken") String authToken){
		
		List<Task> taskList = new ArrayList<Task>();
		
		
			UserInfo user = userInfoRepo.findUserByAuthToken(authToken);
			
			if (user!=null) {
				taskList = taskService.getAllTaskInfo(user.getuId());
			}
			
		return taskList;
		
	}
	
	@PostMapping("/createTask")
	public Task createTask(@RequestBody Task task, @Param(value="authToken") String authToken) {
//	Task t = new Task();
		
		UserInfo userInfo = userInfoRepo.findUserByAuthToken(authToken);
//		t.setEndTime( task.getEndTime());
//		t.setStartTime(task.getStartTime());
//		t.setDescription(task.getDescription());
		task.setUserInfo(userInfo);
		return taskService.create(task);
		
		
	}

}
