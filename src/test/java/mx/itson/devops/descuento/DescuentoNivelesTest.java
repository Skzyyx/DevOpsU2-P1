package mx.itson.devops.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * P3 - Nueva regla de negocio: nivel de 15 % desde 500 unidades.
 *
 * Estructura AAA (Arrange / Act / Assert) explicita en cada prueba.
 * Las dos primeras ya estan resueltas como ejemplo de estilo; completa
 * las que dicen TODO.
 */
class DescuentoNivelesTest {

    private final Descuento descuento = new Descuento();

    @Test
    void sinDescuentoAntesDeLaPrimeraFrontera() {
        // Arrange
        int unidades = 99;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(0, obtenido);
    }

    @Test
    void diezPorCientoEnLaPrimeraFrontera() {
        // Arrange
        int unidades = 100;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(10, obtenido);
    }

    @Test
    void diezPorCientoEnLimiteSuperior() {
        // Arrange
        Descuento d = new Descuento();
        int unidades = 499;

        // Act
        int resultado = d.porcentaje(unidades);

        // Assert
        assertEquals(10, resultado);
    }

    @Test
    void quincePorCientoEnElSegundoNivel() {
        // Arrange
        Descuento d = new Descuento();
        int unidades = 500;

        // Act
        int resultado = d.porcentaje(unidades);

        // Assert
        assertEquals(15, resultado);
    }

    @Test
    void precioInvalidoLanzaExcepcion() {
        // Arrange
        Descuento d = new Descuento();
        long precioInvalido = 0L;
        int unidades = 10;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            d.totalCentavos(precioInvalido, unidades);
        });
    }
}
