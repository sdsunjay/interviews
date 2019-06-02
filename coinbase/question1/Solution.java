import java.io.*;
import java.util.*;

public class Solution {

    public static class FiniteStateMachine {
        private final String[] validStates;
        private final Map<String, Long> changedAt = new HashMap<>();
        private List<String> listOfStates;

        public FiniteStateMachine(String[] states) {
            this.validStates = states;
              // Convert String Array to List
            listOfStates = Arrays.asList(states);
            set(states[0]);

            // init with a default state
        }

        public void set(String state) {
            if (!listOfStates.contains(state)) {
                throw new IllegalArgumentException("Invalid state");
            }
            changedAt.put(state, System.currentTimeMillis());
        }

        public boolean isState(String state) {
            Long time = changedAt.get(state);
            //time <= System.currentTimeMillis();
            // check with Stack
            return changedAt.containsKey(state);
        }
    }

    public static void assertTrue(boolean value, String message) {
        if (!value) {
            throw new IllegalStateException(message);
        }
    }

    public static void main(String[] args) {
        // bug #1: state machine should be initialized with an initial state
        String[] validStates = { "started", "in_progress", "completed", "failed" };
        FiniteStateMachine stateMachine = new FiniteStateMachine(validStates);
        assertTrue(stateMachine.isState("started"), "Expected FSM to be in state: 'started'");

        // bug #2: state machine should only be in one state at once
        stateMachine.set("in_progress");
        assertTrue(stateMachine.isState("in_progress"), "Expected FSM to be in state: 'in_progress'");
        assertTrue(!stateMachine.isState("started"), "Expected FSM to have a single state");

        System.out.println("Success!");
    }
}

