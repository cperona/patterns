package abstractfactory;

import abstractfactory.spain.SpainContactFactory;
import abstractfactory.usa.USAContactFactory;

public class Main {
    public static void main() {
        // Spain
        ContactFactory spainContactFactory = new SpainContactFactory("Carrer de Pallars 23", "Barcelona", "08034", "675432389");
        Contact spainContact = new Contact(spainContactFactory);
        System.out.println(spainContact.toString());

        //USA
        ContactFactory usaContactFactory = new USAContactFactory("154 5th Avenue", "New York", "NY 22345", "985727183");
        Contact usaContact = new Contact(usaContactFactory);
        System.out.println(usaContact.toString());
    }
}
