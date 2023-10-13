package e4;

import java.util.ArrayList;
import java.util.List;

public enum BolaBillar {
    BLANCA(0, "BLANCO", "LISA"),
    BOLA1(1, "AMARILLO", "LISA"),
    BOLA2(2, "AZUL", "LISA"),
    BOLA3(3, "ROJO", "LISA"),
    BOLA4(4, "VIOLETA", "LISA"),
    BOLA5(5, "NARANJA", "LISA"),
    BOLA6(6, "VERDE", "LISA"),
    BOLA7(7, "GRANATE", "LISA"),
    BOLA8(8, "NEGRO", "LISA"),
    BOLA9(9, "AMARILLO", "RAYADA"),
    BOLA10(10, "AZUL", "RAYADA"),
    BOLA11(11, "ROJO", "RAYADA"),
    BOLA12(12, "VIOLETA", "RAYADA"),
    BOLA13(13, "NARANJA", "RAYADA"),
    BOLA14(14, "VERDE", "RAYADA"),
    BOLA15(15, "GRANATE", "RAYADA");

    private final int numero;
    private final String color;
    private final String tipo;

    BolaBillar(int numero, String color, String tipo) {
        this.numero = numero;
        this.color = color;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }
}
