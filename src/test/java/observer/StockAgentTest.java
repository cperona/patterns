package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StockAgentTest {

    private StockAgent agent;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        agent = new StockAgent();
        // Redirect System.out to capture output in tests
        System.setOut(new PrintStream(outputCaptor));
    }

    // ─── Helpers ────────────────────────────────────────────────────────────────

    private String capturedOutput() {
        return outputCaptor.toString().trim();
    }

    private void resetOutput() {
        outputCaptor.reset();
    }

    // ─── Subscription Tests ────────────────────────────────────────────────────

    @Test
    void testAddSingleObserverReceivesNotification() {
        Observer broker1 = new StockBrokerAgency("Broker 1");
        agent.addObserver(broker1);

        agent.stockMarketUp(100.00);

        assertTrue(capturedOutput().contains("Broker 1 received notification:"));
    }

    @Test
    void testAddMultipleObserversAllReceiveNotification() {
        Observer broker1 = new StockBrokerAgency("Broker 1");
        Observer broker2 = new StockBrokerAgency("Broker 2");
        agent.addObserver(broker1);
        agent.addObserver(broker2);

        agent.stockMarketUp(150.75);

        String output = capturedOutput();
        assertTrue(output.contains("Broker 1 received notification:"));
        assertTrue(output.contains("Broker 2 received notification:"));
    }

    // ─── Main Exercise Test ────────────────────────────────────────────

    @Test
    void testStockAgentNotifications() {
        Observer broker1 = new StockBrokerAgency("Broker 1");
        Observer broker2 = new StockBrokerAgency("Broker 2");

        agent.addObserver(broker1);
        agent.addObserver(broker2);

        // Simulate market up
        agent.stockMarketUp(150.75);
        String outputUp = capturedOutput();

        assertEquals(
            "Broker 1 received notification: Stock market went UP to 150.75\n" +
            "Broker 2 received notification: Stock market went UP to 150.75",
            outputUp
        );

        resetOutput();

        // Simulate market down
        agent.stockMarketDown(145.50);
        String outputDown = capturedOutput();

        assertEquals(
            "Broker 1 received notification: Stock market went DOWN to 145.50\n" +
            "Broker 2 received notification: Stock market went DOWN to 145.50",
            outputDown
        );
    }

    // ─── Market Up and Down Tests ───────────────────────────────────────────────

    @Test
    void testStockMarketUpMessage() {
        agent.addObserver(new StockBrokerAgency("Broker 1"));

        agent.stockMarketUp(200.50);

        assertEquals(
            "Broker 1 received notification: Stock market went UP to 200.50",
            capturedOutput()
        );
    }

    @Test
    void testStockMarketDownMessage() {
        agent.addObserver(new StockBrokerAgency("Broker 1"));

        agent.stockMarketDown(180.25);

        assertEquals(
            "Broker 1 received notification: Stock market went DOWN to 180.25",
            capturedOutput()
        );
    }

    @Test
    void testMultipleUpAndDownEvents() {
        agent.addObserver(new StockBrokerAgency("Broker 1"));

        agent.stockMarketUp(300.00);
        agent.stockMarketDown(290.00);
        agent.stockMarketUp(310.00);

        String output = capturedOutput();
        assertTrue(output.contains("UP to 300.00"));
        assertTrue(output.contains("DOWN to 290.00"));
        assertTrue(output.contains("UP to 310.00"));
    }

    // ─── Unsubscription Tests ────────────────────────────────────

    @Test
    void testRemoveObserverNoLongerReceivesNotification() {
        Observer broker1 = new StockBrokerAgency("Broker 1");
        Observer broker2 = new StockBrokerAgency("Broker 2");
        agent.addObserver(broker1);
        agent.addObserver(broker2);

        agent.removeObserver(broker1);
        agent.stockMarketUp(150.00);

        String output = capturedOutput();
        assertFalse(output.contains("Broker 1"));
        assertTrue(output.contains("Broker 2"));
    }

    @Test
    void testRemoveNonSubscribedObserverDoesNotThrow() {
        Observer broker1 = new StockBrokerAgency("Broker 1");
        assertDoesNotThrow(() -> agent.removeObserver(broker1));
    }

    @Test
    void testNoObserversNoOutput() {
        agent.stockMarketUp(100.00);
        assertEquals("", capturedOutput());
    }

    // ─── Validation Tests ──────────────────────────────────────────────────────

    @Test
    void testAddNullObserverThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> agent.addObserver(null));
    }

    @Test
    void testStockBrokerAgencyEmptyNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new StockBrokerAgency(""));
        assertThrows(IllegalArgumentException.class, () -> new StockBrokerAgency("   "));
        assertThrows(IllegalArgumentException.class, () -> new StockBrokerAgency(null));
    }
}
