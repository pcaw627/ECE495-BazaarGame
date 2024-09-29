package org.example.common;

import java.util.Random;

public class Card {
    static int PIECES_PER_CARD = 5;
    public PiecesBag pieces;
    public boolean hasStar;

    public Card(String[] inputPieces, boolean hasStar) {
        this.pieces = new PiecesBag(inputPieces);
        this.hasStar = hasStar;
    }
    
    public Card(PiecesBag p, boolean hasStar) {
        this.pieces = p;
        this.hasStar = hasStar;
    }
    
    public static Card random() {
        Random rand = new Random();
        return new Card(PiecesBag.random(PIECES_PER_CARD), rand.nextBoolean());        
    }
    
}
