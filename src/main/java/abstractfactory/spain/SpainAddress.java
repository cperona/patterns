package abstractfactory.spain;

import abstractfactory.Address;

// Concrete Product
public class SpainAddress implements Address {
    private String street;
    private String city;
    private String postalCode;
    @Override
    public void setAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFormattedAddress() {
        return street + ", " + postalCode + " " + city;
    }

    @Override
    public String toString() {
        return getFormattedAddress();
    }
}