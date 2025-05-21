package org.put.common.match;

import org.put.common.contestant.Contestant;

/**
 * Strategy interface for determining the outcome of a match.
 * Implementations should provide sport-specific logic to decide the winner or a draw
 * based on the provided {@link Result}.
 */
public interface OutcomeStrategy {
    Contestant decideOutcome(Result result);
}