package bdprestamos_nazan;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "numEjemplar")
    private int numEjemplar;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @OneToMany(mappedBy = "libro")
    private List<Prestamos> prestamos;

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getNumEjemplar() { return numEjemplar; }
    public void setNumEjemplar(int numEjemplar) { this.numEjemplar = numEjemplar; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
}