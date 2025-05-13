package co.edu.umanizales.myfirsapi.controller;

import co.edu.umanizales.myfirsapi.model.Parameter;
import co.edu.umanizales.myfirsapi.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/parameters")
public class ParameterController {

    private final ParameterService parameterService;

    @Autowired
    public ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    // Obtener todos los parámetros
    @GetMapping
    public List<Parameter> getAllParameters() {
        return parameterService.getAllParameters();
    }

    // Obtener parámetros por tipo
    @GetMapping("/type/{type}")
    public List<Parameter> getParametersByType(@PathVariable String type) {
        return parameterService.getParametersByType(type);
    }

    // Obtener un parámetro por su código
    @GetMapping("/code/{code}")
    public Parameter getParameterByCode(@PathVariable String code) {
        return parameterService.getParameterByCode(code);
    }

    // Agregar un parámetro nuevo
    @PostMapping("/add/{type}")
    public void addParameter(@RequestBody Parameter parameter, @PathVariable String type) {
        parameterService.addParameter(parameter, type);
    }
}