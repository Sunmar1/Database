package ru.icmit.oodb.lab10.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.icmit.oodb.lab10.domain.Doctors;
import ru.icmit.oodb.lab10.domain.Patient;
import ru.icmit.oodb.lab10.repository.DoctorsRepository;
import ru.icmit.oodb.lab10.repository.PatientRepository;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @RequestMapping("/patient")
    public String patients(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Patient> patients = repository.findAll();

        model.addAttribute("patients", patients);

        return "patients";
    }

    @RequestMapping("/patientbyname")
    public String doctorByName(HttpServletRequest request,
                               @RequestParam("name") String name,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        System.out.println("name " + name);
        Patient patient = repository.findByName(name);

        System.out.println(patient);

        model.addAttribute("patient", patient);

        return "/patientbyname";
    }

}
