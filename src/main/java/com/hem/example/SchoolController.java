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

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

	private final SchoolRepository schoolRepository;

	public SchoolController(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@PostMapping
	public School createSchool(@RequestBody School school) {
		return schoolRepository.save(school);
	}

	@GetMapping("/{id}")
	public School getSchool(@PathVariable("id") Integer id) {
		return schoolRepository.findById(id).orElse(new School());
	}

	@GetMapping
	public List<School> getAllSchools() {
		return schoolRepository.findAll();
	}

	@PutMapping("/{id}")
	public School updateSchool(@PathVariable("id") Integer id, @RequestBody School school) {
		return schoolRepository.findById(id).map(s -> {
			s.setName(school.getName());
			return schoolRepository.save(s);
		}).orElseGet(() -> {
			school.setId(id);
			return schoolRepository.save(school);
		});
	}

	@DeleteMapping("/{id}")
	public void deleteSchool(@PathVariable("id") Integer id) {
		schoolRepository.deleteById(id);
	}

}
