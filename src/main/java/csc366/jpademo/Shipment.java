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
     private int supplier;
     private int store;
     private int item;
     private int quantity;
     private String date;

	public Shipment(int supplier, int store, int item, int quantity, String date) {
		this.supplier = supplier;
		this.store = store;
		this.item = item;
		this.quantity = quantity;
		this.date = date;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getSupplier() {
		return supplier;
	}

	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
