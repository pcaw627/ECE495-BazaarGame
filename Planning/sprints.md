
3 sprints: looking at task doc for components, enumerate tasks, break them down further, time estimate for each. take into account dependencies. 

# concepts, people, objects, actions

First start with building classes and interfaces (1). Then fill out implementations and test cases. (2). Then, finish up implementations and ensure test cases have full coverage (3).


# (1) constructing classes (purpose statements, data schema) and and interfaces (2-3 hrs). 9/29 12pm-3pm. 

IPlayer - a bot/human/actor that initiates trades and moves. 
+ piecesBag
+ int score
+ function strategy
+ int turn
+ boolean kicked
+ private double balance
+ void payHouse(int fee) # debits Player account and credits Server account
+ implemented by HousePlayer, ClientPlayer

Card - In exchange for pebbles, awards Players points. 
+ piecesBag
+ boolean star

Bank - manages and limits Players' requests to trade.
+ piecesBag
+ pebbleExchange(Equation, Player, List<Piece>)

PiecesBag - stores color of pebbles with corresponding number of pebbles for that color
+ HashMap<String, Integer> pieces
+ generateRandom(int numOfPieces) #method to generate a random PiecesBag given an input of how many pieces should be in the bag

Equations - exchange rate for trading pieces.
+ PiecesBag left
+ PiecesBag right

Referee - essential component; cancels players that cheat or timeout; also reports the scoreboard and sets up the map and game pieces; Also informs observers of in game actions. At start of game, displays 10 random equations.
+ List<Card> total
+ List<Card> visible
+ List<Equation> # initialized by ref, but NOT modifiable afterwards. publicly available.
+ HashMap<Player, int score> # centrally maintained within Referee to ensure no tampering from Players. 
+ int turnTime
+ int timeout # after timeout, kick Player, nix score, and continue to next Player. 
+ void broadcast(String play) -> sends play data to Players and Observers. 
+ void cardTrade(Card, Player)

Observers - mostly passive, no external impact. 
+ String[] msgs # broadcasts heard. 
+ void listen(String brdcast) -> records messages heard to msgs. 
+ subClass AdObserver 
  + int revenue
  + void genRevenue()

Server - essential component. manages player communications, also registers signups. 
+ Is main essential class; initializes referee
+ List<Player> waitList
+ List<Player> gamePlayerList
+ private double balance (check questions doc.)
+ populate some house players in game with advantage




# (2) Filling out implementation for all classes, Writing test cases for ALL methods *as they are implemented*. (6 hours) 9/29 3pm-4:30pm & 10/6 12pm-4:30pm. 

+ Signup Period
+ Waitlist
+ Balances / Cashing out of Victors and Losers
+ Card Trades
+ Pebble Trades
+ Signups
+ Enabling Custom Trading Functions
+ Kicking Players / Cheat Detection
+ Managing Turns
+ Reporting Scores
+ Broadcasting
+ Observer Revenue
+ Endgame Conditions


# (3) Finishing Implementation, Ensuring code coverage for test cases. 10/13 12pm-4:30pm. 

+ Finish implementations. 
+ Ensure code coverage.
+ Submit written report if needed. 
+ Check all blocks are commented, all methods have purpose statements. (Style & Maintainability).


