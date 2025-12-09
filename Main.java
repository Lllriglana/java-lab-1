public class Main {
    private static double Third(double x) {
        // числитель главной дроби
        double Chisl = Math.atan((x - 4.0) / 18.0);
        double Chisl1 = Math.tan(Chisl / 2.0);
        // возведение в степень числителя
        double chislitel = Math.pow(Chisl1, 2.0 * x);

        // знаменатель
        double logor = Math.log(Math.abs(x));
        double stepen_znam = Math.pow(logor, 2.0 * Math.exp(x));
        double znam = 1.0 - Math.tan(stepen_znam);
        // дробь
        double drob = chislitel / znam;

        // первая степень дроби
        double stepen_drobi1 = Math.pow(2.0 * Math.pow(x, x), Chisl1);

        // вторая степень дроби
        double s = x / (x - 0.5) - 1.0;
        double p = 0.5 * s;
        double i = Math.pow(p, Math.cbrt(x));
        double stepen_drobi2 = (3.0 / 4.0) * (Math.PI + i);

        return drob * stepen_drobi1 * stepen_drobi2;
    }

    public static void main(String[] args) {
        int[] w = new int[16];
        int chislo = 18;
        for (int i = 0; i < w.length; i++) {
            w[i] = chislo--;
        }
        float[] x = new float[12];
        for (int j = 0; j < x.length; j++) {
            x[j] = (float) (-13.0 + Math.random() * 18.0);
        }

        double[][] f = new double[16][12];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < x.length; j++) {
                double X = x[j]; // работаем в double

                if (w[i] == 4) {
                    // основание
                    double osnov = 0.5 * (Math.cos(X) - 0.5);
                    // степень
                    double koren_v_step = Math.pow(osnov, Math.cbrt(X));
                    double step1 = Math.log(Math.abs(X));
                    // степень арксинуса
                    double step2 = Math.pow(step1, 2.0 * Math.asin((X - 4.0) / 18.0));

                    f[i][j] = Math.pow(koren_v_step, step2);

                } else if (w[i] == 3 || w[i] == 6 || w[i] == 7 || w[i] == 8
                        || w[i] == 9 || w[i] == 10 || w[i] == 12 || w[i] == 17) {

                    double second = Math.atan(1.0 / Math.pow(Math.E, Math.abs(X))) - 1.0;
                    f[i][j] = Math.pow(second, 3.0);

                } else {
                    f[i][j] = Third(X);
                }
            }
        }

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.printf("%8.2f ", f[i][j]);
            }
            System.out.println();
        }
    }
}