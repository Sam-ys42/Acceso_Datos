package ejercicio46;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;




public class Recetas {
	private List<Receta>recetas;

	public Recetas() {
		
		this.recetas = new ArrayList<Receta>();
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	public void mostrarRecetas() {
		int i = 1;
		for (Receta receta : recetas) {
			System.out.println("---receta " + i+"--- \n"+receta.toString()+"\n");
			i++;
		}
	}

	
	

	
	
}
