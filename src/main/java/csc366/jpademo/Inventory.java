package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="Inventory")

public class Inventory {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int entryId;


     private int store;

     private int itemId;

     private int quantity;

     public Inventory (int strore, int itemId, int quantity) {
          this.store = store;
          this.itemId = itemId;
          this.quantity = quantity;
     }

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
