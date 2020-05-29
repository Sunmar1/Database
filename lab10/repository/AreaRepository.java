package ru.icmit.oodb.lab10.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab10.domain.Area;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class AreaRepository {

    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    public List<Area> findAll() {

        Query query = entityManager.createQuery(
                "select c from Area c ", Area.class);

        List<Area> areas = query.getResultList();

        return areas;

    }

    public Area findByName(String name) {
        Query query = entityManager.createQuery(
                "select c from Area c where c.name like :name ", Area.class);

        query.setParameter("name", name);

/*
        List<Client> clients = query.getResultList();

        Client client = clients!=null?clients.get(0):null;
*/

        Area area = (Area) query.getSingleResult();

        return area;
    }
    public Area findById(Long id) {
        return entityManager.find(Area.class, id);
    }


    @Transactional
    public Area save(Area area) {

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
        Area area=entityManager.find(Area.class, id);
        if(area==null) return false;
        entityManager.remove(area);
        return true;
    }

}
