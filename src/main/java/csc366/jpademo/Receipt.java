package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Receipt",
uniqueConstraints = @UniqueConstraint(columnNames={
     "receiptId"
}))
public class Receipt {

     @Id
     @NotNull
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int receiptId;

     @NotNull
     private Date date;

     @ManyToOne
     private Customer customer;

     @ManyToMany(mappedBy = "receipts")
     private List<Item> items = new ArrayList<>();

     @ManyToOne
     private Store store;
}
