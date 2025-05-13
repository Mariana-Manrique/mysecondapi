package co.edu.umanizales.myfirsapi.service;


import co.edu.umanizales.myfirsapi.model.Parameter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterService {
    private List<Parameter> typeDocs = new ArrayList<>();
    private List<Parameter> products = new ArrayList<>();
    private List<Parameter> typeProducts = new ArrayList<>();

    // add parameter, agregar parametro
    public void addParameter(Parameter parameter, String type) {
        type = type.toLowerCase();
        if (type.equals("typedoc")) {
            typeDocs.add(parameter);
        } else if (type.equals("product")) {
            products.add(parameter);
        } else if (type.equals("typeproduct")) {
            typeProducts.add(parameter);
        }
    }

    // Retorna todos los parámetros de todos los tipos
    public List<Parameter> getAllParameters(){
        List<Parameter> all = new ArrayList<>();
        all.addAll(typeDocs);
        all.addAll(products);
        all.addAll(typeProducts);
        return all;
    }


    // Filtra parámetros por tipo
    public List<Parameter> getParametersByType(String type) {
        type = type.toLowerCase();

        if (type.equals("typedoc")) {
            return new ArrayList<>(typeDocs);
        } else if (type.equals("product")) {
            return new ArrayList<>(products);
        } else if (type.equals("typeproduct")) {
            return new ArrayList<>(typeProducts);
        } else {
            return new ArrayList<>();
        }
    }


    // Busca un parámetro por su código en todas las listas,actualParameter es para buscar un parametro
    public Parameter getParameterByCode(String code) {
        List<Parameter> all = getAllParameters();
        for (Parameter actualParameter : all) {
            if (actualParameter.getCode().equals(code)) {
                return actualParameter; // retorna el primero que encuentra
            }
        }
        return null; // si no encuentra coincidencias
    }
}


