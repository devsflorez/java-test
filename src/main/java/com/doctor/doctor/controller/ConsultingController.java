package com.doctor.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.doctor.doctor.entity.Consulting;
import com.doctor.doctor.repository.ConsultingRepository;

@Controller
public class ConsultingController {
  private final ConsultingRepository dataRepository;

  public ConsultingController(ConsultingRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @GetMapping("/consultings")
  public String lists(Model model) {
    model.addAttribute("consultings", dataRepository.findAll());
    return "consultings/list";
  }

  @GetMapping("/consultings/create")
  public String showDoctorForm(Model model) {
    model.addAttribute("consulting", new Consulting());
    return "consultings/create";
  }

  @PostMapping("/consultings/create")
  public String saveDoctor(Consulting data) {
    dataRepository.save(data);
    return "redirect:/consultings";
  }

  @GetMapping("/consultings/{id}")
  public String showDoctor(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("consulting", dataRepository.findById(id).orElse(null));
    return "consultings/show";
  }

  @GetMapping("/consultings/{id}/edit")
  public String editDoctor(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("consulting", dataRepository.findById(id).orElse(null));
    return "consultings/edit";
  }

  @PostMapping("/consultings/{id}/edit")
  public String updateDoctor(@PathVariable(value = "id") Long id, Consulting updated) {
    Consulting data = dataRepository.findById(id).orElse(null);
    if (data != null) {
      data.setFloor(updated.getFloor());
      data.setNumber(updated.getNumber());
      dataRepository.save(data);
    }
    return "redirect:/consultings";
  }

  @GetMapping("/consultings/{id}/delete")
  public String deleteDoctor(@PathVariable(value = "id") Long id) {
    dataRepository.deleteById(id);
    return "redirect:/consultings";
  }
}
