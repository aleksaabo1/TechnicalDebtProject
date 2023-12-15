import java.util.HashMap;
import java.util.Map;

/**
 * ContactRegister class is used to store and manage contacts.
 */
public class ContactRegister {
    private Map<String, Contact> register = new HashMap<>();
    private int numberOfContacts;

    /**
     * Adds a contact to the register.
     *
     * @param name  the name of the contact
     * @param phone the phone number of the contact
     * @param email the email of the contact
     *
     */
    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        if (!phone.matches("\\d{10}")) {
            System.out.println("Invalid phone number");
            return;
        }
        if (register.containsKey(name)) {
            updateContact(name, phone, email);
        } else {
            register.put(name, contact);
        }
    }

    /**
     * Prints the contact with the given name.
     *
     * @param name the name of the contact
     */
    public void updateContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        register.put(name, contact);
    }

    public void deleteContact(String name) {
        register.remove(name);
    }

    public void refreshDatabase() {
        for(String key : register.keySet()) {
            System.out.println("-------------------------------------");
            System.out.println("Name: " + register.get(key).getName());
            System.out.println("Email: " + register.get(key).getEmail());
            System.out.println("Phone Number: " + register.get(key).getPhoneNumber());
            System.out.println("-------------------------------------");
        }
    }


    /**
     * Searches for a contact by name.
     *
     * @param name the name of the contact
     * @return the found Contact, or null if not found
     */
    public Contact searchContact(String name) {
        if (register.containsKey(name)) {
            Contact contact = register.get(name);
            // Replicating some logic from updateContact
            System.out.println("Found Contact: " + contact);
            return contact;
        } else {
            // Replicating logic from addContact
            System.out.println("Contact not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        ContactRegister reg = new ContactRegister();
        reg.addContact("John Doe", "1234567890", "johndoe@mail.com");
        reg.addContact("Jane Smith", "0987654321", "janesmith@mail.com");
    }


}
