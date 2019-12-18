package com.keith.president.inject;

import com.cards.IDeck;
import com.cards.StandardDeck;
import com.google.inject.AbstractModule;

public class PresidentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IDeck.class).to(StandardDeck.class);
    }
}
