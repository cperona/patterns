package abstractfactory.spain;

import abstractfactory.Address;
import abstractfactory.ContactFactory;
import abstractfactory.Phone;

// Concrete Factory
public class SpainContactFactory implements ContactFactory {
    private Address address;
    private Phone phone;

    public SpainContactFactory(String street, String city, String postalCode, String phoneNum) {
        this.address = new SpainAddress();
        this.address.setAddress(street, city, postalCode);

        this.phone = new SpainPhone();
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