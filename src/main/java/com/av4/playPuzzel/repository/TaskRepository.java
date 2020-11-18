package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("select t from Task t where t.userInfo.uId=:userInfo")
	public List<Task> getAllTaskByUserId(@Param(value="userInfo") Long userInfo);

}
