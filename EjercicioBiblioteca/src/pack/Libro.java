package pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "libro") 
public class Libro {
	@Id
	private String isbn;
	private int numEjemplar;
	private String titulo;
	private String autor;
	public Libro(String isbn, int numEjemplar, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.numEjemplar = numEjemplar;
		this.titulo = titulo;
		this.autor = autor;
	}
	public Libro() {
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumEjemplar() {
		return numEjemplar;
	}
	public void setNumEjemplar(int numEjemplar) {
		this.numEjemplar = numEjemplar;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", numEjemplar=" + numEjemplar + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	

}
