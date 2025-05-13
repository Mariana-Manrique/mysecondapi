package co.edu.umanizales.myfirsapi.service;

import co.edu.umanizales.myfirsapi.model.Sale;
import co.edu.umanizales.myfirsapi.model.Seller;
import co.edu.umanizales.myfirsapi.model.Store;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SellerService {

    private List<Seller> sellers = new ArrayList<>();

    public String addSeller(Seller seller) {
        sellers.add(seller);
        return "Tienda agregada";
    }

    public Seller getSellerByCode(String code) {
        for (Seller seller : sellers) {
            if (seller.getCode().equals(code)) {
                return seller;
            }
        }
        return null;
    }
}
