/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.web;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zenume
 */

@Controller
public class PatientController {
@Autowired
private PatientRepository patientRepository;
@GetMapping(path="/index")
public String listPatients(Model model,@RequestParam(name="motCle",defaultValue="")String mc,@RequestParam(name="page",defaultValue = "0")int page,@RequestParam(name="size",defaultValue = "5")int size){
	Page<Patient> pagePatient=patientRepository.findByNomContains(mc,PageRequest.of(page, size));
	model.addAttribute("patients",pagePatient.getContent());
	model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
	model.addAttribute("currentPage", page);
    model.addAttribute("patients",pagePatient);
	model.addAttribute("motCle",mc);
	
	return "patients";
}
@GetMapping(path="/")
public String home(){
	return "/home";
}
@GetMapping(path="/deletePatient")
public String delete(Long id){
	patientRepository.deleteById(id);
	return "redirect:/index";
}
@GetMapping(path="/formPatient")
public String formPatient(Model model){
	model.addAttribute("patient", new Patient());
	return "formPatient";
}
@PostMapping("/savePatient")
public String savePatient(@Valid Patient patient, BindingResult bindingResult){
	if(bindingResult.hasErrors()){ return "formPatient";}
	patientRepository.save(patient);
	return "formPatient";
}
@GetMapping(path="/editPatient")
public String editPatient(Model model,Long id){
	Patient p=patientRepository.findById(id).get();
	model.addAttribute("patient", p);
	return "formPatient";
}
}
