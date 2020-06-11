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

     @NotNull
     @OneToMany(mappedBy = "supplier")
     private List<Shipment> shipments = new ArrayList<>();

     public int getSupplierId () {
          return this.supplierId;
     }

     public void setSupplierId (int supplierId) {
          this.supplierId = supplierId;
     }

     public String getSupplierAddress () {
          return this.supplierAddress;
     }

     public void setSupplierAddress (String supplierAddress) {
          this.supplierAddress = supplierAddress;
     }

     public String getSupplierCounty () {
          return this.supplierCounty;
     }

     public void setSupplierCounty (String supplierCounty) {
          this.supplierCounty = supplierCounty;
     }

     public String getLicenseNo () {
          return this.licenseNo;
     }

     public void setLicenseNo (String licenseNo) {
          this.licenseNo = licenseNo;
     }

     public double getQualityRating () {
          return this.qualityRating;
     }

     public void setQualityRating (double qualityRating) {
          this.qualityRating = qualityRating;
     }

     public List<Shipment> getShipments () {
          return this.shipments;
     }

     public void setShipments (List<Shipment> shipments) {
          this.shipments = shipments;
     }
}
