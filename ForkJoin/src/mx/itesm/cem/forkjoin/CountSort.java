package mx.itesm.cem.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class CountSort {
    
    private static class Timer {
        private long start;

        public void start() {
            start = System.nanoTime();
        }

        public double stop() {
            return (System.nanoTime() - start) / 1e9;
        }
    }

    public static int[] createArray(int n) {
        Random rand = new Random(42);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt(1_000_000);
        }
        return result;
    }

    public static boolean isSorted(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void sequentialCountSort(int a[]) {
        final int n = a.length;
        final int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] < a[i]) {
                    count++;
                } else if (a[i] == a[j] && j < i) {
                    count++;
                }
            }
            temp[count] = a[i];
        }
        System.arraycopy(temp, 0, a, 0, n);
    }

    public static void parallelCountSort(int a[]) {
        final int n = a.length;
        final int[] temp = new int[n];
        ForkJoinPool pool = new ForkJoinPool();
        CountSortAction action = new CountSortAction(a, temp, 0, n);
        pool.invoke(action);
        System.arraycopy(temp, 0, a, 0, n);
    }

    public static void main(String[] args) {

        final int n = 100_000;
        double ts, tp, sp;
        int[] array;

        Timer t = new Timer();

        array = createArray(n);
        System.out
                .println("Antes de ordenamiento secuencial, arreglo ordenado: "
                        + isSorted(array));

        t.start();
        sequentialCountSort(array);
        ts = t.stop();

        System.out
                .println("Después de ordenamiento secuencial, arreglo ordenado: "
                        + isSorted(array));
        System.out.printf("Ts = %.2f seg.%n", ts);

        array = createArray(n);
        System.out.println("Antes de ordenamiento paralelo, arreglo ordenado: "
                + isSorted(array));

        t.start();
        parallelCountSort(array);
        tp = t.stop();

        System.out
                .println("Después de ordenamiento paralelo, arreglo ordenado: "
                        + isSorted(array));
        System.out.printf("Tp = %.2f seg.%n", tp);

        sp = ts / tp;

        System.out.printf("Sp = Ts/Tp = %.4f%n", sp);
    }
}