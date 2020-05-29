package ru.icmit.oodb.lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab10.domain.Clinic;
import ru.icmit.oodb.lab10.domain.Diagnose;
import ru.icmit.oodb.lab10.domain.Patient;
import ru.icmit.oodb.lab10.repository.ClinicRepository;
import ru.icmit.oodb.lab10.repository.DiagnoseRepository;
import ru.icmit.oodb.lab10.repository.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DiagnoseController {

    @Autowired
    private DiagnoseRepository repository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/diagnose")
    public String diagnoses(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        List<Diagnose> diagnoses = repository.findAll();
        model.addAttribute("diagnoses", diagnoses);
        return "diagnose";
    }

    @RequestMapping("/diagnosebyname")
    public String clinicByName(HttpServletRequest request,
                               @RequestParam("name") String name,
                               @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);
        System.out.println("name " + name);
        Diagnose diagnose = repository.findByName(name);
        model.addAttribute("diagnose", diagnose);
        return "/diagnosebyname";
    }


    @RequestMapping("/adddiagnose")
    @Transactional
    public String clientByName(HttpServletRequest request,
                               @RequestParam(value = "id", required = false) Long id,
                               @RequestParam(value = "numb", required = false) String numb,
                               @ModelAttribute("model") ModelMap model)
    {
        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        Patient patient = null;
        // Если получили непустой id - пытаемся найти клиента к которому надо привязать счет
        if (id != null) {
            patient = patientRepository.getFetchPatient(id);

            // Если нашли клиента - добавляем счет

            if (patient != null) {
                Diagnose diagnose = new Diagnose();
                diagnose.setName( numb );
                repository.save( diagnose );

                patient.getDiagnoses().add( diagnose );

                patientRepository.save( patient );
            }

            // Запросим теперь список всех счетов клиента
            List<Diagnose> diagnoses = patientRepository.getClientDiagnosess( patient );
            // Передаем в параметры веб-страницы
            model.addAttribute("diagnoses", diagnoses);

        } else {
            patient = new Patient();
        }

        model.addAttribute("patient", patient);

        return "/patient";
    }

}
