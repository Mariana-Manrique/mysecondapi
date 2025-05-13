package co.edu.umanizales.myfirsapi.controller;

import co.edu.umanizales.myfirsapi.controller.dto.RequestProductDTO;
import co.edu.umanizales.myfirsapi.controller.dto.RequestSaleDTO;
import co.edu.umanizales.myfirsapi.controller.dto.RequestStoreDTO;
import co.edu.umanizales.myfirsapi.model.*;
import co.edu.umanizales.myfirsapi.service.ParameterService;
import co.edu.umanizales.myfirsapi.service.SaleService;
import co.edu.umanizales.myfirsapi.service.SellerService;
import co.edu.umanizales.myfirsapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private ParameterService parameterService;

    // Obtener todas las ventas
    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    // Obtener venta por código de venta
    @GetMapping("/by-code/{code}")
    public Sale getSaleByCode(@PathVariable String code) {
        return saleService.getSaleByCode(code);
    }

    // Obtener ventas por código de tienda
    @GetMapping("/by-store/{storeCode}")
    public List<Sale> getSalesByStoreCode(@PathVariable String storeCode) {
        return saleService.getSalesByStoreCode(storeCode);
    }

    // Obtener ventas por código de vendedor
    @GetMapping("/by-seller/{sellerCode}")
    public List<Sale> getSalesBySellerCode(@PathVariable String sellerCode) {
        return saleService.getSalesBySellerCode(sellerCode);
    }

    // Obtener ventas por código de producto
    @GetMapping("/by-product/{productCode}")
    public List<Sale> getSalesByProductCode(@PathVariable String productCode) {
        return saleService.getSalesByProductCode(productCode);
    }

    // Obtener ventas por fecha exacta (formato yyyy-MM-dd)
    @GetMapping("/by-date")
    public List<Sale> getSalesByDate(@RequestParam String date) {
        return saleService.getSalesByDate(date);
    }

    // Agregar una nueva venta
    @PostMapping
    public void addSale(@RequestBody RequestSaleDTO requestSaleDTO) {
        Store store= storeService.getStoreByCode(requestSaleDTO.getStoreId());
        Seller seller= sellerService.getSellerByCode(requestSaleDTO.getSellerId());
        for (RequestProductDTO productDTO : requestSaleDTO.getProducts()) {
            Parameter parameter = parameterService.getParameterByCode(productDTO.getCode());

        }


    }


}