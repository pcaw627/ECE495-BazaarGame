Is the game manager to be considered its own component, or implemented as part of Server? 

For implementing observers, will it be sufficient to use an Observer design pattern and just "broadcast" from Server to all nodes?

Will there be any distinction between house players and participant players? Will house players have any advantage or particular behaviors?

How should the game handle when the Bank does not have enough pebbles to facilitate the trade? (Would it be a "lost move" on the player's part, would the player be able to select another trade?)

Will we need to implement a GUI or can we present the cards in text format? 

How can we select the number of star cards to deal? 

When players trade pebbles for a card from Ref, do those pebbles get deleted or added back to bank? 

Will house players' balances be cashed out to the Server's / Referee's balance after each game? 

What is a communication sign-up vs a logical sign-up?