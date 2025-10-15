package mis_cosas_APARTE;

//CLASE ABSTRACTA: Define características comunes a todos los vehículos.
abstract class Vehiculo {
 protected double capacidadCarga; // Capacidad de carga en toneladas
 protected double consumoCombustible; // Consumo en litros por km

 public Vehiculo(double capacidadCarga, double consumoCombustible) {
     this.capacidadCarga = capacidadCarga;
     this.consumoCombustible = consumoCombustible;
 }

 // Métodos abstractos que cada vehículo debe implementar
 public abstract void mostrarDetalles();
 public abstract double calcularAutonomia(double litrosCombustible);
}

//INTERFAZ: Define el contrato para vehículos terrestres
interface Terrestre {
 void conducir();
}

//INTERFAZ: Define el contrato para vehículos voladores
interface Volador {
 void volar();
}

//INTERFAZ: Define el contrato para vehículos navegables
interface Navegable {
 void navegar();
}

//CLASE CONCRETA: Camión, extiende Vehiculo e implementa Terrestre
class Camion extends Vehiculo implements Terrestre {
 public Camion(double capacidadCarga, double consumoCombustible) {
     super(capacidadCarga, consumoCombustible);
 }

 @Override
 public void conducir() {
     System.out.println("🚛 Conduciendo un camión con capacidad de " + capacidadCarga + " toneladas.");
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Camión: Carga = " + capacidadCarga + " toneladas, Consumo = " + consumoCombustible + " L/km.");
 }

 @Override
 public double calcularAutonomia(double litrosCombustible) {
     return litrosCombustible / consumoCombustible;
 }
}

//CLASE CONCRETA: Avión, extiende Vehiculo e implementa Volador
class Avion extends Vehiculo implements Volador {
 public Avion(double capacidadCarga, double consumoCombustible) {
     super(capacidadCarga, consumoCombustible);
 }

 @Override
 public void volar() {
     System.out.println("✈️ Volando un avión con capacidad de " + capacidadCarga + " toneladas.");
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Avión: Carga = " + capacidadCarga + " toneladas, Consumo = " + consumoCombustible + " L/km.");
 }

 @Override
 public double calcularAutonomia(double litrosCombustible) {
     return litrosCombustible / consumoCombustible;
 }
}

//CLASE CONCRETA: Barco, extiende Vehiculo e implementa Navegable
class Barco extends Vehiculo implements Navegable {
 public Barco(double capacidadCarga, double consumoCombustible) {
     super(capacidadCarga, consumoCombustible);
 }

 @Override
 public void navegar() {
     System.out.println("🚢 Navegando un barco con capacidad de " + capacidadCarga + " toneladas.");
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Barco: Carga = " + capacidadCarga + " toneladas, Consumo = " + consumoCombustible + " L/km.");
 }

 @Override
 public double calcularAutonomia(double litrosCombustible) {
     return litrosCombustible / consumoCombustible;
 }
}

//CLASE CONCRETA: Hidroavión, que hereda de Avión y también implementa Navegable
class Hidroavion extends Avion implements Navegable {
 public Hidroavion(double capacidadCarga, double consumoCombustible) {
     super(capacidadCarga, consumoCombustible);
 }

 @Override
 public void navegar() {
     System.out.println("🛩️🌊 Hidroavión aterrizando y navegando en el agua.");
 }
}

//PROGRAMA PRINCIPAL (MAIN)
public class TransporteDemo {
 public static void main(String[] args) {
     // Crear diferentes tipos de vehículos
     Camion camion = new Camion(10, 0.2);
     Avion avion = new Avion(50, 3.0);
     Barco barco = new Barco(100, 0.5);
     Hidroavion hidroavion = new Hidroavion(20, 2.5);

     // Llamar a métodos de cada tipo de vehículo
     System.out.println("\nDetalles de los vehículos:");
     camion.mostrarDetalles();
     avion.mostrarDetalles();
     barco.mostrarDetalles();
     hidroavion.mostrarDetalles();

     System.out.println("\nAcciones de los vehículos:");
     camion.conducir();
     avion.volar();
     barco.navegar();
     hidroavion.volar();
     hidroavion.navegar();

     // Calcular autonomía de cada vehículo con 100 litros de combustible
     System.out.println("\nAutonomía con 100 litros de combustible:");
     System.out.println("🚛 Camión: " + camion.calcularAutonomia(100) + " km.");
     System.out.println("✈️ Avión: " + avion.calcularAutonomia(100) + " km.");
     System.out.println("🚢 Barco: " + barco.calcularAutonomia(100) + " km.");
     System.out.println("🛩️ Hidroavión: " + hidroavion.calcularAutonomia(100) + " km.");
 }
}
