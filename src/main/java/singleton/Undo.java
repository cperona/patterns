package singleton;

import java.util.ArrayList;
import java.util.List;

// Class using singleton pattern
public class Undo {
    private static Undo obj;

    private static List<String> commands;
    public void addCommand(String command) {
        commands.add(command);
    }
    public String undoLastCommand() {
        if (commands.isEmpty()) {
            return "Cannot remove last command. Empty history";
        }
        return commands.removeLast();
    }
    public void showHistory() {
        System.out.println("History:\n");
        System.out.println("----------------------\n");
        for (String i: commands) {
            System.out.println(i);
        }
    }

    private Undo() {}

    public static Undo getInstance() {
        if (obj == null) {
            obj = new Undo();
            commands = new ArrayList<>();
        }
        return obj;
    }
}