import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents a contact with a name and phone number.
 *
 * @version 1.0
 */
public class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact() {
        this.name = "Default Name";
        this.phoneNumber = "0000000000";
        this.email = "example@mail.com";
    }

    public Contact(String name, String email, String phone_number) {
        this.name = name;
        this.email = email;
        if (phone_number.matches("\\d{10}")){
            this.phoneNumber = phone_number;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber.matches("\\d{10}")){
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Reads the contacts from a file and adds them to the register.
     * @return true if the file was read successfully, false otherwise
     */
    public boolean doAction() {
        ContactRegister contactRegister = new ContactRegister();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String phone = parts[1];
                    String email = parts[2];
                    contactRegister.addContact(name, phone, email);
                } else {

                    System.out.println("Invalid contact format: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber;
    }
}
