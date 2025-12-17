package com.hem.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

// @Getter
// @Setter
public class Order {
  @JsonProperty("c-name")
  private String customerName;
  @JsonProperty("p-name")
  private String  productName;
  @JsonProperty("quantity")
  private int quantity;

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString(){
    return "Order{" +
            "customerName='" + customerName + '\'' +
            ", productName='" + productName + '\'' +
            ", quantity=" + quantity +
            '}';
  }
}
