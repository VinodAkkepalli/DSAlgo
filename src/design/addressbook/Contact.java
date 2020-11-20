package design.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class Contact {
    String name;
    String organization;
    List<PhoneNumber> phoneNumbers;
    List<Address> addresses;

    public Contact(String name, String organization,
                   List<PhoneNumber> phoneNumbers, List<Address> addresses) throws Exception {

        String regexNameLabel = "^[A-Za-z\\s]+$";

        if(name.length() > 0 && name.length() < 256 && name.matches(regexNameLabel)){
            this.name = name;
        } else {
            throw new Exception("Contact name is not valid");
        }

        if(organization.length() > 255) {
            throw new Exception("Contact organization name is not valid");
        }

        this.organization = organization;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if(this.phoneNumbers == null) {
            this.phoneNumbers = new ArrayList<>();
        }
        this.phoneNumbers.add(phoneNumber);
    }

    public void addAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                Objects.equals(organization, contact.organization) &&
                Objects.equals(phoneNumbers, contact.phoneNumbers) &&
                Objects.equals(addresses, contact.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, organization, phoneNumbers, addresses);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", addresses=" + addresses +
                '}';
    }
}
