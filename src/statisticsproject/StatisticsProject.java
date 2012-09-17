package statisticsproject;

import javax.swing.JOptionPane;

/**
 *
 * @author acefkor
 */
public class StatisticsProject {

    static int MAX = 5;

    @SuppressWarnings("UnusedAssignment")
    static int elijeOpcion() {
        int opcion = 0;
        String cadena = JOptionPane.showInputDialog("Calcular: \n 1)Promedio Ponderado.\n 2)Moda.\n 3)Mediana.\n 4)Máximo.\n 5)Mínimo.\n 6)Reiniciar.\n 7)Salir.");
        opcion = Integer.parseInt(cadena);
        return opcion;
    }

    static int moda(int numero[], int frecuencia[]) {
        int moda = 0, frec = 0;
        for (int j = 0; j < numero.length; j++) {
            if (frecuencia[j] > frec) {
                frec = frecuencia[j];
                moda = numero[j];
            }
        }
        return moda;
    }

    @SuppressWarnings("UnusedAssignment")
    static int mediana(int numero[], int frecuencia[]) {
        int med = 0, medi = 0, indice = 0;
        int[] frecuenciaAcumulada = new int[MAX];
        int[] frecuenciaAcumuladaOrdenada = new int[MAX];
        frecuenciaAcumulada[0] = frecuencia[0];
        for (int j = 1; j < frecuencia.length; j++) {
            frecuenciaAcumulada[j] = frecuenciaAcumulada[j - 1] + frecuencia[j];
        }
        frecuenciaAcumuladaOrdenada = ordenaArreglo(frecuenciaAcumulada);
        med = frecuenciaAcumuladaOrdenada[MAX - 1] / 2;
        int k = 0;
        while (med > frecuenciaAcumuladaOrdenada[k]) {
            k++;
        }
        medi = frecuenciaAcumuladaOrdenada[k];
        return medi;
    }

    @SuppressWarnings("UnusedAssignment")
    static int promedioPonderado(int numero[], int frecuencia[]) {
        int sum = 0, prom = 0, n = 0;
        for (int i = 0; i < numero.length; i++) {
            sum = sum + (frecuencia[i] * numero[i]);
            n = n + frecuencia[i];
        }
        prom = sum / n;
        return prom;
    }

    @SuppressWarnings("UnusedAssignment")
    static int maximo(int numero[], int frecuencia[]) {
        int[] frecuenciaOrdenada = new int[MAX];
        frecuenciaOrdenada = ordenaArreglo(frecuencia);
        return frecuenciaOrdenada[MAX - 1];
    }

    @SuppressWarnings("UnusedAssignment")
    static int minimo(int numero[], int frecuencia[]) {
        int[] frecuenciaOrdenada = new int[MAX];
        frecuenciaOrdenada = ordenaArreglo(frecuencia);
        return frecuenciaOrdenada[0];
    }

    @SuppressWarnings("UnusedAssignment")
    static int[] ordenaArreglo(int arreglo[]) {
        int k = 0;
        for (int i = 1; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    k = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = k;
                }
            }
        }
        return arreglo;
    }

    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
        int opcion = 0, retro = 0;
        int numero[] = new int[MAX];
        int frecuencia[] = new int[MAX];
        String cadena;
        do {
            retro = 0;
            for (int i = 0; i < numero.length; i++) {
                cadena = JOptionPane.showInputDialog("Igrese numero " + (i + 1) + " :");
                numero[i] = Integer.parseInt(cadena);
                cadena = JOptionPane.showInputDialog("Igrese su frecuencia : ");
                frecuencia[i] = Integer.parseInt(cadena);
            }
            do {
                opcion = elijeOpcion();
                int moda = 0, mediana = 0, maximo = 0, minimo = 0, promedio = 0;
                switch (opcion) {
                    case 1:
                        promedio = promedioPonderado(numero, frecuencia);
                        JOptionPane.showMessageDialog(null, "Promedio: " + promedio);
                        break;
                    case 2:
                        moda = moda(numero, frecuencia);
                        JOptionPane.showMessageDialog(null, "Moda: " + moda);
                        break;
                    case 3:
                        mediana = mediana(numero, frecuencia);
                        JOptionPane.showMessageDialog(null, "Mediana: " + mediana);
                        break;
                    case 4:
                        maximo = maximo(numero, frecuencia);
                        JOptionPane.showMessageDialog(null, "Máximo: " + maximo);
                        break;
                    case 5:
                        minimo = minimo(numero, frecuencia);
                        JOptionPane.showMessageDialog(null, "Mínimo: " + minimo);
                        break;
                    case 6:
                        retro = 1;
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese una opción válida...");
                }
            } while (retro == 0);
        } while (retro == 1);
    }
}
