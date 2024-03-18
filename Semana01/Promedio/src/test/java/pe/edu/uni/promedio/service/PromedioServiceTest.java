package pe.edu.uni.promedio.service;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class PromedioServiceTest {

    @Test
    public void testPromedio() {
        // Arrange
        PromedioService servicio = new PromedioService();
        // Act
        int resultado = servicio.promedio(10, 12, 14);
        // Assert
        assertEquals(12, resultado);
    }

    @Test
    public void testCondicionAprobado() {
        // Arrange
        PromedioService servicio = new PromedioService();
        // Act
        String resultado = servicio.condicion(14);
        // Assert
        assertEquals("Aprobado", resultado);
    }

    @Test
    public void testCondicionDesaprobado() {
        // Arrange
        PromedioService servicio = new PromedioService();
        // Act
        String resultado = servicio.condicion(10);
        // Assert
        assertEquals("Desaprobado", resultado);
    }

}
