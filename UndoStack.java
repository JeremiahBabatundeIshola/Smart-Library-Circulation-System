package model;

import java.util.Stack;

public class UndoStack {

    private Stack<String> actions;

    public UndoStack() {
        actions = new Stack<>();
    }

    public void addAction(String action) {
        actions.push(action);
    }

    public void undoLastAction() {
        if (!actions.isEmpty()) {
            System.out.println("Undo: " + actions.pop());
        } else {
            System.out.println("No action to undo");
        }
    }
}