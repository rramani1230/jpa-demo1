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

        Customer c1 = new Customer(600, "Daniel", "djones@gmail.com", "12-12-1990", "123-456-0000", true, 3, 1);
        entityManager.persist(c1);
        Customer c2 = new Customer(601, "Mike", "miko@gmail.com", "12-12-1998", "123-654-0001", true, 2, 2);
        entityManager.persist(c2);
        Customer c3 = new Customer(602, "Alan", "alan@gmail.com", "12-30-1998", "123-654-0002", true, 3, 1);
        entityManager.persist(c3);
	   Customer c4 = new Customer(603, "Billy", "billy@gmail.com", "12-30-2000", "123-654-0003", false, 4, 3);
	   entityManager.persist(c4);
	   Customer c5 = new Customer(604, "Cathy", "billy@gmail.com", "12-30-1999", "123-654-0004", false, 1, 4);
	   entityManager.persist(c5);
	   Customer c6 = new Customer(605, "Dillon", "billy@gmail.com", "12-15-1998", "123-654-0005", false, 4, 7);
	   entityManager.persist(c6);
	   Customer c7 = new Customer(606, "Eliza", "billy@gmail.com", "10-30-1998", "123-654-0006", false, 3, 9);
	   entityManager.persist(c7);
	   Customer c8 = new Customer(607, "Fred", "billy@gmail.com", "08-30-1998", "123-654-0007", true, 2, 11);
	   entityManager.persist(c8);
	   Customer c9 = new Customer(608, "Gina", "billy@gmail.com", "02-28-1994", "123-654-0008", false, 1, 13);
	   entityManager.persist(c9);
	   Customer c10 = new Customer(609, "Helen", "billy@gmail.com", "11-30-1998", "123-654-0009", false, 4, 15);
	   entityManager.persist(c10);


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

	   RegionalManager rm1 = new RegionalManager(306, "Jim Halpert", "jh@domain", "1994-09-09", "1010000000");
	   entityManager.persist(rm1);
	   RegionalManager rm2 = new RegionalManager(307, "Pam Beasley", "pb@domain", "1994-07-07", "2020000000");
	   entityManager.persist(rm2);
	   RegionalManager rm3 = new RegionalManager(308, "Kevin Malone", "km@domain", "1995-07-07", "3030000000");
	   entityManager.persist(rm3);
	   // RegionalManager rm4 = new RegionalManager(309, "Dwight Schrute", "ds@domain", "1994-04-04", "4040000000");
	   // entityManager.persist(rm4);
	   // RegionalManager rm5 = new RegionalManager(310, "Michael Scott", "ms@domain", "1995-05-05", "5050000000");
	   // entityManager.persist(rm5);
	   // RegionalManager rm6 = new RegionalManager(311, "Creed Bratton", "cb@domain", "1995-05-19", "6060000000");
	   // entityManager.persist(rm6);
	   // RegionalManager rm7 = new RegionalManager(312, "Andrea Martin", "am@domain", "1995-05-28", "7070000000");
	   // entityManager.persist(rm7);


	   //
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
	   // LocationManager lm9 = new LocationManager(9, "locman9", "lm9@gmail.com", "1970-09-11", "136-028-2349");
	   // entityManager.persist(lm9);
	   // LocationManager lm10 = new LocationManager(10, "locman10", "lm10@gmail.com", "1975-03-01", "916-882-3093");
	   // entityManager.persist(lm10);
	   // LocationManager lm11 = new LocationManager(11, "locman11", "lm11@gmail.com", "1996-07-12", "328-125-1864");
	   // entityManager.persist(lm11);
	   // LocationManager lm12 = new LocationManager(12, "locman12", "lm12@gmail.com", "1960-09-11", "136-028-2329");
	   // entityManager.persist(lm12);
	   // LocationManager lm13 = new LocationManager(13, "locman13", "lm13@gmail.com", "1979-03-01", "916-882-3193");
	   // entityManager.persist(lm13);
	   // LocationManager lm14 = new LocationManager(14, "locman14", "lm14@gmail.com", "2009-07-12", "328-125-1064");
	   // entityManager.persist(lm14);
	   // LocationManager lm15 = new LocationManager(15, "locman15", "lm15@gmail.com", "2008-09-11", "136-028-2129");
	   // entityManager.persist(lm15);
	   // //

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
	   //
        BoardMember bm1 = new BoardMember(351, "Joe Sanchez", "joe@domain", "1991-09-09", "4150000000", "Candy and Cookies", true);
        entityManager.persist(bm1);
        BoardMember bm2 = new BoardMember(352, "Doe Sanchez", "doe@domain", "1992-09-09", "1000000000", "Beers and Booze", true);
        // entityManager.persist(bm2);
        // BoardMember bm3 = new BoardMember(353, "Poe Sanchez", "poe@domain", "1993-09-09", "2000000000", "Brunch Business", true);
        // entityManager.persist(bm3);
	   // BoardMember bm4 = new BoardMember(354, "Moe Sanchez", "moe@domain", "1994-09-09", "2000000001", "Soft Drinks", true);
	   // entityManager.persist(bm4);
	   //

	   //
	   Store s1 = new Store(1, "123 Sunshine Way", "SLO County", 1, 1);
	   entityManager.persist(s1);
	   Store s2 = new Store(2, "124 Sunshine Way", "SLO County", 2, 2);
	   entityManager.persist(s2);
	   Store s3 = new Store(3, "125 Sunshine Way", "SLO County", 3, 3);
	   entityManager.persist(s3);
	   Store s4 = new Store(4, "126 Sunshine Way", "SLO County", 4, 4);
	   entityManager.persist(s4);
	   Store s5 = new Store(5, "127 Sunshine Way", "SLO County", 5, 5);
	   entityManager.persist(s5);
	   Store s6 = new Store(6, "128 Sunshine Way", "SLO County", 6, 6);
	   entityManager.persist(s6);
	   Store s7 = new Store(7, "129 Sunshine Way", "SLO County", 7, 7);
	   entityManager.persist(s7);
	   Store s8 = new Store(8, "130 Sunshine Way", "SLO County", 8, 8);
	   entityManager.persist(s8);
	   // Store s9 = new Store(9, "131 Sunshine Way", "SLO County", 9, 9);
	   // entityManager.persist(s9);
	   // Store s10 = new Store(10, "132 Sunshine Way", "SLO County", 10, 10);
	   // entityManager.persist(s10);
	   // Store s11 = new Store(11, "133 Sunshine Way", "SLO County", 11, 11);
	   // entityManager.persist(s11);
	   // Store s12 = new Store(12, "134 Sunshine Way", "SLO County", 12, 12);
	   // entityManager.persist(s12);
	   // Store s13 = new Store(13, "135 Sunshine Way", "SLO County", 13, 13);
	   // entityManager.persist(s13);
	   // Store s14 = new Store(14, "136 Sunshine Way", "SLO County", 14, 14);
	   // entityManager.persist(s14);
	   // Store s15 = new Store(15, "137 Sunshine Way", "SLO County", 15, 15);
	   // entityManager.persist(s15);
	   //
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

	   Inventory in1 = new Inventory(1,1,5);
	   entityManager.persist(in1);
	   Inventory in2 = new Inventory(1,2,5);
	   entityManager.persist(in2);
	   Inventory in3 = new Inventory(2,3,5);
	   entityManager.persist(in3);
	   Inventory in4 = new Inventory(2,21,5);
	   entityManager.persist(in4);
	   Inventory in5 = new Inventory(3,13,5);
	   entityManager.persist(in5);
	   Inventory in6 = new Inventory(3,12,5);
	   entityManager.persist(in6);
	   Inventory in7 = new Inventory(4,2,5);
	   entityManager.persist(in7);
	   Inventory in8 = new Inventory(4,3,5);
	   entityManager.persist(in8);
	   Inventory in9 = new Inventory(5,21,5);
	   entityManager.persist(in9);
	   Inventory in10 = new Inventory(5,13,5);
	   entityManager.persist(in10);
