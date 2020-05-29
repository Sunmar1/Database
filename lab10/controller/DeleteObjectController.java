package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.repository.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeleteObjectController {
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private DoctorsRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DiagnoseRepository diagnoseRepository;


    @RequestMapping("/diagnose/delete")
    public String deleteDiagnose(HttpServletRequest request,
                             @RequestParam("diagnoseid") Long areaid,
                             @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        diagnoseRepository.removeArea(areaid);


        return "/deleteobject";
    }



    @RequestMapping("/area/delete")
    public String deleteArea(HttpServletRequest request,
                             @RequestParam("areaid") Long areaid,
                             @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        areaRepository.removeArea(areaid);


        return "/deleteobject";
    }
    @RequestMapping("/clinic/delete")
    public String deleteClinic(HttpServletRequest request,
                             @RequestParam("clinicid") Long clinicid,
                             @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        clinicRepository.removeClinic(clinicid);


        return "/deleteobject";
    }
    @RequestMapping("/doctor/delete")
    public String deleteDoctor(HttpServletRequest request,
                               @RequestParam("doctorid") Long doctorid,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        doctorRepository.removeDoctor(doctorid);


        return "/deleteobject";
    }
    @RequestMapping("/patient/delete")
    public String deletePatient(HttpServletRequest request,
                               @RequestParam("patientid") Long patientid,
                               @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        patientRepository.removePatient(patientid);


        return "/deleteobject";
    }

    @RequestMapping("/deleteobject")
    public String delObject(HttpServletRequest request,
                            @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        return "/deleteobject";
    }



}
