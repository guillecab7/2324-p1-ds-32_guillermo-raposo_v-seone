package e4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

class MesaBillarTest {

    private MesaBillar mesa;

    @Before
    public void setUp() {
        mesa = new MesaBillar();
    }

    @Test
    public void testIniciarPartida() {
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaBlanca() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BLANCA);

        assertFalse(mesa.dentro().contains(BolaBillar.BLANCA));
        assertTrue(mesa.fuera().contains(BolaBillar.BLANCA));
    }

    @Test
    public void testMeterBolaNegra() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA8);

        assertFalse(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaInvalida() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA1);

        assertTrue(mesa.dentro().contains(BolaBillar.BOLA1));
        assertFalse(mesa.fuera().contains(BolaBillar.BOLA1));
    }

    @Test
    public void testObtenerGanador() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA1);
        mesa.meterBola(BolaBillar.BOLA9);
        mesa.meterBola(BolaBillar.BOLA2);

        assertEquals("Va ganando el jugador de las bolas lisas", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA8);

        assertEquals("Ganó el jugador de las bolas lisas", mesa.obtenerGanador());

        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA9);
        mesa.meterBola(BolaBillar.BOLA8);

        assertEquals("Ganó el jugador de las bolas rayadas", mesa.obtenerGanador());
    }
}
