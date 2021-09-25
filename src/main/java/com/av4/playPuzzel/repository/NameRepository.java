package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {


	@Query(value = "select id,  user_name, count(user_name) as count from Name n group by user_name order by count(user_name) desc LIMIT 3",nativeQuery = true)
	public List<Name> getUserInfo();
	
	
	
}
