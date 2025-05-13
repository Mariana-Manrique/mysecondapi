package co.edu.umanizales.myfirsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Product {
    private double price;
    private int stock;
    private TypeProduct typeProduct;
    private String code;

}
