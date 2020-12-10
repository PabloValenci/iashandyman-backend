package com.iashandyman.calculator.controller;

import com.iashandyman.calculator.exception.ResourceNotFoundException;
import com.iashandyman.calculator.model.Empleado;
import com.iashandyman.calculator.repository.EmpleadoRepository;
import com.iashandyman.calculator.controller.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //Obtener todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }

    //Crear empleado ApiRest
    @PostMapping("/empleados")
    public Empleado createEmpleado(@RequestBody Empleado empleado) throws ParseException {
        String formateStartDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(empleado.getFechaInicio());
        String formateEndDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(empleado.getFechaFin());
        long diffHours = Calculator.horasCalculadas(empleado.getFechaInicio(), empleado.getFechaFin());
        empleado.setHoras(diffHours);
        return empleadoRepository.save(empleado);
    }

    //Obtener empleado por id
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable String id){
        Empleado empleado = empleadoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Empleado con ID "+id+" no existe"));
        return ResponseEntity.ok(empleado);
    }
}
