package com.hem.example;

public record OrderRecord(
  String customerName,
  String  productName,
  int quantity
) {
  
}
