package edu.unir.dar.actividad_02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacionUnir {
    private static final List<String> ALUMNOS = new ArrayList<>();
    private static final Map<String, Integer> CALIFICACIONES = new HashMap<>();
    
    static {
        ALUMNOS.add("Ana");
        ALUMNOS.add("Beatriz");
        ALUMNOS.add("Cynthia");
        ALUMNOS.add("Daniela");
        ALUMNOS.add("Eliza");
        
        CALIFICACIONES.put(ALUMNOS.get(0), 9);
        CALIFICACIONES.put(ALUMNOS.get(1), 7);
        CALIFICACIONES.put(ALUMNOS.get(2), 8);
        CALIFICACIONES.put(ALUMNOS.get(3), 6);
        CALIFICACIONES.put(ALUMNOS.get(4), 10);
    }
    
    @GetMapping("/hola-mundo")
    public String hola() {
        return "Hola desde la Aplicacion UNIR! :)";
    }
    
    @GetMapping("/alumnos")
    public List<String> obtenerListaAlumnos() {
        return ALUMNOS;
    }

    @GetMapping("/calificaciones/{nombre}")
    public Map<String, Object> obtenerCalificaciones(@PathVariable String nombre) {
        Integer calificacion = CALIFICACIONES.get(nombre);

        return calificacion != null
                ? Map.of("nombre", nombre, "calificacion", calificacion)
                : Map.of("error", String.format("Alumno no registrado %s", nombre));
    }
}
