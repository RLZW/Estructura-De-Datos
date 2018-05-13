package mx.itesm.cem.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MonteCarlo {

    private static class Timer {
        private long start;

        public void start() {
            start = System.nanoTime();
        }

        public double stop() {
            return (System.nanoTime() - start) / 1e9;
        }
    }

    public static double sequentialMonteCarlo(int n) {
        Random rnd = new Random();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            double x = rnd.nextDouble() * 2 - 1;
            double y = rnd.nextDouble() * 2 - 1;
            double h = x * x + y * y;
            if (h <= 1) {
                sum++;
            }
        }
        return 4 * ((double) sum / n);
    }

    public static double parallelMonteCarlo(int n) {
        ForkJoinPool pool = new ForkJoinPool();
        MonteCarloTask t = new MonteCarloTask(0, n);
        int r = pool.invoke(t);
        double result = 4 * ((double) r / n);
        return result;
    }

    public static void main(String[] args) {

        final int n = 100_000_000;
        double rs, rp, ts, tp, sp;

        Timer t = new Timer();

        t.start();
        rs = sequentialMonteCarlo(n);
        ts = t.stop();

        System.out.printf("Resultado secuencial = %.6f%n", rs);
        System.out.printf("Ts = %.2f seg.%n", ts);

        t.start();
        rp = parallelMonteCarlo(n);
        tp = t.stop();

        System.out.printf("Resultado paralelo = %.6f%n", rp);
        System.out.printf("Tp = %.2f seg.%n", tp);

        sp = ts / tp;

        System.out.printf("Sp = Ts/Tp = %.4f%n", sp);
    }
}