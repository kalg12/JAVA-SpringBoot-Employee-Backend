package com.example.employee.entity;

import jakarta.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //En esta parte definimos nuestros argumentos
    private Long id;
    private String nombre;
    private String puesto;
    private Double salario;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
}
