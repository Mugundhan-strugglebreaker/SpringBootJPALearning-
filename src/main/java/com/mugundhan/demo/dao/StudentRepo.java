package com.mugundhan.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mugundhan.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
	List<Student> findByName(String name);
	
	@Query("from Student order by name")
	List<Student> findByAllSorted();

}
