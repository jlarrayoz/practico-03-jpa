package uy.org.curso.jpa;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Persona {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 60)
    private String nombreCompleto;

    @NotNull
    private String nroDocumento;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(Long id, String nombreCompleto, String nroDocumento, Date fechaNacimiento) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
