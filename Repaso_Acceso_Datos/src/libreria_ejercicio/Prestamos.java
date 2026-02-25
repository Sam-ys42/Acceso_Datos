package bdprestamos_nazan;

import jakarta.persistence.*;

@Entity
@Table(name = "prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestamo")
    private int idPrestamo;

    @Column(name = "prestado")
    private boolean prestado;

    @ManyToOne
    @JoinColumn(name = "socioDni", referencedColumnName = "dni")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "libroIsbn", referencedColumnName = "isbn")
    private Libro libro;

    // Getters y Setters
    public int getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(int idPrestamo) { this.idPrestamo = idPrestamo; }

    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
}