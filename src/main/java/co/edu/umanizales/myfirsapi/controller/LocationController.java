package co.edu.umanizales.myfirsapi.controller;

import co.edu.umanizales.myfirsapi.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/location")
public class LocationController {

    @GetMapping
    public String getlocation(){
       // Location location = new Location("jdjud" "kedjjd" "jhjj" );

        return "Manizales";
    }

}
