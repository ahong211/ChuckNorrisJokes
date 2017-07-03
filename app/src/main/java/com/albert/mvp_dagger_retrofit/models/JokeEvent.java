package com.albert.mvp_dagger_retrofit.models;

/**
 * Created by Albert on 7/3/17.
 */

public class JokeEvent {
    private int eventCode;
    private String jokeString;

    public JokeEvent(int eventCode, String jokeString) {
        this.eventCode = eventCode;
        this.jokeString = jokeString;
    }

    public int getEventCode() {
        return eventCode;
    }

    public String getJokeString() {
        return jokeString;
    }
}
