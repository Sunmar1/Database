package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.repository.AreaRepository;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AreaController {

    @Autowired
    private AreaRepository repository;

    @RequestMapping("/area")
    public String clients(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Area> areas = repository.findAll();

        model.addAttribute("areas", areas);

        return "areas";
    }

    @RequestMapping("/areabyname")
    public String areaByName(HttpServletRequest request,
                               @RequestParam("name") String name,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        System.out.println("name " + name);
        Area area = repository.findByName(name);

        System.out.println(area);

        model.addAttribute("area", area);

        return "/areabyname";
    }


}
