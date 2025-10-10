package edu.mce.karthik.security.controllers;
import edu.mce.karthik.security.entities.User;
import edu.mce.karthik.security.Services.UserService;
import edu.mce.karthik.security.dto.StudentDto;
import edu.mce.karthik.security.entities.Student;
import edu.mce.karthik.security.Services.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
  
      @Autowired
      private UserService userService;
  	@Autowired
  	private StudentService service;
  
  
      @GetMapping("/login")
      public String loginPage() {
          return "student/login-page.html";
      }
      
      @GetMapping("/register")
      public String registerForm(Model model) {
          model.addAttribute("user", new User());
          return "student/register-page.html";
      }
  
      @PostMapping("/register")
      public String registerUser(@ModelAttribute User user) {
          userService.save(user);
          return "redirect:/login";
      }
  
      @GetMapping("/home")
      public String homePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
          User user = userService.findByEmail(userDetails.getUsername());
          model.addAttribute("name", user.getName());
          model.addAttribute("email", user.getEmail());
          return "student/home-page.html";
      }
      
      @GetMapping("/aboutus")
      public String aboutUs(@AuthenticationPrincipal UserDetails userDetails) {
          return "student/aboutus-page.html";
      }
      
      @GetMapping("/contactus")
      public String contactUs(@AuthenticationPrincipal UserDetails userDetails) {
          return "student/contactus-page.html";
      }
  
      
      @GetMapping("/readstudents")
      public String readStudents(@AuthenticationPrincipal UserDetails userDetails, Model model) {
          User user = userService.findByEmail(userDetails.getUsername());
          model.addAttribute("name", user.getName());
          model.addAttribute("email", user.getEmail());
          
          List<Student> students = service.readStudents();
  		model.addAttribute("students",students);
  		return "/student/readstudents-page.html";
      }
      
      @GetMapping("createstudent")
  	public String createStudent(@AuthenticationPrincipal UserDetails userDetails, Model model) {
  		StudentDto studentDto = new StudentDto();
  		model.addAttribute("studentDto",studentDto);
  		return "/student/createstudent-page.html";
  	}
  	@PostMapping("createstudent")
  	public String createStudentPage(@ModelAttribute StudentDto studentDto) {
  		Student st = new Student(studentDto.getStudentName(),studentDto.getStudentEmail(),studentDto.getStudentPhone(),studentDto.getStudentCourse(),studentDto.getStudentCGPA());
  		service.createStudent(st);
  		return "redirect:/readstudents";
  	}
  	@GetMapping("updatestudent")
  	public String updateStudent(@AuthenticationPrincipal UserDetails userDetails, Model model, @RequestParam Long id) {
  		Student st = service.getStudentByStudentId(id);
  		StudentDto studentDto = new StudentDto(st.getStudentName(),st.getStudentEmail(),st.getStudentPhone(),st.getStudentCourse(),st.getStudentCGPA());
  		model.addAttribute("studentDto",studentDto);
  		return "/student/updatestudent-page.html";
  	}
  	@PostMapping("updatestudent")
  	public String updateStudent(@RequestParam Long id, @ModelAttribute StudentDto studentDto) {
  		Student st = service.getStudentByStudentId(id);
  		st.setStudentName(studentDto.getStudentName());
  		st.setStudentEmail(studentDto.getStudentEmail());
  		st.setStudentPhone(studentDto.getStudentPhone());
  		st.setStudentCourse(studentDto.getStudentCourse());
  		st.setStudentCGPA(studentDto.getStudentCGPA());
  		service.updateStudent(st);
  		return "redirect:/readstudents";
  	}
  	@GetMapping("deletestudent")
  	public String deleteStudent(@RequestParam Long id) {
  		service.deleteStudent(id);
  		return "redirect:/readstudents";
  	}
  	@GetMapping("readstudent")
  	public String readStudent(@AuthenticationPrincipal UserDetails userDetails, Model model, @RequestParam Long id) {
  		Student st = service.getStudentByStudentId(id);
  		StudentDto studentDto = new StudentDto(st.getStudentName(),st.getStudentEmail(),st.getStudentPhone(),st.getStudentCourse(),st.getStudentCGPA());
  		model.addAttribute("studentDto",studentDto);
  		return "/student/readstudent-page.html";
  	}
  }