package edu.mce.karthik.security.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="student_name", length=60)
	private String studentName;
	
	@Column(name="student_email", length=70)
	private String studentEmail;
	
	@Column(name="student_phone")
	private Long studentPhone;
	
	@Column(name="student_course",length=10)
	private String studentCourse;
	
	@Column(name="student_cgpa")
	private Double studentCGPA;

	public Student(Long studentId, String studentName, String studentEmail, Long studentPhone, String studentCourse,
			Double studentCGPA) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentCourse = studentCourse;
		this.studentCGPA = studentCGPA;
	}

	public Student(String studentName, String studentEmail, Long studentPhone, String studentCourse,
			Double studentCGPA) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentCourse = studentCourse;
		this.studentCGPA = studentCGPA;
	}

	public Student() {
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