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
    
    
    @BeforeEach
    private void setup() {
        Employee e1 = new Employee(200, "Joe", "e1@store", "1990-06-06",  "415-000-0000", "Bay Area", true);
        entityManager.persist(e1);
        Employee e2 = new Employee(201, "Bob", "e2@store", "1990-07-07",  "310-100-0000", "Los Angeles", false);
        entityManager.persist(e2);
        Employee e3 = new Employee(202, "Kevin", "e3@store", "1990-08-08",  "415-200-0000", "Bay Area", false);
        entityManager.persist(e3);
        Employee e4 = new Employee(203, "Chance", "e4@store", "200-01-01",  "415-300-0000", "Chicago", true);
        entityManager.persist(e4);

	    // entityManager.flush();  // "Synchronize the persistence context to the underlying database"
        // entityManager.clear();  // "Clear the persistence context, causing all managed entities to become detached."
    }
    
    // @Test
    // @Order(1)
    // public void testFindPerson() {
    //     Person p = personRepository.findByFirstName("Chuck");
    //     log.info(p.toString());
    // }
    
    // @Test
    // @Order(2)
    // public void testFindAllPeople() {
    //     List<Person> all = personRepository.findAll();
    //     log.info(all.toString());
    // }

    // Find all employees working in a specific region (JPQL 1)
    @Test
    @Order(3)
    public void findAllEmpsInRegion() {
        List<Employee> emps = entityManager.createQuery("select e from Employee e where e.region = 'Chicago'",
                                                        Employee.class).getResultList();
        log.info(emps.toString());
        System.out.println(emps.get(0));
        
    }

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