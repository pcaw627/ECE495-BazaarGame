package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.example.common.*;
import org.example.*;

/*
 * Referee - essential component. 
 * Reports the scoreboard and sets up the map and game pieces, 
 * At start of game, displays 10 random equations,
 * Informs observers of in game actions, 
 * Cancels players that cheat or timeout, 
 * Maintains a Bank object that Players can trade with. 
 */
public class Referee {
    int NUM_TOTAL_CARDS = 20;
    int NUM_VISIBLE_CARDS = 5;
    int NUM_TOTAL_EQUATIONS = 10;
    List<Card> all_cards;
    List<Card> visible_cards;
    List<Equation> equations;
    HashMap<IPlayer, Integer> score;
    Server server;
    HashMap<Integer, Integer> piecesLeftToCardValue;
    
    public Referee(Server s) {
        this.server = s;
        score = new HashMap<>();
        piecesLeftToCardValue = new HashMap<>();
        piecesLeftToCardValue.putIfAbsent(0, 5);
        piecesLeftToCardValue.putIfAbsent(1, 4);

        all_cards = new ArrayList<>();
        for (int i=0; i<NUM_TOTAL_CARDS; i++) {
            all_cards.add(Card.random());
        }
        visible_cards = all_cards.subList(0, NUM_VISIBLE_CARDS);

        for (int i=0; i<NUM_TOTAL_EQUATIONS; i++) {
            equations.add(new Equation());
        }

                
    }

    void broadcast(String play) {
        // send message to all players
    }

    void cardTrade(Card card, IPlayer player) {
        int pScore = score.get(player);
        if (player.pieces.canPurchase(card.pieces)) {
            // debit player's account
            player.pieces.removePieces(card.pieces);

            // award the player the point value of the Card (points left + old score)
            score.put(player, pScore + player.pieces.size());

        } else {
            // notify player they can't make purchase. 
            // Option 1: end player's turn
            // Option 2: allow player to reselect card to trade.

        }
    }

    int piecesLeftToCardValue(int piecesLeft, boolean hasStar) {
        
        if (hasStar) {
            switch (piecesLeft) {
                case 0:
                    return 5;

                case 1:
                    return 3;

                case 2:
                    return 2;


                default:
                    return 1;
            }
        }
    }

    
}
