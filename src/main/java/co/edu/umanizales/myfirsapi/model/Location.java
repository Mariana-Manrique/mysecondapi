package co.edu.umanizales.myfirsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location extends Parameter {


    public Location(String code, String description) {
        super(code, description);
    }
}
