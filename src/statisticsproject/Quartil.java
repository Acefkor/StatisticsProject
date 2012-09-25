package statisticsproject;

/**
 *
 * Adjunto mi codigo basado en el calculo que realiza excel para determinar un
 * cuartil.
 *
 */
import java.util.Vector;

@SuppressWarnings({"UseOfObsoleteCollectionType","UnusedAssignment"})
public class Quartil {

    Vector<String> intervalo;

    public Quartil(Vector<String> intervalo) {
        super();
        this.intervalo = normalizar(intervalo);
    }

    private Vector<String> normalizar(Vector<String> intervalo) {
        if (intervalo.size() < 3) {
            String valor;
            int indice;
            double me = 0;
            int n = intervalo.size();
            if (isPar(n)) {
                int index1 = (n / 2) - 1;
                int index2 = index1 + 1;
                double a1 = new Double(intervalo.get(index1));
                double a2 = new Double(intervalo.get(index2));
                me = (a1 + a2) / 2;
                me = Round(me, 2);
                indice = index2;
            } else {
                int index = ((n + 1) / 2) - 1;
                if (index < 0) {
                    index = 0;
                }
                me = new Double(intervalo.get(index));
                indice = index + 1;
            }
            valor = String.valueOf(me);

            intervalo.insertElementAt(valor, indice);

            intervalo = normalizar(intervalo);
        }
        return intervalo;
    }

    public double getMedia() {
        double me = 0;
        int n = intervalo.size();
        if (isPar(n)) {
            int index1 = (n / 2) - 1;
            int index2 = index1 + 1;
            double a1 = new Double(intervalo.get(index1));
            double a2 = new Double(intervalo.get(index2));
            me = (a1 + a2) / 2;
        } else {
            int index = ((n + 1) / 2) - 1;
            me = new Double(intervalo.get(index));
        }
        return me;
    }

    public double getQ1() {
// L = (1/4)(9+3) = 3
        int n = intervalo.size();
        double Q1 = 0;
        double L = (0.25) * (n + 3);

        Q1 = getValor(L);
        return Q1;
    }

    public double getQ3() {
// U = (1/4)(3n+1)
        int n = intervalo.size();
        double Q3 = 0;
        double U = (0.25) * (3 * n + 1);
        Q3 = getValor(U);
        return Q3;
    }

    private boolean isPar(double numero) {
        return (numero % 2 == 0);
    }

    private double getValor(double L) {
        double valor;
        if (isPar(L)) {
            int index = (int) (L - 1);
            valor = new Double(intervalo.get(index));
        } else {
// tomo dos intervalos
            int index1 = (int) (L - 1);
            int index2 = index1 + 1;

            double a1 = new Double(intervalo.get(index1));
            double a2 = new Double(intervalo.get(index2));
            valor = (a1 + a2) / 2;
            valor = Round(valor, 2);
        }
        return valor;
    }

    private double Round(double Rval, int Rpl) {
        double p = (double) Math.pow(10, Rpl);
        Rval = Rval * p;
        double tmp = Math.round(Rval);
        return (double) tmp / p;
    }
}
