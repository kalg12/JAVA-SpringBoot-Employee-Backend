package com.example.employee.service;

import com.example.employee.entity.Empleado;
import com.example.employee.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> listarTodos() {
        return repository.findAll();
    }

    public Optional<Empleado> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Empleado guardar(Empleado emp) {
        return repository.save(emp);
    }

    public Empleado actualizar(Long id, Empleado emp) {
        if (repository.existsById(id)) {
            emp.setId(id);
            return repository.save(emp);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}