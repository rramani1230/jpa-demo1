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

import javax.persistence.*;

import java.util.*;

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
	private EntityManager entityManager; 


	@BeforeEach
	public void setup() {


		//Employees
		Employee e1 = new Employee(500, "Adele Washington", "AdeleWashington@gmail.com", "1985-07-24", "202-555-0190", "Muskego", false);
        entityManager.persist(e1);
        Employee e2 = new Employee(501, "Iylah Pemberton", "IylahPemberton@gmail.com", "2002-04-18", "518-555-0130", "Largo", false);
        entityManager.persist(e2);
        Employee e3 = new Employee(502, "Patience Halliday", "PatienceHalliday@gmail.com", "1995-08-24", "410-555-0138", "Chambersburg", false);
        entityManager.persist(e3);
        Employee e4 = new Employee(503, "Cienna Wardle", "CiennaWardle@gmail.com", "1985-08-04", "404-555-0156", "Millington", true);
        entityManager.persist(e4);
        Employee e5 = new Employee(504, "Anwar Gray", "AnwarGray@gmail.com", "1980-08-11", "207-555-0160", "Madisonville", false);
        entityManager.persist(e5);
        Employee e6 = new Employee(505, "Sian Coulson", "SianCoulson@gmail.com", "1980-07-30", "512-555-0130", "Richardson", false);
        entityManager.persist(e6);
        Employee e7 = new Employee(506, "Darcie Hills", "DarcieHills@gmail.com", "1998-01-19", "225-555-0196", "Dothan", false);
        entityManager.persist(e7);
        Employee e8 = new Employee(507, "Esme Vickers", "EsmeVickers@gmail.com", "1998-06-01", "701-555-0119", "Rockaway", true);
        entityManager.persist(e8);
        Employee e9 = new Employee(508, "Tye Macdonald", "TyeMacdonald@gmail.com", "1985-05-28", "208-555-0125", "Franklin Square", false);
        entityManager.persist(e9);
        Employee e10 = new Employee(509, "Maysa Beaumont", "MaysaBeaumont@gmail.com", "1996-01-25", "617-555-0112", "Saint Charles", false);
		entityManager.persist(e10);
		
		//Regional Managers
		RegionalManager rm1 = new RegionalManager(306, "Jim Halpert", "jh@domain", "1994-09-09", "1010000000");
		entityManager.persist(rm1);
		RegionalManager rm2 = new RegionalManager(307, "Pam Beasley", "pb@domain", "1994-07-07", "2020000000");
		entityManager.persist(rm2);
		RegionalManager rm3 = new RegionalManager(308, "Kevin Malone", "km@domain", "1995-07-07", "3030000000");
		entityManager.persist(rm3);

		//LocationManagers
		LocationManager lm1 = new LocationManager(1, "locman1", "lm1@gmail.com", "1973-03-01", "916-882-3091");
        entityManager.persist(lm1);
        LocationManager lm2 = new LocationManager(2, "locman2", "lm2@gmail.com", "1981-07-12", "328-125-5863");
        entityManager.persist(lm2);
        LocationManager lm3 = new LocationManager(3, "locman3", "lm3@gmail.com", "1973-09-11", "136-028-2348");
        entityManager.persist(lm3);
		LocationManager lm4 = new LocationManager(4, "locman4", "lm4@gmail.com", "1975-03-01", "916-882-3092");
		entityManager.persist(lm4);
		LocationManager lm5 = new LocationManager(5, "locman5", "lm5@gmail.com", "1999-07-12", "328-125-5864");
		entityManager.persist(lm5);
		LocationManager lm6 = new LocationManager(6, "locman6", "lm6@gmail.com", "1969-09-11", "136-028-2309");
		entityManager.persist(lm6);
		LocationManager lm7 = new LocationManager(7, "locman7", "lm7@gmail.com", "1971-03-01", "916-882-3011");
		entityManager.persist(lm7);
		LocationManager lm8 = new LocationManager(8, "locman8", "lm8@gmail.com", "1989-07-12", "328-125-5893");
		entityManager.persist(lm8);

		//Owners
		Owner o1 = new Owner(300, "Chris Hernandez", "chris@domain", "1991-09-09", "415-400-0000");
        entityManager.persist(o1);
        Owner o2 = new Owner(301, "Richard Hendrix", "richard@domain", "1990-02-15", "415-500-0001");
        entityManager.persist(o2);
        Owner o3 = new Owner(303, "Dinesh Chugtai", "dinesh@domain", "1989-08-18", "415-500-0002");
        entityManager.persist(o3);
	   	Owner o4 = new Owner(304, "Bertram Gilfoyle", "bertram@domain", "1987-05-29", "415-500-0003");
        entityManager.persist(o4);
	   	Owner o5 = new Owner(305, "Jian Yang", "jian@domain", "1985-10-23", "415-500-0004");
		entityManager.persist(o5);

		//BoardMembers
		BoardMember bm1 = new BoardMember(351, "Joe Sanchez", "joe@domain", "1991-09-09", "4150000000", "Candy and Cookies", true);
        entityManager.persist(bm1);
        BoardMember bm2 = new BoardMember(352, "Doe Sanchez", "doe@domain", "1992-09-09", "1000000000", "Beers and Booze", true);
        entityManager.persist(bm2);
		

		//Suppliers
        Supplier sup200 = new Supplier(200, "CoolSuppliers", "123 Sunshine Way", "Los Angeles County", "12345", 4.0);
        entityManager.persist(sup200);
        Supplier sup201 = new Supplier(201, "WickedSuppliers", "123 Rainbow Way", "San FransiscoCounty", "23456", 3.0);
        entityManager.persist(sup201);
        Supplier sup202 = new Supplier(202, "AmazingSuppliers", "123 Sprinkle Way", "Contra Costa County", "34567", 2.8);
        entityManager.persist(sup202);
        Supplier sup203 = new Supplier(203, "SuperSuppliers", "123 Star Way", "San Luis Obispo County", "45678", 4.6);
        entityManager.persist(sup203);
        Supplier sup204 = new Supplier(204, "GreatSuppliers", "123 Railroad Way", "Santa Clara County", "56789", 5.0);
		entityManager.persist(sup204);


		//Stores
		Store s1 = new Store(1, "123 Sunshine Way", "SLO County");
		entityManager.persist(s1);
		Store s2 = new Store(2, "124 Sunshine Way", "SLO County");
		entityManager.persist(s2);
		Store s3 = new Store(3, "125 Sunshine Way", "SLO County");
		entityManager.persist(s3);
		Store s4 = new Store(4, "126 Sunshine Way", "SLO County");
		entityManager.persist(s4);
		Store s5 = new Store(5, "127 Sunshine Way", "SLO County");
		entityManager.persist(s5);
		Store s6 = new Store(6, "128 Sunshine Way", "SLO County");
		entityManager.persist(s6);
		Store s7 = new Store(7, "129 Sunshine Way", "SLO County");
		entityManager.persist(s7);
		Store s8 = new Store(8, "130 Sunshine Way", "SLO County");
		entityManager.persist(s8);

		Item item1 = new Item(1, "Item1", 1.5, true);
		entityManager.persist(item1);
		Item item2 = new Item(2, "Item2", 2.5, false);
		entityManager.persist(item2);
		Item item3 = new Item(3, "Item3", 3.5, true);
		entityManager.persist(item3);
		Item item4 = new Item(4, "Item4", 4.5, false);
		entityManager.persist(item4);
		Item item5 = new Item(5, "Item5", 5.5, true);
		entityManager.persist(item5);
		Item item6 = new Item(6, "Item6", 6.5, false);
		entityManager.persist(item6);
		Item item7 = new Item(7, "Item7", 7.5, true);
		entityManager.persist(item7);
		Item item8 = new Item(8, "Item8", 8.5, false);
		entityManager.persist(item8);
		Item item9 = new Item(9, "Item9", 9.5, true);
		entityManager.persist(item9);
		Item item10 = new Item(10, "Item10", 10.5, false);
		entityManager.persist(item10);
		Item item11 = new Item(11, "Item11", 11.5, true);
		entityManager.persist(item11);
		Item item12 = new Item(12, "Item12", 12.5, false);
		entityManager.persist(item12);
		Item item13 = new Item(13, "Item13", 13.5, true);
		entityManager.persist(item13);
		Item item14 = new Item(14, "Item14", 14.5, false);
		entityManager.persist(item14);
		Item item15 = new Item(15, "Item15", 15.5, true);
		entityManager.persist(item15);
		Item item16 = new Item(16, "Item16", 16.5, true);
		entityManager.persist(item16);
		Item item17 = new Item(17, "Item17", 22.5, false);
		entityManager.persist(item17);
		Item item18 = new Item(18, "Item18", 33.5, true);
		entityManager.persist(item18);
		Item item19 = new Item(19, "Item19", 41.5, false);
		entityManager.persist(item19);
		Item item20 = new Item(20, "Item20", 15.5, true);
		entityManager.persist(item20);
		Item item21 = new Item(21, "Item21", 11.5, false);
		entityManager.persist(item21);
		Item item22 = new Item(22, "Item22", 12.5, true);
		entityManager.persist(item22);
		Item item23 = new Item(23, "Item23", 13.5, false);
		entityManager.persist(item23);
		Item item24 = new Item(24, "Item24", 14.5, true);
		entityManager.persist(item24);
		Item item25 = new Item(25, "Item25", 15.5, false);
		entityManager.persist(item25);
		Item item26 = new Item(26, "Item26", 1, true);
		entityManager.persist(item26);
		Item item27 = new Item(27, "Item27", 12.5, false);
		entityManager.persist(item27);
		Item item28 = new Item(28, "Item28", 33.5, true);
		entityManager.persist(item28);
		Item item29 = new Item(29, "Item29", 14.5, false);
		entityManager.persist(item29);
		Item item30 = new Item(30, "Item30", 15.5, true);
		entityManager.persist(item30);


		
		//Customers
		Customer c1 = new Customer(600, "Daniel", "djones@gmail.com", "12-12-1990", "123-456-0000", true, s3, item1);
        entityManager.persist(c1);
        Customer c2 = new Customer(601, "Mike", "miko@gmail.com", "12-12-1998", "123-654-0001", true, s2, item2);
        entityManager.persist(c2);
        Customer c3 = new Customer(602, "Alan", "alan@gmail.com", "12-30-1998", "123-654-0002", true, s3, item23);
        entityManager.persist(c3);
		Customer c4 = new Customer(603, "Billy", "billy@gmail.com", "12-30-2000", "123-654-0003", false, s4, item13);
		entityManager.persist(c4);
		Customer c5 = new Customer(604, "Cathy", "billy@gmail.com", "12-30-1999", "123-654-0004", false, s1, item24);
		entityManager.persist(c5);
		Customer c6 = new Customer(605, "Dillon", "billy@gmail.com", "12-15-1998", "123-654-0005", false, s4, item27);
		entityManager.persist(c6);
		Customer c7 = new Customer(606, "Eliza", "billy@gmail.com", "10-30-1998", "123-654-0006", false, s3, item19);
		entityManager.persist(c7);
		Customer c8 = new Customer(607, "Fred", "billy@gmail.com", "08-30-1998", "123-654-0007", true, s2, item11);
		entityManager.persist(c8);
		Customer c9 = new Customer(608, "Gina", "billy@gmail.com", "02-28-1994", "123-654-0008", false, s1, item30);
		entityManager.persist(c9);
		Customer c10 = new Customer(609, "Helen", "billy@gmail.com", "11-30-1998", "123-654-0009", false, s4, item15);
		entityManager.persist(c10);

		//Inventory
		Inventory in1 = new Inventory(s1,item1,5);
		entityManager.persist(in1);
		Inventory in2 = new Inventory(s1,item2,5);
		entityManager.persist(in2);
		Inventory in3 = new Inventory(s2,item3,5);
		entityManager.persist(in3);
		Inventory in4 = new Inventory(s2,item21,5);
		entityManager.persist(in4);
		Inventory in5 = new Inventory(s3,item13,5);
		entityManager.persist(in5);
		Inventory in6 = new Inventory(s3,item12,5);
		entityManager.persist(in6);
		Inventory in7 = new Inventory(s4,item2,5);
		entityManager.persist(in7);
		Inventory in8 = new Inventory(s4,item3,5);
		entityManager.persist(in8);
		Inventory in9 = new Inventory(s5,item21,5);
		entityManager.persist(in9);
		Inventory in10 = new Inventory(s5,item13,5);
		entityManager.persist(in10);
		Inventory in11 = new Inventory(s6,item26,5);
		entityManager.persist(in11);
		Inventory in12 = new Inventory(s6,item21,5);
		entityManager.persist(in12);
		Inventory in13 = new Inventory(s7,item13,5);
		entityManager.persist(in13);
		Inventory in14 = new Inventory(s7,item30,5);
		entityManager.persist(in14);
		Inventory in15 = new Inventory(s8,item29,5);
		entityManager.persist(in15);
		Inventory in16 = new Inventory(s8,item28,5);
		entityManager.persist(in16);

		//Scheduler
		Scheduler se1 = new Scheduler(e1,s1,"Week 1", 3.5);
		entityManager.persist(se1);
		Scheduler se2 = new Scheduler(e1,s1,"Week 2", 4.5);
		entityManager.persist(se2);
		Scheduler se3 = new Scheduler(e2,s2,"Week 1", 3.5);
		entityManager.persist(se3);
		Scheduler se4 = new Scheduler(e2,s2,"Week 2", 4.5);
		entityManager.persist(se4);
		Scheduler se5 = new Scheduler(e3,s2,"Week 1", 3.5);
		entityManager.persist(se5);
		Scheduler se6 = new Scheduler(e3,s2,"Week 2", 4.5);
		entityManager.persist(se6);
		Scheduler se7 = new Scheduler(e4,s3,"Week 1", 7);
		entityManager.persist(se7);
		Scheduler se8 = new Scheduler(e5,s4,"Week 1", 2);
		entityManager.persist(se8);
		Scheduler se9 = new Scheduler(e5,s4,"Week 2", 3);
		entityManager.persist(se9);
		Scheduler se10 = new Scheduler(e6,s5,"Week 2", 8);
		entityManager.persist(se10);
		Scheduler se11 = new Scheduler(e7,s5,"Week 1", 8);
		entityManager.persist(se11);
		Scheduler se12 = new Scheduler(e7,s5,"Week 2", 8);
		entityManager.persist(se12);
		Scheduler se13 = new Scheduler(e8,s6,"Week 1", 5);
		entityManager.persist(se13);
		Scheduler se14 = new Scheduler(e9,s7,"Week 2", 10);
		entityManager.persist(se14);
		Scheduler se15 = new Scheduler(e10,s8,"Week 1", 7);
		entityManager.persist(se15);

	   Shipment sh1 = new Shipment(sup200,s1,item5,10,"05/07/2020");
	   entityManager.persist(sh1);
	   Shipment sh2 = new Shipment(sup200,s2,item2,10,"05/13/2020");
	   entityManager.persist(sh2);
	   Shipment sh3 = new Shipment(sup200,s3,item3,10,"05/11/2020");
	   entityManager.persist(sh3);
	   Shipment sh4 = new Shipment(sup200,s6,item5,10,"05/09/2020");
	   entityManager.persist(sh4);
	   Shipment sh5 = new Shipment(sup200,s8,item8,10,"05/08/2020");
	   entityManager.persist(sh5);
	   Shipment sh6 = new Shipment(sup201,s4,item23,12,"06/11/2020");
	   entityManager.persist(sh6);
	   Shipment sh7 = new Shipment(sup201,s6,item16,6,"06/11/2020");
	   entityManager.persist(sh7);
	   Shipment sh8 = new Shipment(sup201,s3,item19,5,"06/11/2020");
	   entityManager.persist(sh8);
	   Shipment sh9 = new Shipment(sup201,s1,item24,10,"06/11/2020");
	   entityManager.persist(sh9);
	   Shipment sh10 = new Shipment(sup201,s8,item12,8,"06/11/2020");
	   entityManager.persist(sh10);
	   Shipment sh11 = new Shipment(sup202,s5,item21,13,"07/11/2020");
	   entityManager.persist(sh11);
	   Shipment sh12 = new Shipment(sup202,s2,item29,9,"06/12/2020");
	   entityManager.persist(sh12);
	   Shipment sh13 = new Shipment(sup202,s7,item27,10,"08/11/2020");
	   entityManager.persist(sh13);
	   Shipment sh14 = new Shipment(sup202,s7,item24,15,"06/13/2020");
	   entityManager.persist(sh14);
	   Shipment sh15 = new Shipment(sup202,s1,item28,7,"10/11/2020");
	   entityManager.persist(sh15);
	   Shipment sh16 = new Shipment(sup203,s3,item20,9,"08/11/2020");
	   entityManager.persist(sh16);
	   Shipment sh17 = new Shipment(sup203,s2,item14,10,"06/21/2020");
	   entityManager.persist(sh17);
	   Shipment sh18 = new Shipment(sup203,s7,item24,20,"06/13/2020");
	   entityManager.persist(sh18);
	   Shipment sh19 = new Shipment(sup203,s1,item19,6,"09/11/2020");
	   entityManager.persist(sh19);
	   Shipment sh20 = new Shipment(sup203,s3,item20,9,"10/11/2020");
	   entityManager.persist(sh20);
	   Shipment sh21 = new Shipment(sup204,s6,item30,11,"11/11/2020");
	   entityManager.persist(sh21);
	   Shipment sh22 = new Shipment(sup204,s4,item23,4,"01/11/2020");
	   entityManager.persist(sh22);
	   Shipment sh23 = new Shipment(sup204,s8,item26,6,"02/11/2020");
	   entityManager.persist(sh23);
	   Shipment sh24 = new Shipment(sup204,s1,item23,10,"03/11/2020");
	   entityManager.persist(sh24);
	   Shipment sh25 = new Shipment(sup204,s7,item16,9,"04/11/2020");
	   entityManager.persist(sh25);

	   //Receipt
	   Receipt receipt1 = new Receipt("04/12/2020", c1, item1, s1);
	   entityManager.persist(receipt1);
	   Receipt receipt2 = new Receipt("04/13/2020", c2, item13, s4);
	   entityManager.persist(receipt2);
	   Receipt receipt3 = new Receipt("04/14/2020", c3, item21, s2);
	   entityManager.persist(receipt3);
	   Receipt receipt4 = new Receipt("04/15/2020", c4, item24, s8);
	   entityManager.persist(receipt4);
	   Receipt receipt5 = new Receipt("04/16/2020", c5, item11, s3);
	   entityManager.persist(receipt5);
	   Receipt receipt6 = new Receipt("04/17/2020", c6, item11, s4);
	   entityManager.persist(receipt6);
	   Receipt receipt7 = new Receipt("04/18/2020", c7, item15, s5);
	   entityManager.persist(receipt7);
	   Receipt receipt8 = new Receipt("04/19/2020", c8, item17, s6);
	   entityManager.persist(receipt8);
	   Receipt receipt9 = new Receipt("04/20/2020", c9, item19, s7);
	   entityManager.persist(receipt9);
	   Receipt receipt10 = new Receipt("04/21/2020", c1, item14, s8);
	   entityManager.persist(receipt10);

	}


    @Test
    @Order(0)
    public void supplierQuery1() {
	    List<Supplier> sups = entityManager.createQuery(
             "select s from Supplier s where s.qualityRating > 4.0",
             Supplier.class).getResultList();
    
		for (int i = 0; i < sups.size(); i++) {
			System.out.println(sups.get(i));
		}
	}

    public void supplierQuery2() {
	List<Supplier> sups = entityManager.createQuery(
		   "select s from Supplier s, Shipment sh where s.supplier_id = 204",
		   Supplier.class).getResultList();
    
	    for (int i = 0; i < sups.size(); i++) {
		    System.out.println(sups.get(i));
	    }
    }
    
    @Test
    @Order(4)
    public void findSuppliersByCounty() {
        List<Supplier> sups = entityManager.createQuery(
            "select s from Supplier s where s.supplierCounty = 'San Luis Obispo County'",
            Supplier.class).getResultList();
        System.out.println(sups.get(0));
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

	public void findTruckDrivers() {
        List<Customer> cust = entityManager.createQuery(
            "select c from Customer c where c.truck_driver = true",
            Customer.class).getResultList();
        System.out.println(cust.get(0));
	}

	@Test
    @Order(7)
    public void findMostPopularItemID() {
        List<Customer> custs1 = entityManager.createQuery(
            "SELECT c1 FROM Customer c1 where c1.truck_driver = true and c1.favorite_item = 1",
            Customer.class).getResultList();
        System.out.println(custs1.get(0));
	}
	@Test
    @Order(8)
    public void findAllEmpsInRegion() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.region = 'Rockaway'",
            Employee.class).getResultList();
        System.out.println(emps.get(0));
    }
    @Test
    @Order(9)
    public void findAllEmpsID() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.id = 509",
            Employee.class).getResultList();
        System.out.println(emps.get(0));
	}
	
	@Test
    @Order(10)
    public void findAllEmpsName() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.name = 'Adele Washington'",
			Employee.class).getResultList();
        System.out.println(emps.get(0));
	}
	
    @Test
    @Order(11)
    public void findAllEmpsEmail() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.email = 'MaysaBeaumont@gmail.com'",
            Employee.class).getResultList();
        System.out.println(emps.get(0));
    }
    @Test
    @Order(12)
    public void findAllEmpsDOB() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.dateOfBirth = '2002-04-18'",
			Employee.class).getResultList();
        System.out.println(emps.get(0));
    }
    @Test
    @Order(13)
    public void findAllEmpsPhoneNum() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.phoneNo = '207-555-0160'",
			Employee.class).getResultList();
        System.out.println(emps.get(0));
	}
	
	@Test
    @Order(14)
    public void findAllEmpsInjured() {
        List<Employee> emps = entityManager.createQuery(
			"select e from Employee e where e.injured = true",
            Employee.class).getResultList();
        System.out.println(emps.get(0));
	}
	@Test
	@Order(15)
	public void findShipmentByDate() {
		List<Shipment> shipments = entityManager.createQuery(
			"select s from Shipment s where s.date = '06/11/2020'",
			Shipment.class).getResultList();
		System.out.println(shipments.get(0));
	}
	@Test
	@Order(16)
	public void findShipmentByStoreId() {
		List<Shipment> shipments = entityManager.createQuery(
			"select s from Shipment s where s.store = 5",
			Shipment.class).getResultList();
		System.out.println(shipments.get(0));
	}
	@Test
	@Order(17)
	public void findShipmentByItemAndQuantity() {
		List<Shipment> shipments = entityManager.createQuery(
			"select s from Shipment s where s.item = 23 and s.quantity = 10",
			Shipment.class).getResultList();
		System.out.println(shipments.get(0));
	}
	@Test
	@Order(18)
	public void findShipmentBySupplier() {
		List<Shipment> shipments = entityManager.createQuery(
			"select s from Shipment s where s.supplier != 202",
			Shipment.class).getResultList();
		System.out.println(shipments.get(0));
	}
	@Test
	@Order(19)
	public void findInventoryByStore() {
		List<Inventory> inventory = entityManager.createQuery(
			"select i from Inventory i where i.store != 5",
			Inventory.class).getResultList();
		System.out.println(inventory.get(0));
	}
	@Test
	@Order(20)
	public void findInventoryByItemAndQuantity() {
		List<Inventory> inventory = entityManager.createQuery(
			"select i from Inventory i where i.item = 2 and i.quantity = 5",
			Inventory.class).getResultList();
		System.out.println(inventory.get(0));
	}
	@Test
	@Order(21)
	public void findStoreByAddressAndCounty() {
		List<Store> stores = entityManager.createQuery(
			"select s from Store s where s.address = '123 Sunshine Way' and s.county = 'SLO County'",
			Store.class).getResultList();
		System.out.println(stores.get(0));
	}
	@Test
	@Order(22)
	public void findStoreByInventoryAndLocationManager() {
		List<Store> stores = entityManager.createQuery(
			"select s from Store s where s.id = 8",
			Store.class).getResultList();
		System.out.println(stores.get(0));
	}
	@Test
	@Order(23)
	public void findSchedulerByEmployeeAndStore() {
		List<Scheduler> schedulers = entityManager.createQuery(
			"select s from Scheduler s where s.employee = 506 and s.store = 5",
			Scheduler.class).getResultList();
		System.out.println(schedulers.get(0));
	}
	@Test
	@Order(24)
	public void findSchedulerByWeek() {
		List<Scheduler> schedulers = entityManager.createQuery(
			"select s from Scheduler s where s.week = 'Week 1'",
			Scheduler.class).getResultList();
		System.out.println(schedulers.get(0));
	}
	@Test
	@Order(25)
	public void findSchedulerByHours() {
		List<Scheduler> schedulers = entityManager.createQuery(
			"select s from Scheduler s where s.hours > 5",
			Scheduler.class).getResultList();
		System.out.println(schedulers.get(0));
	}
	@Test
	@Order(26)
	public void findItemByPrepackaged() {
		List<Item> items = entityManager.createQuery(
			"select i from Item i where prepackaged = true",
			Item.class).getResultList();
		System.out.println(items.get(0));
	}
	@Test
	@Order(27)
	public void findItemByItemCost() {
		List<Item> items = entityManager.createQuery(
			"select i from Item i where i.itemCost < 20",
			Item.class).getResultList();
		System.out.println(items.get(0));
	}
	@Test
	@Order(28)
	public void findItemByItemName() {
		List<Item> items = entityManager.createQuery(
			"select i from Item i where i.itemName = 'Item20'",
			Item.class).getResultList();
		System.out.println(items.get(0));
	}
	@Test
	@Order(29)
	public void findLocationManagerByName() {
		List<LocationManager> managers = entityManager.createQuery(
			"select l from LocationManager l where l.name = 'locman3'",
			LocationManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(30)
	public void findLocationManagerByEmail() {
		List<LocationManager> managers = entityManager.createQuery(
			"select l from LocationManager l where l.email = 'lm4@gmail.com'",
			LocationManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(31)
	public void findLocationManagerByDateOfBirth() {
		List<LocationManager> managers = entityManager.createQuery(
			"select l from LocationManager l where l.dateOfBirth = '1999-07-12'",
			LocationManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(32)
	public void findLocationManagerByPhoneNo() {
		List<LocationManager> managers = entityManager.createQuery(
			"select l from LocationManager l where l.phoneNo = '136-028-2309'",
			LocationManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(33)
	public void findRegionalManagerByName() {
		List<RegionalManager> managers = entityManager.createQuery(
			"select r from RegionalManager r where r.name = 'Jim Halpert'",
			RegionalManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(34)
	public void findRegionalManagerByEmail() {
		List<RegionalManager> managers = entityManager.createQuery(
			"select r from RegionalManager r where r.email = 'jh@domain'",
			RegionalManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(35)
	public void findRegionalManagerByDateOfBirth() {
		List<RegionalManager> managers = entityManager.createQuery(
			"select r from RegionalManager r where r.dateOfBirth = '1994-09-09'",
			RegionalManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(36)
	public void findRegionalManagerByPhoneNo() {
		List<RegionalManager> managers = entityManager.createQuery(
			"select r from RegionalManager r where r.phoneNo = '2020000000'",
			RegionalManager.class).getResultList();
		System.out.println(managers.get(0));
	}
	@Test
	@Order(37)
	public void findOwnerByName() {
		List<Owner> owners = entityManager.createQuery(
			"select o from Owner o where o.name = 'Richard Hendrix'",
			Owner.class).getResultList();
		System.out.println(owners.get(0));
	}
	@Test
	@Order(38)
	public void findOwnerByEmail() {
		List<Owner> owners = entityManager.createQuery(
			"select o from Owner o where o.email = 'dinesh@domain'",
			Owner.class).getResultList();
		System.out.println(owners.get(0));
	}
	@Test
	@Order(39)
	public void findOwnerByDateOfBirth() {
		List<Owner> owners = entityManager.createQuery(
			"select o from Owner o where o.dateOfBirth = '1987-05-29'",
			Owner.class).getResultList();
		System.out.println(owners.get(0));
	}
	@Test
	@Order(40)
	public void findOwnerByPhoneNo() {
		List<Owner> owners = entityManager.createQuery(
			"select o from Owner o where o.phoneNo = '415-500-0004'",
			Owner.class).getResultList();
		System.out.println(owners.get(0));
	}
	BoardMember bm1 = new BoardMember(351, "Joe Sanchez", "joe@domain", "1991-09-09", "4150000000", "Candy and Cookies", true);
	@Test
	@Order(41)
	public void findBoardMemberByNameEmailDoBPhoneNo() {
		List<BoardMember> boardMembers = entityManager.createQuery(
			"select b from BoardMember b where b.name = 'Joe Sanchez' and b.email = 'joe@domain' and b.dateOfBirth = '1991-09-09' and b.phoneNo = '4150000000'",
			BoardMember.class).getResultList();
		System.out.println(boardMembers.get(0));
	}
	@Test
	@Order(42)
	public void findBoardMemberHasDegree() {
		List<BoardMember> boardMembers = entityManager.createQuery(
			"select b from BoardMember b where b.hasDegree = true",
			BoardMember.class).getResultList();
		System.out.println(boardMembers.get(0));
	}
	@Test
	@Order(43)
	public void findBoardMemberBoardStrategy() {
		List<BoardMember> boardMembers = entityManager.createQuery(
			"select b from BoardMember b where b.boardStrategy = 'Beers and Booze'",
			BoardMember.class).getResultList();
		System.out.println(boardMembers.get(0));
	}

	@Test
	@Order(44)
	public void findReceiptsFromDate() {
		List<Receipt> lor = entityManager.createQuery(
			"select r from Receipt r where r.date = '04/14/2020'", Receipt.class).getResultList();
		System.out.println(lor.get(0));
	}

	@Test
	@Order(45)
	public void findReceiptsFromSpecificStore() {
		List<Receipt> lor = entityManager.createQuery(
			"select r from Receipt r where r.store = 5", Receipt.class).getResultList();
		System.out.println(lor.get(0));
	}

	@Test
	@Order(46)
	public void findReceiptsFromSpecificCustomer() {
		List<Receipt> lor = entityManager.createQuery(
			"select r from Receipt r where r.customer = 600", Receipt.class
		).getResultList();
		System.out.println(lor.get(0));
	}

}
