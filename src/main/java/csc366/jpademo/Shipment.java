package csc366.jpademo;

import java.util.*;
import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Shipment",
uniqueConstraints = @UniqueConstraint(columnNames={
     "shipmentId"
}))

public class Shipment {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int shipmentId;

     @ManyToOne
     private Supplier supplier;

     @ManyToOne
     private Store store;

     @ManyToOne
     private Item item;

     private int quantity;

     private Date date;

	public Shipment(Supplier supplier, Store store, Item item, int quantity, Date date) {
		this.supplier = supplier;
		this.store = store;
		this.item = item;
		this.quantity = quantity;
		this.date = date;
	}
}
