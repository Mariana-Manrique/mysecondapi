package co.edu.umanizales.myfirsapi.service;

import co.edu.umanizales.myfirsapi.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {

    private List<Location> locations;

    @Value( "${locations_filename}" )
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();
        locations.add(new Location("05","ANTIOQUIA"));
        locations.add(new Location("17","CALDAS"));
        locations.add(new Location("66","RISARALDA"));

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2],line[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if(location.getCode().length() ==2){
                states.add(location);
            }
        }
        return states;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if (location.getName().equals(name)) {
                return location;
            }
        }
        return null;
    }

    // definicion del metodo, inicializando la lista con el tipo de dato que corresponde
    // charAt para devolver una letra en una posicion especifica
    public List<Location> getLocationByInitialLetter (String initialLetter) {
        List<Location> initialLetterArray = new ArrayList<>();
        for (Location location : locations) {
            if(location.getName().charAt(0)== initialLetter.charAt(0)){
                initialLetterArray.add(location);
            }
        }
        return initialLetterArray;
    }
//Mi aparametro recibe 2 una letra inicial y en la que termine, letterA que es la primera letra y letterB para la ultima letra
//El chatAt funciona para una posicion especifica y length nos sirve para la ultima letra sin saber la ultima posicion por ende se pone el -1
    public List<Location> getLocationByInitialAndLetter (char letterA , char letterB) {
        List<Location> initialandendletterArray = new ArrayList<>();
        for (Location location : locations) {
            if(location.getName().charAt(0)== letterA && location.getName().charAt(location.getName().length()-1)== letterB){
                initialandendletterArray.add(location);
            }
        }
        return initialandendletterArray;
    }
}
