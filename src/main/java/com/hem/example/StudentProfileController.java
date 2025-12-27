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
@RequestMapping("/api/profiles")
public class StudentProfileController {

  private final StudentProfileRepository profileRepository;

  public StudentProfileController(StudentProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @PostMapping
  public StudentProfile createProfile(@RequestBody StudentProfile profile) {
    return profileRepository.save(profile);
  }

  @GetMapping("/{id}")
  public StudentProfile getProfile(@PathVariable("id") Integer id) {
    return profileRepository.findById(id).orElse(new StudentProfile());
  }

  @GetMapping
  public List<StudentProfile> getAllProfiles() {
    return profileRepository.findAll();
  }

  @PutMapping("/{id}")
  public StudentProfile updateProfile(@PathVariable("id") Integer id, @RequestBody StudentProfile profile) {
    return profileRepository.findById(id).map(p -> {
      p.setBio(profile.getBio());
      return profileRepository.save(p);
    }).orElseGet(() -> {
      profile.setId(id);
      return profileRepository.save(profile);
    });
  }

  @DeleteMapping("/{id}")
  public void deleteProfile(@PathVariable("id") Integer id) {
    profileRepository.deleteById(id);
  }

}
