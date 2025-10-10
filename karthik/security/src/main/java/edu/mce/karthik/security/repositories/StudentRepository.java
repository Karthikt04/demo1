package edu.mce.karthik.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  
import edu.mce.karthik.security.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	Student getStudentByStudentId(Long id);
}