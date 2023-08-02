package com.api.dto.product;

import java.time.LocalDate;
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String productDesc;
    private LocalDate expiryDate;

    public Integer getProductId() {
        return productId;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public String getProductName() {
        return productName;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Override
    public String toString() {
        return "ProductDTO [productId=" + productId + ", productDesc=" + productDesc + ", productName=" + productName + ", expiryDate="
                + expiryDate + "]";
    }
}
