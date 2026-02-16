package oneToOne;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;





public class Main {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos la factoria
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oneToOne");
		System.out.println("Factoria creada");

		EntityManager em = emf.createEntityManager();
		System.out.print("Entidad creada");

		try {
			// Iniciamos  la transacción
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Socios s = new Socios("24456780Q", "Samira","Sanchez");
			em.persist(s);
			Socios sn = em.find(Socios.class, "24456780Q");
			
			Tarjeta t = new Tarjeta("Santander", LocalDate.of(2026, 2, 13), sn);
			
			em.persist(t);
			tx.commit();
			System.out.println("socio guardado con exito.");
			System.out.println("factura guardado con exito.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error,. revirtiendo cambios.");
			em.getTransaction().rollback();

		}

	}

}
