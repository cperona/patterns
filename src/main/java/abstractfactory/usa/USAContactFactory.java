package abstractfactory.usa;

import abstractfactory.Address;
import abstractfactory.ContactFactory;
import abstractfactory.Phone;

// Concrete Factory
public class USAContactFactory implements ContactFactory {
    private Address address;
    private Phone phone;

    public USAContactFactory(String street, String city, String postalCode, String phoneNum) {
        this.address = new USAAddress();
        this.address.setAddress(street, city, postalCode);

        this.phone = new USAPhone();
        this.phone.setPhoneNum(phoneNum);
    }
    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Phone getPhone() {
        return this.phone;
    }
}
