package singleton;

public class Main {
    public static void main() {
        Undo undo = Undo.getInstance();

        undo.addCommand("git status");
        undo.addCommand("git add .");
        undo.addCommand("git commit -m 'my commit'");
        undo.addCommand("git log");
        undo.addCommand("git push");

        undo.undoLastCommand();
        undo.showHistory();
    }
}