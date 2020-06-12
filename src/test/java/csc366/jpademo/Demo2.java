package csc366.jpademo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
	"spring.main.banner-mode=off",
	"logging.level.root=ERROR",
	"logging.level.csc366=DEBUG",

	"logging.level.org.hibernate.SQL=DEBUG",
	"logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE", // display prepared statement parameters
	"spring.jpa.properties.hibernate.format_sql=true",
	"spring.jpa.show-sql=false",   // prevent duplicate logging
	"spring.jpa.properties.hibernate.show_sql=false",	
	
	"logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} - %msg%n"
})
@ActiveProfiles("junit")


public class Demo2 {

    private final static Logger log = LoggerFactory.getLogger(Demo2.class);

    @Autowired
    private EntityManager entityManager;  // https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html
    
    
    @BeforeEach
    private void setup() {
        Employee e1 = new Employee(200, "Joe", "e1@store", "1990-06-06",  "415-000-0000", "Bay Area", true);
        entityManager.persist(e1);
        Employee e2 = new Employee(201, "Bob", "e2@store", "1990-07-07",  "310-100-0000", "Los Angeles", false);
        entityManager.persist(e2);
        Employee e3 = new Employee(202, "Kevin", "e3@store", "1990-08-08",  "415-200-0000", "Bay Area", false);
        entityManager.persist(e3);
        Employee e4 = new Employee(203, "Chance", "e4@store", "2000-01-01",  "415-300-0000", "Chicago", true);
        entityManager.persist(e4);
        Employee e201 = new Employee(204, "Buddy", "e201@store", "2000-01-01", "650-111-1111", "Johannesburg", true);
        entityManager.persist(e201);
        Supplier sup205 = new Supplier(205, "CoolSuppliers", "123 Sunshine Way", "Los Angeles County", "12345", 4.0);
        entityManager.persist(sup205);
        Supplier sup206 = new Supplier(206, "WickedSuppliers", "123 Rainbow Way", "San FransiscoCounty", "23456", 3.0);
        entityManager.persist(sup206);
        Supplier sup207 = new Supplier(207, "AmazingSuppliers", "123 Sprinkle Way", "Contra Costa County", "34567", 2.8);
        entityManager.persist(sup207);
        Supplier sup208 = new Supplier(208, "SuperSuppliers", "123 Star Way", "San Luis Obispo County", "45678", 4.6);
        entityManager.persist(sup208);
        Supplier sup209 = new Supplier(209, "GreatSuppliers", "123 Railroad Way", "Santa Clara County", "56789", 5.0);
        entityManager.persist(sup209);
    }
    

    @Test
    @Order(3)
    public void findAllEmpsInRegion() {
        List<Employee> emps = entityManager.createQuery("select e from Employee e where e.region = 'Chicago'",
                                                        Employee.class).getResultList();
        log.info(emps.toString());
        System.out.println(emps.get(0));
        
    }

    @Test
    @Order(4)
    public void findSuppliersByCounty() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.supplierCounty = 'San Luis Obispo County'",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    @Test
    @Order(5)
    public void findSuppliersByLicenseNo() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.licenseNo = '12345'",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
    }

    @Test
    @Order(6)
    public void findSuppliersByAddress() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.supplierAddress = '123 Rainbow Way'",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
    }

    @Test
    @Order(7)
    public void findSuppliersByName() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.supplierName = 'AmazingSuppliers'",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
    }

    @Test
    @Order(8)
    public void findSuppliersByRating() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.qualityRating > 4.8",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
    }

}