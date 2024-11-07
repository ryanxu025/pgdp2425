package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Author {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date birthday;

    public Author(String firstName, String lastName, String address, String email, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
    }

    public boolean equals(Author other) {
        return  this.firstName.equals(other.getFirstName()) &&
                this.lastName.equals(other.getLastName()) &&
                this.address.equals(other.getAddress()) &&
                this.email.equals(other.getEmail()) &&
                this.birthday.equals(other.getBirthday());
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public String toPrintText() {
        return this.firstName + " " + this.lastName + "\n" +
                this.birthday + "\n" +
                this.address + "\n" +
                this.email + "\n";
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
