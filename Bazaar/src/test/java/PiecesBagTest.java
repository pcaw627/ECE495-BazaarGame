import org.example.PiecesBag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PiecesBagTest {
    private PiecesBag a;
    private PiecesBag b;
    @BeforeEach
    public void setUp() {
        String[] input1 = {"red", "red", "blue", "green"};
        String[] input2 = {"red", "red", "yellow", "blue", "green"};

        a = new PiecesBag(input1);
        b = new PiecesBag(input2);
    }
    @Test
    public void testAddPiece() {
        a.addPiece("yellow");
        assertTrue(a.equals(b));
    }

    @Test
    public void testRemovePiece() {
        b.removePiece("yellow");
        assertTrue(b.equals(a));
        b.removePiece("red");
        a.removePiece("red");
        assertTrue(b.equals(a));
    }

    @Test
    public void testAddPieces(){
        String[] input1 = {"red", "red", "blue", "green"};
        PiecesBag c = new PiecesBag(input1);
        String[] input2 = {"red", "red", "red", "red", "blue","blue", "green", "green"};
        PiecesBag d = new PiecesBag(input2);
        a.addPieces(c);
        assertTrue(a.equals(d));
    }

    @Test
    public void testRemovePieces(){
        String[] input1 = {"red", "red", "blue", "green"};
        PiecesBag c = new PiecesBag(input1);
        String[] input2 = {};
        PiecesBag d = new PiecesBag(input2);
        String[] input3 = {"yellow"};
        PiecesBag f = new PiecesBag(input3);
        a.removePieces(c);
        b.removePieces(c);
        assertTrue(a.equals(d));
        assertFalse(a.pieces.containsKey("red"));
        assertTrue(b.equals(f));
    }

    @Test
    public void testCanPurchaseBWithA(){
        assertFalse(a.canPurchase(b));
    }

    @Test
    public void testCanPurchaseAWithB(){
        assertTrue(b.canPurchase(a));
    }

    @Test
    public void testRemoveWithInvalidColor(){
        String[] input1 = {"red", "red", "blue", "green"};
        PiecesBag c = new PiecesBag(input1);
        a.removePiece("yellow");
        assertTrue(a.equals(c));
    }

    @Test
    public void testToString(){
        assertEquals(a.toString(), "{red=2, green=1, blue=1}");
    }

    @Test
    public void testCanPurchaseWithBLessThanA(){
        b.addPiece("red");
        b.removePiece("yellow");
        assertFalse(a.canPurchase(b));
    }

    @Test
    public void removePiecesWithBContainingAColorNotInA(){
        a.removePieces(b);
        String[] input1 = {};
        PiecesBag c = new PiecesBag(input1);
        assertTrue(a.equals(c));
    }

    @Test
    public void removeTooMany(){
        b.addPiece("red");
        b.removePiece("yellow");
        a.removePieces(b);
        String[] input1 = {"red", "red"};
        PiecesBag c = new PiecesBag(input1);
        assertTrue(a.equals(c));
    }

    @Test
    public void testNotEquals(){
        assertFalse(a.equals(b));
    }

    @Test
    public void testNotEqualsWithMoreRed(){
        b.addPiece("red");
        b.removePiece("yellow");
        assertFalse(a.equals(b));
    }

    @Test
    public void testInitializeWithPurple(){
        String[] input1 = {"red", "red", "blue", "green", "purple"};
        String[] input2 = {};
        PiecesBag c = new PiecesBag(input1);
        PiecesBag d = new PiecesBag(input2);
        assertTrue(c.equals(d));
    }

    @Test
    public void testAddInvalidColor(){
        String[] input1 = {"red", "red", "blue", "green"};
        PiecesBag c = new PiecesBag(input1);
        a.addPiece("purple");
        assertTrue(a.equals(c));
    }

    @Test
    public void testRemainingPieces(){
        String[] input1 = {"red"};
        PiecesBag c = new PiecesBag(input1);
        String[] input2 = {"red", "blue", "green"};
        PiecesBag d = new PiecesBag(input2);
        a.removePieces(c);
        assertTrue(a.equals(d));
    }
}
