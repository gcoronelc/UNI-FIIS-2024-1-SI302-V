package pe.edu.uni.promedio.service;

public class PromedioService {

    public int promedio(int nota1, int nota2, int nota3) {
        // Variables
        int pr;
        // Proceso
        pr = (nota1 + nota2 + nota3) / 3;
        // Reporte
        return pr;
    }

    public String condicion(int promedio) {
        // Variables
        String condicion;
        // Proceso
        condicion = (promedio >= 14) ? "Aprobado" : "Desaprobado";
        // Reporte
        return condicion;
    }

}
