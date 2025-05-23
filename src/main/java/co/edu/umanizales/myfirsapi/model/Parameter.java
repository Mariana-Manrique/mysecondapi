package co.edu.umanizales.myfirsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public abstract class Parameter {
    private String code;
    private String description;
}
