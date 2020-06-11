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
//@AutoConfigureTestDatabase(replace=Replace.NONE)   // without this, @DataJpaTest always uses in-memory H2 database
//@TestMethodOrder(OrderAnnotation.class)
public class Demo2 {

    private final static Logger log = LoggerFactory.getLogger(Demo2.class);

    @Autowired
    private EntityManager entityManager;  // https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html
    
    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    private void setup() {
        // Hobby h1 = new Hobby("Skiing");
        // entityManager.persist(h1);
        // Hobby h2 = new Hobby("Football");
        // entityManager.persist(h2);
        // Hobby h3 = new Hobby("Hiking");
        // entityManager.persist(h3);
        // Hobby h4 = new Hobby("Knitting");
        // entityManager.persist(h4);
        
        // IntStream.range(0, 5).forEachOrdered(n -> {
        //         String nm = String.format("Person%d", n);
        //         Person p = new Person(nm, "Test", nm+"@test.com");
        //         if (n >= 1) { p.addHobby(h1); }
        //         if (n >= 2) { p.addHobby(h2); }
        //         if (n >= 3) { p.addHobby(h3); }
        //         if (n >= 4) { p.addHobby(h4); }
        //         entityManager.persist(p);
        //     });
        Person p1 = new Person("Chuck", "Norris", "random@domain");
        entityManager.persist(p1);
        Person p2 = new Person("Lebron", "James", "lbj@nba");
        entityManager.persist(p2);
        Employee e1 = new Employee(1, "1990-06-06", "e1@store", "Joe", "415-000-0000", "Bay Area", true);
        entityManager.persist(e1);
        Employee e2 = new Employee(2, "1990-07-07", "e2@store", "Bob", "310-100-0000", "Los Angeles", true);
        entityManager.persist(e2);
        Employee e3 = new Employee(3, "1990-08-08", "e3@store", "Kevin", "415-200-0000", "Bay Area", false);
        entityManager.persist(e3);
        Employee e4 = new Employee(4, "1990-09-09", "e4@store", "Chance", "415-300-0000", "Chicago", true);
        entityManager.persist(e4);

	    // entityManager.flush();  // "Synchronize the persistence context to the underlying database"
        // entityManager.clear();  // "Clear the persistence context, causing all managed entities to become detached."
    }
    
    @Test
    @Order(1)
    public void testFindPerson() {
        Person p = personRepository.findByFirstName("Chuck");
        log.info(p.toString());
    }
    
    @Test
    @Order(2)
    public void testFindAllPeople() {
        List<Person> all = personRepository.findAll();
        log.info(all.toString());
    }

    // Find all employees working in a specific region (JPQL 1)
    @Test
    @Order(3)
    public void findAllEmpsInRegion() {
        List<Employee> emps = entityManager.createQuery("select e from Employee e where e.region = 'Chicago'",
                                                        Employee.class).getResultList();
        log.info(emps.toString());
    }

    // Find all employees that are able to work (JPQL 2)
    // NOTE: no clue how this doesn't work...
    // @Test
    // @Order(4)
    // public void findAllActiveEmps() {
    //     List<Employee> emps = entityManager.createQuery("select e from Employee e where e.work_status = '1'",
    //                                                     Employee.class).getResultList();
    //     log.info(emps.toString());
    // }

    // @Test
    // @Order(3)
    // // https://en.wikibooks.org/wiki/Java_Persistence/JPQL
    // public void testJpqlQuery1() {
    //     List<Person> all = entityManager.createQuery("select p from Person p " +
    //                                                  "join p.hobbies join p.addresses",
    //                                                  Person.class).getResultList();
    //     log.info(all.toString());
    // }

    // @Test
    // @Order(4)
    // public void testJpqlQuery2() {
    //     List<Person> all = entityManager.createQuery("select p from Person p " +
    //                                                  " left join fetch p.hobbies " +
    //                                                  " left join fetch p.addresses",
    //                                                  Person.class).getResultList();
    //     log.info(all.toString());
    // }

    // @Test
    // @Order(5)
    // public void testJpqlQuery3() {
    //     List<Person> all = entityManager.createQuery("select distinct p from Person p " +
    //                                                  " left join fetch p.hobbies " +
    //                                                  " left join fetch p.addresses",
    //                                                  Person.class).getResultList();
    //     log.info(all.toString());
    // }

    // @Test
    // @Order(6)
    // // https://en.wikibooks.org/wiki/Java_Persistence/Criteria
    // // https://developer.ibm.com/articles/j-typesafejpa/
    // public void testCriteriaQuery1() {

    //     CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    //     CriteriaQuery<Person> cq = cb.createQuery(Person.class);
    //     Root<Person> pq = cq.from(Person.class);
    //     cq.where(cb.or(
    //                    cb.like(pq.get("email"), "Person2%"),
    //                    cb.equal(pq.get("firstName"), "Person3")
    //                    )
    //              );        
    //     List<Person> all = entityManager.createQuery(cq).getResultList();

    //     log.info(all.toString());
    // }

    // @Test
    // @Order(7)
    // public void testCriteriaQuery2() {

    //     CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    //     CriteriaQuery<Person> cq = cb.createQuery(Person.class);
    //     Root<Person> pq = cq.from(Person.class);
    //     pq.fetch("addresses", JoinType.LEFT);
    //     pq.fetch("hobbies", JoinType.LEFT);
    //     //cq.distinct(true);
    //     List<Person> all = entityManager.createQuery(cq).getResultList();

    //     log.info(all.toString());
    // }
    
}