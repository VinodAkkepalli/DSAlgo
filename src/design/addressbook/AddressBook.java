package design.addressbook;

import java.util.List;

/**
 * <b>Description</b> : Addressbook implementation
 * Read through ProblemStatement.md for detailed description of the problem
 *
 * @author Vinod Akkepalli
 */
public class AddressBook {
    Trie<Contact> contactNameTrie = new Trie<>();
    Trie<Contact> organizationTrie = new Trie<>();

    public void addContact(Contact contact) throws Exception {
        if(!contactNameTrie.look(contact.getName()).isEmpty()) {
            throw new Exception("Contact is already present in Address book");
        }
        contactNameTrie.insert(contact.getName(), contact);
        organizationTrie.insert(contact.getOrganization(), contact);
    }

    public List<Contact> searchByName(String name) {
        return contactNameTrie.search(name);
    }

    public List<Contact> searchByOrganization(String organization) {
        return organizationTrie.search(organization);
    }

    public void updateContact(String name, Contact contact) throws Exception {
        List<Contact> contactList = contactNameTrie.look(name);
        if(contactList.isEmpty()){
            throw new Exception("given contact name not found");
        }
        deleteContact(name);
        addContact(contact);
    }

    public void deleteContact(String name) throws Exception {
        List<Contact> contactList = contactNameTrie.look(name);
        if(contactList.isEmpty()) {
            throw new Exception("No such contact exists");
        }
        contactList.forEach(contact -> {
            contactNameTrie.delete(contact.getName(), contact);
            organizationTrie.delete(contact.getOrganization(), contact);
        });
    }


}
