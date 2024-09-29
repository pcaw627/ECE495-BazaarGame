package org.example.common;

import java.util.*;

public class PiecesBag {
    // Maps the color of each pebble with the count for that color. 
    public Map<String, Integer> pieces = new HashMap<>();
    public String[] colors = {"red", "blue", "yellow", "green", "white"};

    public PiecesBag(String[] inputpieces) {
        for (String piece : inputpieces){
            if(!Arrays.asList(colors).contains(piece)){
                try {
                    throw new IllegalArgumentException("Invalid piece: " + piece);
                }catch(IllegalArgumentException e){
                    System.out.println(e);
                }
            }
        }
        for (String piece : inputpieces) {
            if (pieces.containsKey(piece)) {
                pieces.put(piece, pieces.get(piece) + 1);
            } else {
                pieces.put(piece, 1);
            }
        }
    }

    public static PiecesBag random(int size) {
        String[] colors = {"red", "blue", "yellow", "green", "white"};
        // raise exc if size > 4
        List<String> piecesList = new ArrayList<>();

        for (int i=0; i<size; i++) {
            Random rand = new Random();
            piecesList.add(Arrays.asList(colors).get(rand.nextInt(colors.length)));
        }

        String[] inputArray = piecesList.toArray(new String[piecesList.size()]);
        return new PiecesBag(inputArray);
    }

    public int size() {
        int size = 0;
        for (int count : pieces.values()) {
            size += count;
        }
        return size;
    }

    // returns if PiecesBag b is a subset of this PiecesBag (a). 
    public boolean canPurchase(PiecesBag b) {
        for (Map.Entry<String, Integer> entry : b.pieces.entrySet()) {
            if (this.pieces.containsKey(entry.getKey())) {
                // check num
                // if A's mapping for key maps to a greater value than B's mapping for that key
                if (this.pieces.get(entry.getKey()) < b.pieces.get(entry.getKey())) {
                    return false;
                }
            } else {
                // return false if b contains a key that a does not.
                return false;
            }
        }

        return true;
    }

    // modifies this PiecesBag in-place, adding a single Piece.
    public void addPiece(String b) {
        if(Arrays.asList(this.colors).contains(b)) {
            this.pieces.putIfAbsent(b, 0);
            this.pieces.put(b, this.pieces.get(b) + 1);
        }
    }

    // modifies this PiecesBag in-place, removing a single Piece. 
    // if b cannot be removed from a, a will remain unchanged. 
    public void removePiece(String b) {
        try {
            if (!this.pieces.containsKey(b)) {
                throw new Exception("No pieces present to remove: check with canPurchase() first. ");
            } else {
                this.pieces.put(b, this.pieces.get(b)-1);
                if(this.pieces.get(b) == 0) {
                    this.pieces.remove(b);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // modifies this PiecesBag in-place, adding all Pieces in PieceBag b to this PieceBag.
    public void addPieces(PiecesBag b) {
        for (Map.Entry<String, Integer> entry : b.pieces.entrySet()) {
                this.pieces.putIfAbsent(entry.getKey(), 0);
                int bPieces = b.pieces.get(entry.getKey());
                this.pieces.put(entry.getKey(), this.pieces.get(entry.getKey()) + bPieces);
        }
    }

    // modifies this PiecesBag in-place, removing all Pieces in PieceBag b from this PieceBag.
    public void removePieces(PiecesBag b) {
        for (Map.Entry<String, Integer> entry : b.pieces.entrySet()) {
            try {
                if (!this.pieces.containsKey(entry.getKey())) {
                    throw new Exception("B's bag contains a piece not present in A: check with canPurchase() first. ");
                } else if (this.pieces.get(entry.getKey()) < b.pieces.get(entry.getKey())){
                    throw new Exception("B contains too many pieces to be removed from A: check with canPurchase() first. ");
                } else {
                    int remainingPieces = this.pieces.get(entry.getKey()) - b.pieces.get(entry.getKey());
                    this.pieces.put(entry.getKey(), remainingPieces);
                    if(remainingPieces == 0) {
                        this.pieces.remove(entry.getKey());
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
           
        }
    }

    public String toString() {
        return this.pieces.toString();
    }

    public boolean equals(PiecesBag b){
        for (Map.Entry<String, Integer> entry : b.pieces.entrySet()) {
            if(!this.pieces.containsKey(entry.getKey())){
                return false;
            }
            int aValue = this.pieces.get(entry.getKey());
            int bValue = entry.getValue();
            if(aValue != bValue){
                return false;
            }
        }
        return true;
    }

    /*public static void main(String[] args) {
        String[] input1 = {"red", "red", "blue", "green"};
        String[] input2 = {"red", "red", "yellow", "blue", "green"};

        PiecesBag a = new PiecesBag(input1);
        PiecesBag b = new PiecesBag(input2);

        System.out.println(a.toString());
        System.out.println(b.toString());

        System.out.println(a.canPurchase(b));
        System.out.println(b.canPurchase(a));
        a.addPiece ("yellow");
        System.out.println(a.equals(b));

        a.removePiece("black");
        a.removePiece("red");
        System.out.println(a.toString());
        String[] temp_in = {"red", "blue"};
        String[] temp_in2 = {"red", "red"};
        PiecesBag temp = new PiecesBag(temp_in);
        PiecesBag temp2 = new PiecesBag(temp_in2);
        a.removePieces(temp);
        System.out.println(a.toString());
        // a.removePiece("red");
        a.addPieces(temp2);
        System.out.println(a.toString());

    }*/

}
