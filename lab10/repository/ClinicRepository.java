package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.domain.Clinic;
import ru.icmit.oodb.lab10.domain.Doctors;
import ru.icmit.oodb.lab10.domain.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Component
public class ClinicRepository {
    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    public List<Clinic> findAll() {
        Query query = entityManager.createQuery(
                "select c from Clinic c ", Clinic.class);
        List<Clinic> clinics = query.getResultList();
        return clinics;

    }


    public Clinic findByName(String name) {
//where c.name like :name  GROUP BY c as b  LEFT JOIN areas  a  where b.id=a.id

//        Query query = entityManager.createQuery(
//////                " select b.id,b.name,b.address  from Clinic b where :name in (select c.name FROM Clinic c LEFT JOIN  Area a )", Clinic.class);
//////       query.setParameter("name", name);
//        " select c from Clinic c LEFT  JOIN Area a  on c.id=a.id");
         List <Area>  b =null;
         List <Doctors> d =null;
         List <Patient> p=null;
        List<Clinic> clinics=findAll();
        for (Clinic list : clinics){
            if(list.getName().equals(name)) {
                list.setAreas(b);
                list.setDoctors(d);
                list.setPatients(p);
                return list;
            }
        }

        return new Clinic();
    }
    public Clinic findById(Long id) {
        return entityManager.find(Clinic.class, id);
    }


    @Transactional
    public Clinic save(Clinic clinic) {

        if (clinic == null ) return null;

        if (clinic.getId() != null) {
            clinic = entityManager.merge(clinic);
        } else {
            entityManager.persist(clinic);
        }

        return clinic;
    }

    @Transactional
    public  boolean removeClinic(Long id){
        Clinic clinic=entityManager.find(Clinic.class, id);
        if(clinic==null) return false;
        entityManager.remove(clinic);
        return true;
    }

}
