package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.common.Card;
import org.example.common.Equation;

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
    
    /**
     * Instantiates a Referee, who keeps track of the game's scores, cards, and equations.
     * Communicates game state with Server and Players.
     *
     * @param msg - message
     */
    public Referee(Server s) {
        this.server = s;
        score = new HashMap<>();

        all_cards = new ArrayList<>();
        for (int i=0; i<NUM_TOTAL_CARDS; i++) {
            all_cards.add(Card.random());
        }
        visible_cards = all_cards.subList(0, NUM_VISIBLE_CARDS);

        for (int i=0; i<NUM_TOTAL_EQUATIONS; i++) {
            equations.add(new Equation());
        }

                
    }
    
    /**
     * Broadcasts a message (a play, game starting notifications, players being kicked)
     * to all players.
     *
     * @param msg - message
     */
    void broadcast(String msg) {
        // send message to all players
    }

    /**
     * Notifies a single player with a message.
     *
     * @param msg - message
     * @param player -  player
     */
    void notify(String msg, IPlayer player) {
        // send message to one player
    }

    // TODO: make it so players can only trade one card per turn.
    /**
     * Executes a card trade for a player, and returns the outcome of the transaction.
     *
     * @param card - card to be traded for
     * @param player -  player trading for the card
     * @return - true if trade succeeds, false if trade fails. 
     */
    boolean cardTrade(Card card, IPlayer player) {
        int pScore = score.get(player);
        if (player.pieces.canPurchase(card.pieces)) {
            // debit player's account
            player.pieces.removePieces(card.pieces);

            // award the player the point value of the Card (points left + old score)
            score.put(player, pScore + piecesLeftToCardValue(player.pieces.size(), card.hasStar));

            all_cards.remove(card);
            visible_cards.remove(card);
            return true;

        } else {
            // notify player they can't make purchase. 
            notify("Trade failed: You cannot purchase this card.", player);

            // return false;
            return false;

        }
    }

    /**
     * Returns the points to be awarded to a player based on how many 
     * pieces they have left and whether the card they bought has a star.
     *
     * @param piecesLeft - how many pieces player has left AFTER trade
     * @param hasStar -  whether card has a star or not
     * @return - point value of the card trade
     */
    int piecesLeftToCardValue(int piecesLeft, boolean hasStar) {
        
        if (hasStar) {
            switch (piecesLeft) {
                case 0:
                    return 8;

                case 1:
                    return 5;

                case 2:
                    return 3;


                default:
                    return 2;
            }
        } else {
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
