package com.doctor.doctor.controller;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.repository.DoctorRepository;

@Controller
@AutoConfiguration
public class DoctorController {
  private final DoctorRepository dataRepository;

  public DoctorController(DoctorRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @GetMapping("doctors")
  public String lists(Model model) {
    model.addAttribute("doctors", dataRepository.findAll());
    return "doctors/list";
  }

  @GetMapping("/doctors/create")
  public String create(Model model) {
    model.addAttribute("doctor", new Doctor());
    return "doctors/create";
  }

  @PostMapping("/doctors/create")
  public String store(Doctor data) {
    dataRepository.save(data);
    return "redirect:/doctors";
  }

  @GetMapping("/doctors/{id}")
  public String show(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("doctor", dataRepository.findById(id).orElse(null));
    return "doctors/show";
  }

  @GetMapping("/doctors/{id}/edit")
  public String edit(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("doctor", dataRepository.findById(id).orElse(null));
    return "doctors/edit";
  }

  @PostMapping("/doctors/{id}/edit")
  public String update(@PathVariable(value = "id") Long id, Doctor updated) {
    Doctor data = dataRepository.findById(id).orElse(null);
    if (data != null) {
      data.setFirstName(updated.getFirstName());
      data.setLastNameFather(updated.getLastNameFather());
      data.setlastNameMother(updated.getLastNameMother());
      data.setSpecialty(updated.getSpecialty());
      dataRepository.save(data);
    }
    return "redirect:/doctors";
  }

  @GetMapping("/doctors/{id}/delete")
  public String delete(@PathVariable(value = "id") Long id) {
    dataRepository.deleteById(id);
    return "redirect:/doctors";
  }
}
