package org.put.contest.match;

import java.util.List;
import org.put.contest.events.*;

public abstract class Match {

    private List<Event> events;

    // Template method

    public abstract void start();

    public abstract void stop();

    public abstract void finish();
}
