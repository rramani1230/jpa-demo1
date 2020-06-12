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

        Customer c1 = new Customer(600, "Daniel", "djones@gmail.com", "12-12-1990", "123-456-7890", true, 1, 1);
        entityManager.persist(c1);
        Customer c2 = new Customer(601, "Mike", "miko@gmail.com", "12-12-1998", "123-654-7890", false, 2, 2);
        entityManager.persist(c2);
        Customer c3 = new Customer(602, "Mike", "miko@gmail.com", "12-12-1998", "123-654-7890", false, 1, 1);
        entityManager.persist(c3);

        Employee e11 = new Employee(500, "Adele Washington", "AdeleWashington@gmail.com", "1985-07-24", "202-555-0190", "Muskego", false);
        entityManager.persist(e11);
        Employee e12 = new Employee(501, "Iylah Pemberton", "IylahPemberton@gmail.com", "2002-04-18", "518-555-0130", "Largo", false);
        entityManager.persist(e12);
        Employee e13 = new Employee(502, "Patience Halliday", "PatienceHalliday@gmail.com", "1995-08-24", "410-555-0138", "Chambersburg", false);
        entityManager.persist(e13);
        Employee e14 = new Employee(503, "Cienna Wardle", "CiennaWardle@gmail.com", "1985-08-04", "404-555-0156", "Millington", true);
        entityManager.persist(e14);
        Employee e15 = new Employee(504, "Anwar Gray", "AnwarGray@gmail.com", "1980-08-11", "207-555-0160", "Madisonville", false);
        entityManager.persist(e15);
        Employee e16 = new Employee(505, "Sian Coulson", "SianCoulson@gmail.com", "1980-07-30", "512-555-0130", "Richardson", false);
        entityManager.persist(e16);
        Employee e17 = new Employee(506, "Darcie Hills", "DarcieHills@gmail.com", "1998-01-19", "225-555-0196", "Dothan", false);
        entityManager.persist(e17);
        Employee e18 = new Employee(507, "Esme Vickers", "EsmeVickers@gmail.com", "1998-06-01", "701-555-0119", "Rockaway", true);
        entityManager.persist(e18);
        Employee e19 = new Employee(508, "Tye Macdonald", "TyeMacdonald@gmail.com", "1985-05-28", "208-555-0125", "Franklin Square", false);
        entityManager.persist(e19);
        Employee e20 = new Employee(509, "Maysa Beaumont", "MaysaBeaumont@gmail.com", "1996-01-25", "617-555-0112", "Saint Charles", false);
        entityManager.persist(e20);

        /*LocationManager lm1 = new LocationManager(1, "John Doe", "JohnDoe@gmail.com", "1973-03-01", "916-882-3091");
        entityManager.persist(lm1);
        LocationManager lm2 = new LocationManager(2, "Rob Lopez", "RobLopez@gmail.com", "1981-07-12", "328-125-5863");
        entityManager.persist(lm2);
        LocationManager lm3 = new LocationManager(3, "Sam Smith", "SamSmith@gmail.com", "1973-09-11", "136-028-2348");
        entityManager.persist(lm3);*/

        Owner o1 = new Owner(300, "ownerone", "owner@domain", "1991-09-09", "415-400-0000");
        entityManager.persist(o1);
        Owner o2 = new Owner(301, "ownertwo", "owner2@domain", "1991-09-09", "415-500-0000");
        entityManager.persist(o2);
        Owner o3 = new Owner(302, "ownertwo", "owner2@domain", "1991-09-09", "415-500-0000");
        entityManager.persist(o3);

        BoardMember bm1 = new BoardMember(303, "Joe", "bm1@domain", "1991-09-09", "415", "Candy and Cookies", true);
        entityManager.persist(bm1);
        BoardMember bm2 = new BoardMember(304, "Doe", "bm2@domain", "1992-09-09", "100", "Beers and Booze", true);
        entityManager.persist(bm2);
        BoardMember bm3 = new BoardMember(305, "Poe", "bm3@domain", "1993-09-09", "200", "Brunch Business", true);
        entityManager.persist(bm3);
        
        RegionalManager rm1 = new RegionalManager(306, "ManagerOne", "rm1@domain", "1994-09-09", "101");
        entityManager.persist(rm1);
        RegionalManager rm2 = new RegionalManager(307, "ManagerTwo", "rm2@domain", "1994-07-07", "202");
        entityManager.persist(rm2);
        RegionalManager rm3 = new RegionalManager(308, "ManagerThree", "rm3@domain", "1995-07-07", "303");
        entityManager.persist(rm3);
        RegionalManager rm4 = new RegionalManager(309, "ManagerFour", "rm4@domain", "1994-04-04", "404");
        entityManager.persist(rm4);
        RegionalManager rm5 = new RegionalManager(310, "ManagerFive", "rm5@domain", "1995-05-05", "505");
        entityManager.persist(rm5);
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