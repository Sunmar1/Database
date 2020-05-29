package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.domain.Diagnose;
import ru.icmit.oodb.lab10.domain.Doctors;
import ru.icmit.oodb.lab10.domain.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class PatientRepository {
    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;


    public List<Patient> findAll() {

        Query query = entityManager.createQuery(
                "select d from Patient d", Patient.class);


        List<Patient> patients=query.getResultList();

        return patients;

    }

    public Patient findByName(String name) {

        Query query = entityManager.createQuery(
                "select c from Patient c where c.name like :name ", Patient.class);
        query.setParameter("name", name);

        Patient patient = (Patient) query.getSingleResult();
        return patient;
    }
    public Patient findById(Long id) {
        return entityManager.find(Patient.class, id);
    }


    @Transactional
    public Patient save(Patient patient) {

        if (patient == null ) return null;

        if (patient.getId() != null) {
            patient = entityManager.merge(patient);
        } else {
            entityManager.persist(patient);
        }

        return patient;
    }

    @Transactional
    public  boolean removePatient(Long id){
        Patient patient=entityManager.find(Patient.class, id);
        if(patient==null) return false;
        entityManager.remove(patient);
        return true;
    }



    public Patient getFetchPatient( Long id ) {
        Patient patient = null;
        try {
            Query query = entityManager.createQuery(
                    "select c from Patient c LEFT JOIN FETCH c.diagnoses a where c.id = :id ", Patient.class);
            query.setParameter("id", id);
            patient = (Patient) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    public List<Diagnose> getClientDiagnosess(Patient patient) {
        Query query = entityManager.createQuery(
                "select a from Patient c JOIN c.diagnoses a where c = :client ", Patient.class);
        query.setParameter("patient", patient);

        return query.getResultList();
    }
}
