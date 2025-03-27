package co.edu.umanizales.myfirsapi.controller;

import co.edu.umanizales.myfirsapi.model.Location;
import co.edu.umanizales.myfirsapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/Seller")
public class SellerController {

    @GetMapping
    public Seller getSaller(){
        Location Manizales = new Location("17001","Manizales");
        Location Pereira = new Location("66001","Pereira");

        Seller Mariana = new Seller("Mariana","Manrique",(byte) 19,"F","1054858697",Manizales);
        Seller Marcos = new Seller("Marcos","Correa",(byte) 21,"M","1002526531",Pereira);
        Seller Luis = new Seller("Luis","Rodriguez",(byte)23,"M","1052726383",Pereira);
        Seller Isabella = new Seller("Isabella","Lopez",(byte) 19,"F","1102892829",Manizales);
        Seller Santiago = new Seller("Santiago","Cardenas",(byte) 20,"M","1928292829",Manizales);

        return Marcos;
    }

}
