package starter.saucedemo.actors;

public enum Buyer {

    FULL_BUYER("Hanamishi", "Sakuragi", "54321");

    private final String firstName;
    private final String lastName;
    private final String zipCode;

    Buyer(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
