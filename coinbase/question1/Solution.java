import java.io.*;
import java.util.*;

public class Solution {

    public static class Node {
      private long time;
      private String state;
      public Node(long time, String state){
        this.time = time;
        this.state = state;
      }

      public String getState(){
        return state;
      }
    }
    public static class FiniteStateMachine {
        private final String[] validStates;
        // private final Map<String, Long> changedAt = new HashMap<>();
        private List<String> listOfStates;
        // Creating a Stack
        private Stack<Node> changedAt = new Stack<>();

        public FiniteStateMachine(String[] states) {
            this.validStates = states;
            // Convert String Array to List
            listOfStates = Arrays.asList(states);
            // init with a default state
            set(states[0]);

        }

        public void set(String state) {
            if (!listOfStates.contains(state)) {
                throw new IllegalArgumentException("Invalid state");
            }
            changedAt.push(new Node(System.currentTimeMillis(), state));
        }

        public boolean isState(String state) {
            if(!changedAt.empty()){
              Node temp = changedAt.peek();
              return temp.getState() == state;
            }
            return false;
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

