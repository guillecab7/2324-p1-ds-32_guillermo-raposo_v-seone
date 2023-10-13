package e4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MesaBillar {
    private final List<BolaBillar> bolas;
    private final List<BolaBillar> mesa;
    private boolean partidaIniciada;

    private final int lisas;
    private final int rayadas;

    public MesaBillar() {
        bolas = new ArrayList<>();
        mesa = new ArrayList<>();
        partidaIniciada = false;
        lisas = 0;
        rayadas = 0;

        bolas.addAll(Arrays.asList(BolaBillar.values()).subList(1, 16));
    }

    public void iniciarPartida() {
        if (!partidaIniciada) {
            partidaIniciada = true;
            System.out.println("La partida ya empezó, todas las bolas están en juego");
        }
    }

    public void meterBola(BolaBillar bola) {
        if (partidaIniciada) {
            if (bola == BolaBillar.BOLA8) {
                System.out.println("La partida ha terminado ya que se introdució la bola negra");
                partidaIniciada = false;
            } else if (bola == BolaBillar.BLANCA) {
                if (mesa.contains(BolaBillar.BLANCA))
                    System.out.println("Se introdució la bola blanca y ya está a la mesa");
                else {
                    mesa.add(BolaBillar.BLANCA);
                    System.out.println("Se introdució la bola blanca y ya ha vuelto a la mesa");
                }
            } else {
                if (mesa.contains(bola)) {
                    mesa.remove(bola);
                    bolas.add(bola);
                    System.out.println("La bola " + bola.name() + " ha sido introducida y ha vuelto al cajetín.");
                }
                else System.out.println("La bola " + bola.name() + " no está en la mesa.");
            }
        } else System.out.println("No se está jugando");
    }

    public List<BolaBillar> dentro() {
        return bolas;
    }

    public List<BolaBillar> fuera() {
        return mesa;
    }

    public boolean esPartidaIniciada() {
        return partidaIniciada;
    }

    public String obtenerGanador() {

        if (partidaIniciada) {
            if (lisas < rayadas)
                return "Va ganando el jugador de las bolas lisas";
            else if (rayadas < lisas)
                return "Va ganando el jugador de las bolas rayadas";
            else
                return "Por ahora, tanto jugador de bolas lisas como el de rayadas llevan las mismas bolas introducidas";
        } else {
            if (lisas < rayadas)
                return "Ganó el jugador de las bolas lisas";
            else if (rayadas < lisas)
                return "Ganó el jugador de las bolas rayadas";
            else
                return "La partida termina en empate";
        }

    }
}