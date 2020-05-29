package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Diagnose;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
@Component

public class DiagnoseRepository {

    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    public List<Diagnose> findAll() {

        Query query = entityManager.createQuery(
                "select c from Diagnose c ", Diagnose.class);

        List<Diagnose> areas = query.getResultList();
        System.out.println(Arrays.toString(areas.toArray()));

        return areas;

    }

    public Diagnose findByName(String name) {
        Query query = entityManager.createQuery(
                "select c from Diagnose c where c.name like :name ", Diagnose.class);

        query.setParameter("name", name);

/*
        List<Client> clients = query.getResultList();

        Client client = clients!=null?clients.get(0):null;
*/

        Diagnose area = (Diagnose) query.getSingleResult();

        return area;
    }
    public Diagnose findById(Long id) {
        return entityManager.find(Diagnose.class, id);
    }


    @Transactional
    public Diagnose save(Diagnose area) {

        if (area == null ) return null;

        if (area.getId() != null) {
            area = entityManager.merge(area);
        } else {
            entityManager.persist(area);
        }

        return area;
    }

    @Transactional
    public  boolean removeArea(Long id){
        Diagnose area=entityManager.find(Diagnose.class, id);
        if(area==null) return false;
        entityManager.remove(area);
        return true;
    }
}
