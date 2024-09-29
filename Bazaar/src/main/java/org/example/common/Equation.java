package org.example.common;
import java.util.Random;

public class Equation {
    PiecesBag left;
    PiecesBag right;

    public Equation() {
        Random rand = new Random();
        this.left = PiecesBag.random(rand.nextInt(4));
        while (!right.equals(left)) {
            this.right = PiecesBag.random(rand.nextInt(4));
        }
    }

    public Equation(PiecesBag left, PiecesBag right) {
        this.left = left;
        this.right = right;
    }
    
}