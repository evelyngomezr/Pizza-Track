import java.util.Scanner;

public class GestionPedidos {
    private Pila pilaPrincipal;  // Pila para pedidos activos (Undo)[cite: 1]
    private Pila pilaSecundaria; // Pila para pedidos deshechos (Redo)[cite: 1]

    public GestionPedidos() {
        this.pilaPrincipal = new Pila();
        this.pilaSecundaria = new Pila();
    }

    public void registrarPedido(String nombre, String ing1, String ing2, String ing3) {
        Pizza nuevaPizza = new Pizza(nombre, ing1, ing2, ing3);
        pilaPrincipal.push(nuevaPizza);
        pilaSecundaria = new Pila(); 
        System.out.println("✓ Pedido registrado exitosamente: " + nuevaPizza.getNombre());
    }

    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("No hay pedidos registrados para deshacer.");
            return;
        }
        Pizza pedidoDeshecho = pilaPrincipal.pop();
        pilaSecundaria.push(pedidoDeshecho);
        System.out.println("↺ Se deshizo el pedido: " + pedidoDeshecho.getNombre());
    }

    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println(" No hay pedidos deshechos para rehacer.");
            return;
        }
        Pizza pedidoRehecho = pilaSecundaria.pop();
        pilaPrincipal.push(pedidoRehecho);
        System.out.println("↻ Se rehizo el pedido: " + pedidoRehecho.getNombre());
    }

    public void mostrarPedidoActual() {
        Pizza actual = pilaPrincipal.peek();
        if (actual == null) {
            System.out.println("ℹ No hay pedidos activos en producción.");
        } else {
            System.out.println("Pedido actual en tope de lista: " + actual);
        }
    }

    public static void main(String[] args) {
        GestionPedidos sistema = new GestionPedidos();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== SISTEMA DE GESTION PIZZA-TRACK =====");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Deshacer Pedido (Undo)");
            System.out.println("3. Rehacer Pedido (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la Pizza: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrediente 1: ");
                    String ing1 = scanner.nextLine();
                    System.out.print("Ingrediente 2: ");
                    String ing2 = scanner.nextLine();
                    System.out.print("Ingrediente 3: ");
                    String ing3 = scanner.nextLine();
                    sistema.registrarPedido(nombre, ing1, ing2, ing3);
                    break;
                case 2:
                    sistema.deshacer();
                    break;
                case 3:
                    sistema.rehacer();
                    break;
                case 4:
                    sistema.mostrarPedidoActual();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
