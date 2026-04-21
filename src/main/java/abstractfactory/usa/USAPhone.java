package abstractfactory.usa;

import abstractfactory.Phone;

// Concrete Product
public class USAPhone implements Phone {
    private String phoneNum;

    @Override
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String getFormattedPhoneNum() {
        return  "+1 " + "(0"+ phoneNum.charAt(0) + phoneNum.charAt(1) + ") " + phoneNum.charAt(2) + phoneNum.charAt(3) + phoneNum.charAt(4) + "-" + phoneNum.substring(5);
    }

    @Override
    public String toString() {
        return getFormattedPhoneNum();
    }
}
