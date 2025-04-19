package co.edu.umanizales.myfirsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Sale {
    private String seller;
    private String name_store;
    private String date;
    private String time;
    private String city;
    private String name;
    private String lastname;
}
