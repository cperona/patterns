package abstractfactory.spain;

import abstractfactory.Phone;

// Concrete Product
public class SpainPhone implements Phone {
    private String phoneNum;

    @Override
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String getFormattedPhoneNum() {
        return "+34 " + phoneNum;
    }

    @Override
    public String toString() {
        return getFormattedPhoneNum();
    }
}
