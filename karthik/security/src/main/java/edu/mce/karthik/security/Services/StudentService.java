package edu.mce.karthik.security.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mce.karthik.security.entities.Student;
import edu.mce.karthik.security.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> readStudents(){
		return repo.findAll();
	}
	public void createStudent(Student st) {
		repo.save(st);
	}
	public void updateStudent(Student st) {
		repo.save(st);
	}
	public void deleteStudent(Long id) {
		repo.deleteById(id);
	}
	public Student getStudentByStudentId(Long id) {
		return repo.getStudentByStudentId(id);
	}
}