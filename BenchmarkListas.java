import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkListas {
    private static final int N = 100_000;

    public static void main(String[] args) {

        System.out.println("--- 8. Benchmark de acceso ---");
        List<Integer> arrayListAcceso = new ArrayList<>();
        List<Integer> linkedListAcceso = new LinkedList<>();
        llenar(arrayListAcceso, N);
        llenar(linkedListAcceso, N);
        medirAcceso("ArrayList", arrayListAcceso);
        medirAcceso("LinkedList", linkedListAcceso);


        System.out.println("\n--- 9. Inserciones al inicio (50,000 elementos) ---");
        medirInsercionInicio("ArrayList", new ArrayList<>());
        medirInsercionInicio("LinkedList", new LinkedList<>());


        System.out.println("\n--- 10. Inserciones al final (100,000 elementos) ---");
        medirInsercionFinal("ArrayList", new ArrayList<>());
        medirInsercionFinal("LinkedList", new LinkedList<>());


        System.out.println("\n--- 11. Eliminaciones al inicio (50,000 elementos) ---");
        List<Integer> arrayListEliminar = new ArrayList<>();
        List<Integer> linkedListEliminar = new LinkedList<>();


        llenar(arrayListEliminar, 50_000);
        llenar(linkedListEliminar, 50_000);

        medirEliminacionInicio("ArrayList", arrayListEliminar);
        medirEliminacionInicio("LinkedList", linkedListEliminar);
    }


    private static void llenar(List<Integer> lista, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            lista.add(i);
        }
    }

    private static void medirAcceso(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        long suma = 0;


        for (Integer valor : lista) {
            suma += valor;
        }

        long fin = System.nanoTime();
        System.out.printf("%s: %.3f ms (Suma: %d)%n", nombre, (fin - inicio) / 1_000_000.0, suma);
    }

    private static void medirInsercionInicio(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();

        for (int i = 0; i < 50_000; i++) {
            lista.add(0, i);
        }

        long fin = System.nanoTime();
        System.out.printf("%s: %.3f ms%n", nombre, (fin - inicio) / 1_000_000.0);
    }

    private static void medirInsercionFinal(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            lista.add(i);
        }

        long fin = System.nanoTime();
        System.out.printf("%s: %.3f ms%n", nombre, (fin - inicio) / 1_000_000.0);
    }

    private static void medirEliminacionInicio(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();

        while (!lista.isEmpty()) {
            lista.remove(0);
        }

        long fin = System.nanoTime();
        System.out.printf("%s: %.3f ms%n", nombre, (fin - inicio) / 1_000_000.0);
    }
}