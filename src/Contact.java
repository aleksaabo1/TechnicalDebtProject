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


    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber;
    }
}
