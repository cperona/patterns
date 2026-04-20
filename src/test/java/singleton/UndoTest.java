package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {

    // Tests that getInstance returns always the same object.
    @Test
    void testSingletonIdentity() {
        Undo instance1 = Undo.getInstance();
        Undo instance2 = Undo.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    // Tests that undoLastCommand returns always the last command
    @Test
    void testUndoLogic() {
        Undo undo = Undo.getInstance();
        undo.addCommand("git commit");
        undo.addCommand("git push");

        assertEquals("git push", undo.undoLastCommand());
        assertEquals("git commit", undo.undoLastCommand());
    }

    // Tests that undoLastCommand always returns an error message when the history is empty
    @Test
    void testUndoEmptyList() {
        Undo undo = Undo.getInstance();
        assertEquals("Cannot remove last command. Empty history", undo.undoLastCommand());
    }
}