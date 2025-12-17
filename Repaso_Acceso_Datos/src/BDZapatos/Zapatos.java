package BDZapatos;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Zapatos implements Serializable {
 private ArrayList<Zapato> zapatos = new ArrayList<Zapato>();

public Zapatos() {
}

public ArrayList<Zapato> getZapatos() {
	return zapatos;
}

public void setZapatos(ArrayList<Zapato> zapatos) {
	this.zapatos = zapatos;
}

public void mostrarZapatos() {
	
	if(zapatos == null || zapatos.isEmpty()) {
		System.out.println("no hay zapatos");
	}else{
		for (Zapato z : zapatos) {
			System.out.println(z);
		}
	}
}

public void anadirZapato(Zapato z) {
	this.zapatos.add(z);
}
 
 
 
}
