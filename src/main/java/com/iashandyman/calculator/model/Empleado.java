package com.iashandyman.calculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class Empleado {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nombre_empleado")
    private String nombre;
    @Column(name = "id_servicio")
    private String idServicio;
    @Column(name = "apellidos_empleado")
    private String apellidos;
    @Column(name = "fecha_inicio")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaFin;
    @Column(name = "horas", nullable = true)
    private Long horas;

    public Empleado() {}

    public Empleado(String nombre, String apellidos, Date fechaInicio, Date fechaFin, Long horas, String idServicio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horas = horas;
        this.idServicio = idServicio;
    }

}
