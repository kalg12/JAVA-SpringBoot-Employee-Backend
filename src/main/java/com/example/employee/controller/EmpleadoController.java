package com.example.employee.controller;

import com.example.employee.entity.Empleado;
import com.example.employee.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // Permitir Angular local
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    // Obtener todos los empleados
    @GetMapping
    public List<Empleado> listar() {
        return service.listarTodos();
    }

    // Buscar un empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscar(@PathVariable Long id) {
        Optional<Empleado> empleado = service.buscarPorId(id);
        return empleado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado) {
        Empleado guardado = service.guardar(empleado);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado actualizado = service.actualizar(id, empleado);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un empleado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        System.out.println("El id que está llegando es: " + id);
        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
