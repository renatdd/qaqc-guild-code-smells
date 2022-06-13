package org.qaqcguild;

public class Client {

    private final String firstName;
    private final String lastName;
    private final ClientPhone phone;
    private final ClientAddress address;

    public Client(String firstName, String lastName, ClientPhone phone, ClientAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientPhone getPhone() {
        return phone;
    }

    public ClientAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
