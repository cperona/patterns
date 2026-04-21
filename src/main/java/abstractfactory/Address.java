package abstractfactory;

// Abstract Product
public interface Address {
    void setAddress(String street, String city, String postalCode);
    String getFormattedAddress();
}
