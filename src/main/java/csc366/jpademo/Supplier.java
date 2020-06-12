package csc366.jpademo;

import java.util.*;
import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Supplier",
uniqueConstraints = @UniqueConstraint(columnNames={
     "supplierId", "supplierName", "supplierAddress",
     "licenseNo"
}))
public class Supplier {

     @NotNull
     @Id
     private int supplierId;

     @NotNull
     private String supplierName;

     @NotNull
     private String supplierAddress;

     private String supplierCounty;

     @NotNull
     private String licenseNo;
     private double qualityRating;

     @OneToMany
     private List<Shipment> shipments = new ArrayList<Shipment>();


     public Supplier (int supplierId, String supplierName, String supplierAddress, String supplierCounty,
     String licenseNo, double qualityRating) {
          this.supplierId = supplierId;
          this.supplierName = supplierName;
          this.supplierAddress = supplierAddress;
          this.supplierCounty = supplierCounty;
          this.licenseNo = licenseNo;
          this.qualityRating = qualityRating;
     }
}
