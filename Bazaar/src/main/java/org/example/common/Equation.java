package org.example.common;
import java.util.Random;

public class Equation {
    PiecesBag left;
    PiecesBag right;

    public Equation() {
        Random rand = new Random();
        left = PiecesBag.random(rand.nextInt(4));
        while (!right.equals(left)) {
            right = PiecesBag.random(rand.nextInt(4));
        }
    }
    
}