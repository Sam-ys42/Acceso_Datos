package bdprestamos_nazan;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "socio")
public class Socio {

    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numTelefono")
    private String numTelefono;

    @OneToMany(mappedBy = "socio")
    private List<Prestamos> prestamos;

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumTelefono() { return numTelefono; }
    public void setNumTelefono(String numTelefono) { this.numTelefono = numTelefono; }
}