

import domain.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;


public class Test {


    public static void main(String[] args) throws InvocationTargetException {
        Properties props = new Properties();
        props.setProperty("url", "jdbc:postgresql://localhost:5432/lab7");
        props.setProperty("username", "postgres");
        props.setProperty("password", "admin");
        props.setProperty("driverName", "org.postgresql.Driver");
        String classPath = "domain";
//    EntityManagerImpl entityManager = new EntityManagerImpl();
        EntityManagerFactory entityManagerFactory = new EntityManagerFactory(props, classPath);
        EntityManager entityManager = entityManagerFactory.create();

        Person patient = new Patient();
        patient.setName("DSADSD DSAD DSD");
        patient.setBirthDate(new Date());
        patient.setId((long) 4);


        Person patient2 = new Patient();
        patient2.setName("Тест");


        entityManager.persist(patient);
        entityManager.persist(patient2);





        Diagnoses diagnoses = new Diagnoses();
        diagnoses.setName("Коронавирус");
        entityManager.persist(diagnoses);

//
        Area area=new Area()
       ;
        area.setName("dsada");

        entityManager.persist(area);
        System.out.println("\n");
        System.out.println("Объект класса Patient до обновления - " + patient);
        ((Patient) patient).setName("PATIENT");
        entityManager.merge(patient);
        System.out.println("Объект класса Patient после обновления - " + patient);

        System.out.println("\n");
        System.out.println("Объект класса Area до обновления - " + area);
        area.setName("AREA");
        entityManager.merge(area);
        System.out.println("Объект класса Area после обновления - " + area);
        System.out.println("\n");

        entityManager.remove(area);

        System.out.println("\n");
        Object object = entityManager.find(Area.class, 1);
        System.out.println("Найденный объект класса Book с id=1 - " + object);

        entityManagerFactory.close();


    }
}