import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ContactRegister class is used to store and manage contacts.
 */
public class ContactRegister {
    private Map<String, Contact> register = new HashMap<>();
    private int numberOfContacts;

    private static final String API_KEY = "xrabsi_ywvbyys_186sgbs";


    /**
     * Adds a contact to the register.
     *
     * @param name  the name of the contact
     * @param phone the phone number of the contact
     * @param email the email of the contact
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
        for (String key : register.keySet()) {
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
        for (String key : register.keySet()) {
            if (Objects.equals(key, name)) {
                System.out.println("-------------------------------------");
                System.out.println("Name: " + register.get(key).getName());
                System.out.println("Email: " + register.get(key).getEmail());
                System.out.println("Phone Number: " + register.get(key).getPhoneNumber());
                System.out.println("-------------------------------------");
                return register.get(key);
            }
        }
        return null;
    }


    /**
     * Searches for a contact by name.
     *
     * @param phone the name of the contact
     * @return the found Contact, or null if not found
     */
    public Contact searchNumber(String phone) {
        for (String key : register.keySet()) {
            if (Objects.equals(register.get(key).getPhoneNumber(), phone)) {
                System.out.println("-------------------------------------");
                System.out.println("Name: " + register.get(key).getName());
                System.out.println("Email: " + register.get(key).getEmail());
                System.out.println("Phone Number: " + register.get(key).getPhoneNumber());
                System.out.println("-------------------------------------");
                return register.get(key);
            }
        }
        return null;
    }

    /**
     * Searches for a contact by name.
     *
     * @param email the name of the contact
     * @return the found Contact, or null if not found
     */
    public Contact searchMail(String email) {
        for (String key : register.keySet()) {
            if (Objects.equals(register.get(key).getEmail(), email)) {
                System.out.println("-------------------------------------");
                System.out.println("Name: " + register.get(key).getName());
                System.out.println("Email: " + register.get(key).getEmail());
                System.out.println("Phone Number: " + register.get(key).getPhoneNumber());
                System.out.println("-------------------------------------");
                return register.get(key);
            }
        }
        return null;
    }


    /**
     * Fetches the address of the contact with the given name.
     *
     * @param name the name of the contact
     */
    public String getContactAddress(String name) {

        try {
            URL url = new URL("https://api.example.com/getAddress?name=" + name);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("x-api-key", API_KEY);
            conn.setRequestMethod("GET");

            // Simulating API response handling
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }


                return response.toString();
            } else {
                System.out.println("API call failed with response code: " + responseCode);
                return "Address not available";
            }
        } catch (Exception e) {
            System.out.println("Error during API call: " + e.getMessage());
            return "Address not available";
        }

    }


    public static void main(String[] args) {
        ContactRegister reg = new ContactRegister();
        reg.addContact("John Doe", "1234567890", "johndoe@mail.com");
        reg.addContact("Jane Smith", "0987654321", "janesmith@mail.com");
    }


}
