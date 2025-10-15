package TAREA_UNIT9; // lo vamos a realizar todo en una sola clase :)

import java.util.Scanner;

public class Inventario {
	private static final int NUM_ARTICULOS = 10;
    private static final int NUM_TALLAS = 5;
    private static final int STOCK_INICIAL = 4;
    
    private int[][] inventario;
    private int[][] pedidosPendientes;
    private int[][] pedidosRealizados;
    private int[][] devoluciones;
    
    public Inventario(){
    	inventario = new int[NUM_ARTICULOS][NUM_TALLAS];
        pedidosPendientes = new int[NUM_ARTICULOS][NUM_TALLAS];
        pedidosRealizados = new int[NUM_ARTICULOS][NUM_TALLAS];
        devoluciones = new int[NUM_ARTICULOS][NUM_TALLAS];
        
        inicializarInventario();
    }
    
    private void inicializarInventario() {
        for (int i = 0; i < NUM_ARTICULOS; i++) {
            for (int j = 0; j < NUM_TALLAS; j++) {
                inventario[i][j] = STOCK_INICIAL; // rellenamos el inventario
            }
        } 
    }
    
    public void realizarPedido(int articulo, int talla, int cantidad) {
        if (articulo < 0 || articulo >= NUM_ARTICULOS || talla < 0 || talla >= NUM_TALLAS ) {
            System.out.println("Artículo o talla inválidos.");
            return;
        }

        if (inventario[articulo][talla] >= cantidad) {
            inventario[articulo][talla] -= cantidad;
            pedidosRealizados[articulo][talla] += cantidad;
            System.out.println("Pedido realizado correctamente.");
        } else {
            int resto = cantidad - inventario[articulo][talla];
            pedidosPendientes[articulo][talla] += resto;
            pedidosRealizados[articulo][talla] += inventario[articulo][talla];
            inventario[articulo][talla] = 0;
            System.out.println("Pedido parcial realizado, faltan " + resto + " pendas");
        }
    }

    public void hacerDevolucion(int articulo, int talla, int cantidad) {
        if (articulo < 0 || articulo >= NUM_ARTICULOS || talla < 0 || talla >= NUM_TALLAS) {
            System.out.println("Artículo o talla inválidos");
        }
        else {
        inventario[articulo][talla] += cantidad;
        devoluciones[articulo][talla] += cantidad;
        System.out.println("Devolución realizada");}
    }
    
    public void consultarEstadoStock() {
        System.out.println("\nEstado del Stock:");
        imprimirMatriz(inventario);
    }

    public void consultarEstadoPedidosPendientes() {
        System.out.println("\nPedidos Pendientes:");
        imprimirMatriz(pedidosPendientes);
    }

    public void consultarPedidosRealizados() {
        System.out.println("\nPedidos Realizados:");
        imprimirMatriz(pedidosRealizados);
    }
    
    public void consultarDevoluciones() {
        System.out.println("\nDevoluciones:");
        imprimirMatriz(devoluciones);
    }
    
    private void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < NUM_ARTICULOS; i++) {
            System.out.print("Artículo " + (i + 1) + ": ");
            for (int j = 0; j < NUM_TALLAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
    	Inventario inventario = new Inventario();
    	Scanner scanner = new Scanner(System.in);
    	int opcion;
    	do {
            System.out.println("\nMenú:");
            System.out.println("1. Realizar Pedido");
            System.out.println("2. Hacer Devolución");
            System.out.println("3. Consultar Estado del Stock");
            System.out.println("4. Consultar Pedidos Pendientes");
            System.out.println("5. Consultar Pedidos Realizados");
            System.out.println("6. Consultar Devoluciones");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = scanner.nextInt();

            int articulo, talla, cantidad;
            switch (opcion) {
                case 1:
                    System.out.print("ID del artículo (0-9): ");
                    articulo = scanner.nextInt();
                    System.out.print("Talla (0-xs, 1-s, 2-m, 3-l, 4-xl): ");
                    talla = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    cantidad = scanner.nextInt();
                    inventario.realizarPedido(articulo, talla, cantidad);
                    break;
                case 2:
                    System.out.print("ID del artículo (0-9): ");
                    articulo = scanner.nextInt();
                    System.out.print("Talla (0-xs, 1-s, 2-m, 3-l, 4-xl): ");
                    talla = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    cantidad = scanner.nextInt();
                    inventario.hacerDevolucion(articulo, talla, cantidad);
                    break;
                case 3:
                    inventario.consultarEstadoStock();
                    break;
                case 4:
                    inventario.consultarEstadoPedidosPendientes();
                    break;
                case 5:
                    inventario.consultarPedidosRealizados();
                    break;
                case 6:
                    inventario.consultarDevoluciones();
                    break;
                case 7:
                    System.out.println("Adiós :)/");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
