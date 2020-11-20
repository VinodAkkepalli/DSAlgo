package design.addressbook;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class Address {

    String label;
    String address;

    public Address(String label, String address) throws Exception {
        String regexNameLabel = "^[A-Za-z\\s]+$";

        if(label.length() > 0 && label.length() < 256 && label.matches(regexNameLabel)){
            this.label = label;
        } else {
            throw new Exception("Address label is not valid");
        }

        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "label='" + label + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
