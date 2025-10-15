package UNIT8.ejercicioCamisetas;

public class Personalizadas extends Camiseta{
private String slogan;

public void setSlogan(String slogan) {
	this.slogan = slogan;
}
public String getSlogan() {
	return slogan;
}

@Override
public String toString() {
	return "Personalizada [numPedido=" + numeroPedido + ", tamano=" + tamaño + ", color=" + color + ", precio=" + precio+ ", eslogan="+ slogan
			+ "]";
}

}
