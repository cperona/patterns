package abstractfactory;

import abstractfactory.spain.SpainAddress;
import abstractfactory.spain.SpainContactFactory;
import abstractfactory.spain.SpainPhone;
import abstractfactory.usa.USAAddress;
import abstractfactory.usa.USAContactFactory;
import abstractfactory.usa.USAPhone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void testSpainFactoryCreatesSpainProducts() {
        ContactFactory factory = new SpainContactFactory("Carrer de Pallars 23", "Barcelona", "08034", "675432389");
        assertTrue(factory.getAddress() instanceof SpainAddress);
        assertTrue(factory.getPhone() instanceof SpainPhone);
    }

    @Test
    void testUSAFactoryCreatesUSAProducts() {
        ContactFactory factory = new USAContactFactory("154 5th Avenue", "New York", "NY 22345", "985727183");
        assertTrue(factory.getAddress() instanceof USAAddress);
        assertTrue(factory.getPhone() instanceof USAPhone);
    }

    @Test
    void testSpainAddressFormatting() {
        Address addr = new SpainAddress();
        addr.setAddress("Carrer de Pallars 23", "Barcelona", "08034");
        assertEquals("Carrer de Pallars 23, 08034 Barcelona", addr.getFormattedAddress());
    }

    @Test
    void testSpainPhoneFormatting() {
        Phone phone = new SpainPhone();
        phone.setPhoneNum("675432389");
        assertEquals("+34 675432389", phone.getFormattedPhoneNum());
    }

    @Test
    void testUSAAddressFormatting() {
        Address addr = new USAAddress();
        addr.setAddress("154 5th Avenue", "New York", "NY 22345");
        assertEquals("154 5th Avenue, New York, NY 22345", addr.getFormattedAddress());
    }

    @Test
    void testUSAPhoneFormatting() {
        Phone phone = new USAPhone();
        phone.setPhoneNum("985727183");
        assertEquals("+1 (09) 857-27183", phone.getFormattedPhoneNum());
    }
}