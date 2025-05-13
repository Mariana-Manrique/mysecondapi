package co.edu.umanizales.myfirsapi.controller.dto;

import co.edu.umanizales.myfirsapi.model.Product;
import co.edu.umanizales.myfirsapi.model.Seller;
import co.edu.umanizales.myfirsapi.model.Store;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data


public class RequestSaleDTO
{
    private String storeId;
    private String sellerId;
    private LocalDate dateSale;
    private int quantity;
    private List<RequestProductDTO> products;
    private String code;
}
