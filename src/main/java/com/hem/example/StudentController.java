package com.hem.example;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.findById(id).orElse(new Student());
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/search/{name}")
	public List<Student> searchByName(@PathVariable("name") String name) {
		return studentRepository.findAllByFirstnameContaining(name);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		return studentRepository.findById(id).map(s -> {
			s.setFirstname(student.getFirstname());
			s.setLastname(student.getLastname());
			s.setEmail(student.getEmail());
			s.setAge(student.getAge());
			s.setUpdatedAt(student.getUpdated_at());
			return studentRepository.save(s);
		}).orElse(new Student());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudent(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}

}

