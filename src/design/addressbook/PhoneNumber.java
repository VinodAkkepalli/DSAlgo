package design.addressbook;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class PhoneNumber {
    String label;
    String phoneNumber;

    public PhoneNumber(String label, String phoneNumber) throws Exception {

        String regexNameLabel = "^[A-Za-z\\s]+$";
        String regexPhoneNumber = "\\d{10}";

        if(label.length() > 0 && label.length() < 256 && label.matches(regexNameLabel)){
            this.label = label;
        } else {
            throw new Exception("Phone label is not valid");
        }
        if(phoneNumber.matches(regexPhoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new Exception("Phone Number is not valid");
        }
    }

    public String getLabel() {
        return label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "label='" + label + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
