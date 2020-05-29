package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.icmit.oodb.lab10.domain.Doctors;
import ru.icmit.oodb.lab10.domain.DoctorsData;
import ru.icmit.oodb.lab10.repository.DoctorsRepository;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class DoctorsController {

    @Autowired
    private DoctorsRepository repository;

    @RequestMapping("/doctor")
    public String doctors(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Doctors> doctors = repository.findAll();

        model.addAttribute("doctors", doctors);

        return "doctors";
    }

    @RequestMapping("/doctorbyname")
    public String doctorByName(HttpServletRequest request,
                             @RequestParam("name") String name,
                             @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        System.out.println("name " + name);
        Doctors doctor = repository.findByName(name);

        System.out.println(doctor);

        model.addAttribute("doctor", doctor);

        return "/doctorbyname";
    }

    @RequestMapping("/doctorsByView")
    public String doctorsByView(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<DoctorsData> doctorsByView = repository.getByView();

        model.addAttribute("doctorsByView", doctorsByView);

        return "doctorsByView";
    }

}