//-------------------------------------------------
	   Inventory in11 = new Inventory(6,26,5);
	   entityManager.persist(in11);
	   Inventory in12 = new Inventory(6,21,5);
	   entityManager.persist(in12);
	   Inventory in13 = new Inventory(7,13,5);
	   entityManager.persist(in13);
	   Inventory in14 = new Inventory(7,30,5);
	   entityManager.persist(in14);
	   Inventory in15 = new Inventory(8,29,5);
	   entityManager.persist(in15);
	   Inventory in16 = new Inventory(8,28,5);
	   entityManager.persist(in16);
// 	   Inventory in17 = new Inventory(9,27,5);
// 	   entityManager.persist(in17);
// 	   Inventory in18 = new Inventory(9,25,5);
// 	   entityManager.persist(in18);
// 	   Inventory in19 = new Inventory(10,23,5);
// 	   entityManager.persist(in19);
// 	   Inventory in20 = new Inventory(10,21,5);
// 	   entityManager.persist(in20);
// //---------------------------------------------------
// 	   Inventory in21 = new Inventory(11,11,5);
// 	   entityManager.persist(in21);
// 	   Inventory in22 = new Inventory(11,21,5);
// 	   entityManager.persist(in22);
// 	   Inventory in23 = new Inventory(12,31,5);
// 	   entityManager.persist(in23);
// 	   Inventory in24 = new Inventory(12,11,5);
// 	   entityManager.persist(in24);
// 	   Inventory in25 = new Inventory(13,13,5);
// 	   entityManager.persist(in25);
// 	   Inventory in26 = new Inventory(13,22,5);
// 	   entityManager.persist(in26);
// 	   Inventory in27 = new Inventory(14,12,5);
// 	   entityManager.persist(in27);
// 	   Inventory in28 = new Inventory(14,19,5);
// 	   entityManager.persist(in28);
// 	   Inventory in29 = new Inventory(15,18,5);
// 	   entityManager.persist(in29);
// 	   Inventory in30 = new Inventory(15,16,5);
// 	   entityManager.persist(in30);

	   Scheduler se1 = new Scheduler(1,1,"Week 1", 3.5);
	   entityManager.persist(se1);
	   Scheduler se2 = new Scheduler(1,1,"Week 2", 4.5);
	   entityManager.persist(se2);
	   Scheduler se3 = new Scheduler(2,2,"Week 1", 3.5);
	   entityManager.persist(se3);
	   Scheduler se4 = new Scheduler(2,2,"Week 2", 4.5);
	   entityManager.persist(se4);
	   Scheduler se5 = new Scheduler(3,2,"Week 1", 3.5);
	   entityManager.persist(se5);
	   Scheduler se6 = new Scheduler(3,2,"Week 2", 4.5);
	   entityManager.persist(se6);
	   Scheduler se7 = new Scheduler(4,3,"Week 1", 7);
	   entityManager.persist(se7);
	   Scheduler se8 = new Scheduler(5,4,"Week 1", 2);
	   entityManager.persist(se8);
	   Scheduler se9 = new Scheduler(5,4,"Week 2", 3);
	   entityManager.persist(se9);
	   Scheduler se10 = new Scheduler(6,5,"Week 2", 8);
	   entityManager.persist(se10);
	   Scheduler se11 = new Scheduler(7,5,"Week 1", 8);
	   entityManager.persist(se11);
	   Scheduler se12 = new Scheduler(7,5,"Week 2", 8);
	   entityManager.persist(se12);
	   Scheduler se13 = new Scheduler(8,6,"Week 1", 5);
	   entityManager.persist(se13);
	   Scheduler se14 = new Scheduler(9,7,"Week 2", 10);
	   entityManager.persist(se14);
	   Scheduler se15 = new Scheduler(10,8,"Week 1", 7);
	   entityManager.persist(se15);

	   Shipment sh1 = new Shipment(200,1,5,10,"05/07/2020");
	   Shipment sh2 = new Shipment(200,2,2,10,"05/13/2020");
	   Shipment sh3 = new Shipment(200,3,3,10,"05/11/2020");
	   Shipment sh4 = new Shipment(200,6,5,10,"05/09/2020");
	   Shipment sh5 = new Shipment(200,8,8,10,"05/08/2020");

	   Shipment sh6 = new Shipment(201,4,23,12,"06/11/2020");
	   Shipment sh7 = new Shipment(201,6,16,6,"06/11/2020");
	   Shipment sh8 = new Shipment(201,3,19,5,"06/11/2020");
	   Shipment sh9 = new Shipment(201,1,24,10,"06/11/2020");
	   Shipment sh10 = new Shipment(201,8,12,8,"06/11/2020");

	   Shipment sh11 = new Shipment(202,5,21,13,"07/11/2020");
	   Shipment sh12 = new Shipment(202,2,29,9,"06/12/2020");
	   Shipment sh13 = new Shipment(202,7,27,10,"08/11/2020");
	   Shipment sh14 = new Shipment(202,7,24,15,"06/13/2020");
	   Shipment sh15 = new Shipment(202,1,28,7,"10/11/2020");

	   Shipment sh16 = new Shipment(203,3,20,9,"08/11/2020");
	   Shipment sh17 = new Shipment(203,2,14,10,"06/21/2020");
	   Shipment sh18 = new Shipment(203,7,24,20,"06/13/2020");
	   Shipment sh19 = new Shipment(203,1,19,6,"09/11/2020");
	   Shipment sh20 = new Shipment(203,3,20,9,"10/11/2020");

	   Shipment sh21 = new Shipment(204,6,30,11,"11/11/2020");
	   Shipment sh22 = new Shipment(204,4,31,4,"01/11/2020");
	   Shipment sh23 = new Shipment(204,8,26,6,"02/11/2020");
	   Shipment sh24 = new Shipment(204,1,23,10,"03/11/2020");
	   Shipment sh25 = new Shipment(204,7,16,9,"04/11/2020");








    }

    @Test
    @Order(0)
    public void testNone() {

    }
    //
    // @Test
    // @Order(4)
    // public void findSuppliersByCounty() {
    //     List<Supplier> sups = entityManager.createQuery(
    //         "select s from Supplier s where s.supplierCounty = 'San Luis Obispo County'",
    //         Supplier.class).getResultList();
    //     System.out.println(sups.get(0));
    // }
    //
    // @Test
    // @Order(5)
    // public void findSuppliersByLicenseNo() {
    //     List<Supplier> sups = entityManager.createQuery(
    //         "select s from Supplier s where s.licenseNo = '12345'",
    //         Supplier.class).getResultList();
    //     System.out.println(sups.get(0));
    // }
    //
    // @Test
    // @Order(6)
    // public void findSuppliersByAddress() {
    //     List<Supplier> sups = entityManager.createQuery(
    //         "select s from Supplier s where s.supplierAddress = '123 Rainbow Way'",
    //         Supplier.class).getResultList();
    //     System.out.println(sups.get(0));
    // }
    //
    // @Test
    // @Order(7)
    // public void findSuppliersByName() {
    //     List<Supplier> sups = entityManager.createQuery(
    //         "select s from Supplier s where s.supplierName = 'AmazingSuppliers'",
    //         Supplier.class).getResultList();
    //     System.out.println(sups.get(0));
    // }
    //
    // @Test
    // @Order(8)
    // public void findSuppliersByRating() {
    //     List<Supplier> sups = entityManager.createQuery(
    //         "select s from Supplier s where s.qualityRating > 4.8",
    //         Supplier.class).getResultList();
    //     System.out.println(sups.get(0));
    // }


//
}
