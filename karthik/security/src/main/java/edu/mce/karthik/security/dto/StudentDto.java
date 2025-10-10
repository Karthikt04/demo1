package edu.mce.karthik.security.dto;
public class StudentDto {
  	private Long studentId;
  	private String studentName;
  	private String studentEmail;
  	private Long studentPhone;
  	private String studentCourse;
  	private Double studentCGPA;
  	public StudentDto(Long studentId, String studentName, String studentEmail, Long studentPhone, String studentCourse,
  			Double studentCGPA) {
  		super();
  		this.studentId = studentId;
  		this.studentName = studentName;
  		this.studentEmail = studentEmail;
  		this.studentPhone = studentPhone;
  		this.studentCourse = studentCourse;
  		this.studentCGPA = studentCGPA;
  	}
  	public StudentDto(String studentName, String studentEmail, Long studentPhone, String studentCourse,
  			Double studentCGPA) {
  		super();
  		this.studentName = studentName;
  		this.studentEmail = studentEmail;
  		this.studentPhone = studentPhone;
  		this.studentCourse = studentCourse;
  		this.studentCGPA = studentCGPA;
  	}
  	public StudentDto() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public Long getStudentId() {
  		return studentId;
  	}
  	public void setStudentId(Long studentId) {
  		this.studentId = studentId;
  	}
  	public String getStudentName() {
  		return studentName;
  	}
  	public void setStudentName(String studentName) {
  		this.studentName = studentName;
  	}
  	public String getStudentEmail() {
  		return studentEmail;
  	}
  	public void setStudentEmail(String studentEmail) {
  		this.studentEmail = studentEmail;
  	}
  	public Long getStudentPhone() {
  		return studentPhone;
  	}
  	public void setStudentPhone(Long studentPhone) {
  		this.studentPhone = studentPhone;
  	}
  	public String getStudentCourse() {
  		return studentCourse;
  	}
  	public void setStudentCourse(String studentCourse) {
  		this.studentCourse = studentCourse;
  	}
  	public Double getStudentCGPA() {
  		return studentCGPA;
  	}
  	public void setStudentCGPA(Double studentCGPA) {
  		this.studentCGPA = studentCGPA;
  	}
  }