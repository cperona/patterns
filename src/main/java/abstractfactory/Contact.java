package abstractfactory;

// Client
public class Contact {
    private Address address;
    private Phone phone;
    public Contact(ContactFactory contactFactory) {
        this.address = contactFactory.getAddress();
        this.phone = contactFactory.getPhone();
    }

    @Override
    public String toString() {
        return "address: " + address + " | phone: " + phone;
    }
}