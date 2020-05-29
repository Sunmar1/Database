package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Area;
import ru.icmit.oodb.lab10.domain.Clinic;
import ru.icmit.oodb.lab10.domain.Doctors;
import ru.icmit.oodb.lab10.domain.DoctorsData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
@Component

public class DoctorsRepository {

    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    public  Area getArea(int area_id){
        Query query=entityManager.createQuery("select * from Area where id="+area_id,Area.class);
        return  (Area)query.getSingleResult();
    }
    public List<Doctors> findAll() {

        Query query = entityManager.createQuery(
                "select d from Doctors d", Doctors.class);
//        for (Doctors list: doctors){
//            Doctors doctor=new Doctors();
//            doctor.setArea(getArea());
//            doctors.add(doctor);
//        }

        List<Doctors> doctors=query.getResultList();

        return doctors;

    }

    public Doctors findByName(String name) {

        Query query = entityManager.createQuery(
                "select c from Doctors c where c.name like :name ", Doctors.class);
        query.setParameter("name", name);
        Doctors doctors = (Doctors) query.getSingleResult();
        return doctors;
    }
    public Doctors findById(Long id) {
        return entityManager.find(Doctors.class, id);
    }


    @Transactional
    public Doctors save(Doctors doctor) {

        if (doctor == null ) return null;

        if (doctor.getId() != null) {
            doctor = entityManager.merge(doctor);
        } else {
            entityManager.persist(doctor);
        }

        return doctor;
    }

    @Transactional
    public  boolean removeDoctor(Long id){
        Doctors doctor=entityManager.find(Doctors.class, id);
        if(doctor==null) return false;
        entityManager.remove(doctor);
        return true;
    }

    public  List<DoctorsData> getByView()  {
        Query query = entityManager.createQuery(
                "select d from DoctorsData d", DoctorsData.class);
        List<DoctorsData> doctorsData=query.getResultList();
        return doctorsData;
    }

}
