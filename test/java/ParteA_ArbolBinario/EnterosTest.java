package ParteA_ArbolBinario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnterosTest {

    @Test
    void getValor() {
        Enteros e = new Enteros(10);
        Assertions.assertEquals(10, e.getValor());
    }

    @Test
    void compareTo() {
        Enteros a = new Enteros(5);
        Enteros b = new Enteros(10);
        Enteros c = new Enteros(5);

        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(a) > 0);
        Assertions.assertEquals(0, a.compareTo(c));
    }

    @Test
    void sumar() {
        Enteros a = new Enteros(7);
        Enteros b = new Enteros(3);

        Enteros resultado = a.sumar(b);

        Assertions.assertEquals(10, resultado.getValor());
    }

    @Test
    void testToString() {
        Enteros e = new Enteros(42);
        Assertions.assertEquals("42", e.toString());
    }
}