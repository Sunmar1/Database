package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.domain.Clinic;
import ru.icmit.oodb.lab10.repository.AreaRepository;
import ru.icmit.oodb.lab10.repository.ClinicRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class ClinicController {

    @Autowired
    private ClinicRepository repository;

    @RequestMapping("/clinic")
    public String clinics(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        List<Clinic> clinics = repository.findAll();
        model.addAttribute("clinics", clinics);
        return "clinics";
    }

    @RequestMapping("/clinicbyname")
    public String clinicByName(HttpServletRequest request,
                             @RequestParam("name") String name,
                             @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        System.out.println("name " + name);
        Clinic clinic = repository.findByName(name);
        System.out.println(clinic);
        model.addAttribute("clinic", clinic);
        return "/clinicbyname";
    }

}
