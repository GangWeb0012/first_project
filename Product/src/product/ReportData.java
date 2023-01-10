/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author 21002729-atlegang dikgale
 */
public class ReportData {
     private int ProductCode,ProductWarranty,ProductStockLevel;
     private double ProductPrice;
     private String ProductName,ProductSupplier,ProductCat;

    public int getProductCode() {
        return ProductCode;
    }

    public void setProductCode(int ProductCode) {
        this.ProductCode = ProductCode;
    }

    public String getProductCat() {
        return ProductCat;
    }

    public void setProductCat(String ProductCat) {
        this.ProductCat = ProductCat;
    }

    public int getProductWarranty() {
        return ProductWarranty;
    }

    public void setProductWarranty(int ProductWarranty) {
        this.ProductWarranty = ProductWarranty;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductStockLevel() {
        return ProductStockLevel;
    }

    public void setProductStockLevel(int ProductStockLevel) {
        this.ProductStockLevel = ProductStockLevel;
    }
    

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
   

    public String getProductSupplier() {
        return ProductSupplier;
    }

    public void setProductSupplier(String ProductSupplier) {
        this.ProductSupplier = ProductSupplier;
    }
    
    

}
