package org.example.common;

public class Card {
    PiecesBag pieces;
    boolean hasStar;

    public Card(String[] inputPieces, boolean hasStar) {
        pieces = new PiecesBag(inputPieces);
        this.hasStar = hasStar;
    }
    
}
