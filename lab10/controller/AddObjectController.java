package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.*;
import ru.icmit.oodb.lab10.repository.*;

import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.util.List;

@Controller
public class AddObjectController {
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


    @RequestMapping("/diagnose/add")
    @Transactional
    public String addDiagnose(HttpServletRequest request,
                          @RequestParam(value = "id", required = false) Long id,
                          @RequestParam(value = "name", required = false) String name,
                          @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        Diagnose diagnose = null;
        // Если получили непустой id - пытаемся найти
        if (id != null) {
            diagnose = diagnoseRepository.findById(id);
        }

        if (diagnose == null) {
            diagnose = new Diagnose();
        }

        if ( name != null ) {
            // Используем параметры формы
            diagnose.setName(name);
            diagnose = diagnoseRepository.save(diagnose);
        }
        //        model.addAttribute("area", area);
        return "/addobject";
    }

    @RequestMapping("/area/add")
    @Transactional
    public String addArea(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "name", required = false) String name,
                            @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        Area area = null;
        // Если получили непустой id - пытаемся найти
        if (id != null) {
            area = areaRepository.findById(id);
        }

        if (area == null) {
            area = new Area();
        }

        if ( name != null ) {
            // Используем параметры формы
            area.setName(name);
            area = areaRepository.save(area);
        }
        //        model.addAttribute("area", area);
        return "/addobject";
    }

    @RequestMapping("/clinic/add")
    @Transactional
    public String addClinic(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "address", required = false) String address,
                            @RequestParam(value = "name", required = false) String name,
                            @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        Clinic clinic = null;
        if (id != null) {
            clinic = clinicRepository.findById(id);
        }
        if (clinic == null) {
            clinic = new Clinic();
        }
        if ( name != null ) {
            clinic.setName(name);
            clinic.setAddress(address);
            clinic = clinicRepository.save(clinic);
        }
        model.addAttribute("clinic", clinic);
        return "/addobject";
    }

    @RequestMapping("/doctor/add")
    @Transactional
    public String addDoctor(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "specialty", required = false) String specialty,
                            @RequestParam(value = "birthDate", required = false) Date birthDate,
                            @RequestParam(value = "area", required = false) Long area,
                            @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        Doctors doctor=null;
        if (id != null) {
            doctor = doctorRepository.findById(id);
        }
        if (doctor == null) {
            doctor = new Doctors();
        }
        if ( name != null  || specialty !=null) {
            doctor.setName(name);
            doctor.setSpecialty(specialty);
            doctor.setBirthDate(birthDate);
            doctor.setArea(areaRepository.findById(area));
            doctor = doctorRepository.save(doctor);
        }
        return "/addobject";
    }

    @RequestMapping("/patient/add")
    @Transactional
    public String addPatient(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "birthDate", required = false) Date birthDate,
                            @RequestParam(value = "area", required = false) Long area,
                            @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        Patient patient=null;
        if (id != null) {
            patient = patientRepository.findById(id);
        }
        if (patient == null) {
            patient = new Patient();
        }
        if ( name != null  ) {
            patient.setName(name);
            patient.setBirthDate(birthDate);
            patient.setArea(areaRepository.findById(area));
            patient = patientRepository.save(patient);
        }
        return "/addobject";
    }


    @RequestMapping("/addobject")
    public String delObject(HttpServletRequest request,
                            @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        return "/addobject";
    }

}
