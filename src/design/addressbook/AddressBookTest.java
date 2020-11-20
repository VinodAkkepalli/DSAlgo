package design.addressbook;

import java.util.List;

/**
 * <b>Description</b> : Driver class to test Addressbook implementation
 * Read through ProblemStatement.md for detailed description of the problem
 *
 * @author Vinod Akkepalli
 */
public class AddressBookTest {

    public static void main(String[] args) throws Exception {

        AddressBook addressBook = new AddressBook();
        addressBook.addContact(new Contact("Vinod", "orgA",
                List.of(new PhoneNumber("mobile", "1234567890"),
                        new PhoneNumber("home", "2345678901")),
                List.of(new Address("home", "home address"),
                        new Address("office", "office address"))));

        System.out.println("Search by name 'Vinod': " + addressBook.searchByName("Vinod"));


        addressBook.addContact(new Contact("Vinay", "orgB",
                List.of(new PhoneNumber("mobile", "1234567899"),
                        new PhoneNumber("home", "2345678902")),
                List.of(new Address("home", "home address"),
                        new Address("office", "office address"))));

        System.out.println("Search by name 'Vinay': " + addressBook.searchByName("Vinay"));
        System.out.println("Search by organization 'orgB': " + addressBook.searchByOrganization("orgB"));

        System.out.println("Search by name 'Vin': " + addressBook.searchByName("Vin"));
        System.out.println("Search by organization 'org': " + addressBook.searchByOrganization("org"));

        addressBook.deleteContact("Vinay");
        System.out.println("Search by name 'Vinay': " + addressBook.searchByName("Vinay"));
        System.out.println("Search by organization 'orgB': " + addressBook.searchByOrganization("orgB"));

        addressBook.updateContact("Vinod", new Contact("Vinod", "orgC",
                List.of(new PhoneNumber("mobile", "1234567890"),
                        new PhoneNumber("home", "2345678901")),
                List.of(new Address("home", "home address"),
                        new Address("office", "office address"))));

        System.out.println("Search by name 'Vinod': " + addressBook.searchByName("Vinod"));
        System.out.println("Search by organization 'orgC': " + addressBook.searchByOrganization("orgC"));
    }
}
