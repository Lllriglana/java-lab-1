public class Main {
    private static double formula(double x) {
        double part1 = Math.pow(2.0 * x, 3) / 2.0;
        double atanPart = Math.atan((x - 1.0) / 28.0);
        double xPowPart = Math.pow(x, 1.0 / 3.0) + 1.0;
        double fraction = part1 / (xPowPart / atanPart);
        double leftBlock = Math.pow(fraction, 3);
        double expInner = Math.pow(x / 2.0, 3);
        double middleBlock = Math.cos(Math.pow(Math.E, expInner));
        double acosInner = 0.1 * (x - 1.0) / 28.0;
        double acosPart = Math.acos(acosInner);
        double expAcos = Math.pow(Math.E, acosPart);
        double rightBlock = 0.5 - Math.asin(1.0 / expAcos);
        return leftBlock * middleBlock * rightBlock;
    }

    public static void main(String[] args) {

        long[] v = new long[] {4, 6, 8, 10, 12, 14, 16};
        double[] x = new double[15];
        for (int j = 0; j < x.length; j++) {
            x[j] = -15 + Math.random() * 28;  // случайные числа
        }

        double[][] d = new double[7][15];

        for (int i = 0; i < v.length; i++) {
            if (v[i] == 4) {
                for (int j = 0; j < x.length; j++) {
                    double X = x[j];
                    d[i][j] = Math.tan(Math.tan(Math.log(Math.abs(X))));
                }
            }
            else if (v[i] == 12 || v[i] == 14 || v[i] == 16) {
               for (int j = 0; j < x.length; j++ )  {
                   double X = x[j];
                   d[i][j] = Math.tan((Math.sin(X) - Math.PI) / 4.0);
               }
            }
            else {
                for (int j = 0; j < x.length; j++) {
                    double X = x[j];
                    d[i][j] = formula(X);
                }
            }
            for (int j = 0; j < d[i].length; j++) {
                System.out.printf("%10.4f ", d[i][j]);;  // четыре знака после запятой
            }
            System.out.println(); // перенос строки
        }
    }
}
