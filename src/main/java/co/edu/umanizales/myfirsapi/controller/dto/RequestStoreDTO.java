package co.edu.umanizales.myfirsapi.controller.dto;

import co.edu.umanizales.myfirsapi.model.Location;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class RequestStoreDTO {
    private String locationId;
    private String name;
    private String address;
    private String description;
    private String code;
}
