package com.doctor.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.entity.Consulting;
import com.doctor.doctor.entity.Quote;
import com.doctor.doctor.repository.DoctorRepository;
import com.doctor.doctor.repository.ConsultingRepository;
import com.doctor.doctor.repository.QuoteRepository;

@Controller
public class QuoteController {
  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private ConsultingRepository consultingRepository;
  
  private final QuoteRepository dataRepository;

  public QuoteController(QuoteRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @GetMapping("/quotes")
  public String lists(Model model) {
    model.addAttribute("quotes", dataRepository.findAll());
    return "quotes/list";
  }

  @GetMapping("/quotes/create")
  public String create(Model model) {
    model.addAttribute("doctors", doctorRepository.findAll());
    model.addAttribute("consultings", consultingRepository.findAll());
    model.addAttribute("quote", new Quote());
    return "quotes/create";
  }

  @PostMapping("/quotes/create")
  public String store(@RequestParam Long idDoctor, @RequestParam Long idConsulta, Quote data) {
    Doctor doctor = doctorRepository.findById(idDoctor).orElseThrow()
    Consulting consulting = consultingRepository.findById(idConsulta).orElseThrow();
    data.setDoctor(doctor);
    data.setConsulting(consulting);
    dataRepository.save(data);
    return "redirect:/quotes";
  }

  @GetMapping("/quotes/{id}")
  public String show(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("quote", dataRepository.findById(id).orElse(null));
    return "quotes/show";
  }

  @GetMapping("/quotes/{id}/edit")
  public String edit(@PathVariable(value = "id") Long id, Model model) {
    model.addAttribute("quote", dataRepository.findById(id).orElse(null));
    return "quotes/edit";
  }

  @PostMapping("/quotes/{id}/edit")
  public String update(@RequestParam Long idDoctor, @RequestParam Long idConsulta, @PathVariable(value = "id") Long id, Quote updated) {
    Quote data = dataRepository.findById(id).orElse(null);
    if (data != null) {
      Doctor doctor = doctorRepository.findById(idDoctor).orElseThrow()
      Consulting consulting = consultingRepository.findById(idConsulta).orElseThrow();
      data.setDoctor(doctor);
      data.setConsulting(consulting);
      data.setName(updated.getName());
      data.setDateTime(updated.getDateTime());
      dataRepository.save(data);
    }
    return "redirect:/quotes";
  }

  @GetMapping("/quotes/{id}/delete")
  public String delete(@PathVariable(value = "id") Long id) {
    dataRepository.deleteById(id);
    return "redirect:/quotes";
  }
}

