package co.edu.umanizales.myfirsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seller{

    private String name;
    private String lastName;
    private byte age;
    private String gender;
    private String identification;
    private Location City;

}
