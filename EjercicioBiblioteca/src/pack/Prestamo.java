package pack;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prestamos")
@NamedQuery( name = "Prestamo.total", query = "SELECT COUNT(p) FROM Prestamo p" )
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrestamo;

    private boolean prestado;

    @ManyToOne
    @JoinColumn(name = "socioDni", referencedColumnName = "dni")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "libroIsbn", referencedColumnName = "isbn")
    private Libro libro;

    public Prestamo() {}

    public Prestamo(boolean prestado, Socio socio, Libro libro) {
        this.prestado = prestado;
        this.socio = socio;
        this.libro = libro;
    }


	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

    @Override
    public String toString() {
        return "Prestamo [idPrestamo=" + idPrestamo +
               ", prestado=" + prestado +
               ", socio=" + socio.getDni() +
               ", libro=" + libro.getIsbn() + "]";
    }

    
    public static void mostrarSociosQueHanSacadoLibro(EntityManager em, String isbn) {
    	List<Socio> socios = em.createQuery( "SELECT DISTINCT p.socio FROM Prestamo p WHERE p.libro.isbn = :isbn", Socio.class) .setParameter("isbn", isbn) .getResultList();
    	if (socios.isEmpty()) {
    		System.out.println("Ningún socio ha sacado el libro con ISBN " + isbn);
    		} else {
    			System.out.println("Socios que han sacado el libro " + isbn + ":");
    			for (Socio socio : socios) {
					System.out.println(socio);
				}
    			}
    	} 
    // Operación 4: consulta estática – total de préstamos 
    public static void mostrarTotalPrestamos(EntityManager em) { 
    	Long total = (Long) em.createNamedQuery("Prestamo.totalPrestamos") .getSingleResult();
    	System.out.println("Total de préstamos realizados: " + total); 
    	}
}
