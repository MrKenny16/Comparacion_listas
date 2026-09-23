import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ColasTrabajo {
    public static void main(String[] args) {

        Deque<String> trabajos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Cola de Trabajos ---");
            System.out.println("1. Agregar trabajo normal");
            System.out.println("2. Agregar trabajo urgente");
            System.out.println("3. Procesar siguiente trabajo");
            System.out.println("4. Consultar siguiente trabajo");
            System.out.println("5. Mostrar trabajos pendientes");
            System.out.println("6. Mostrar número de trabajos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del trabajo normal: ");
                    trabajos.addLast(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nombre del trabajo urgente: ");
                    trabajos.addFirst(scanner.nextLine());
                    break;
                case 3:
                    String procesado = trabajos.pollFirst();
                    System.out.println(procesado != null ? "Procesando: " + procesado : "No hay trabajos pendientes.");
                    break;
                case 4:
                    String siguiente = trabajos.peekFirst();
                    System.out.println(siguiente != null ? "Siguiente en cola: " + siguiente : "La cola está vacía.");
                    break;
                case 5:
                    System.out.println("Pendientes: " + trabajos);
                    break;
                case 6:
                    System.out.println("Total de trabajos: " + trabajos.size());
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}