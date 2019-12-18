package com.keith.president;

import com.cards.IDeck;
import com.cards.IPlayer;
import com.cards.PlayerManager;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private PlayerManager playerManager;
    private IDeck deck;
    private List<IPlayer> players;

    @Inject
    public GameManager(PlayerManager playerManager, IDeck deck) {
        this(playerManager, deck, new ArrayList<>());
    }

    public GameManager(PlayerManager playerManager, IDeck deck, ArrayList<IPlayer> players) {
        this.playerManager = playerManager;
        this.deck = deck;
        this.players = players;
    }

    public void launch() {
        initPlayers();
        deal();
    }

    public void initPlayers() {
        // TODO query for player count
        players.add(playerManager.addPlayer());
        players.add(playerManager.addPlayer());
        players.add(playerManager.addPlayer());
        players.add(playerManager.addPlayer());
    }

    public void deal() {
        deck.shuffleDeck();
        for (int i = 0; !deck.isEmpty(); i++) {
            IPlayer playerToReceiveCard = players.get(i % 4);
            playerToReceiveCard.giveCard(deck.deal());
        }
    }
}
