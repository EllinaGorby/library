
package com.mycompany.model;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Ellina
 * The Reader class represents a reader in a library.
 * 
 * It stores information such as reader ID, first name, last name, birthday,
 * and authorization credentials for login.
 * 
 * The class also provides methods for generating random reader information,
 * displaying readers with their authorization information
 * 
 */
public class Reader {
    private int idReader;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Authorization logPass;
    
    private boolean  administrator = false;

    public Reader() {
    
    }
 
    public Reader(int idReader, String firstName, String lastName, LocalDate Birthday) {
        this.idReader = idReader;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = Birthday;
        logPass = new Authorization(firstName +" "+ lastName, "123", this);
       
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(Date Birthday) {
        this.birthday = birthday;
    }
    
    public String getLogin() {
        return logPass.getLogin();
    }
    public String getPass() {
        return logPass.getPass();
    }

    @Override
    public String toString() {
        return  "id: " + idReader + ", " + firstName + " " + lastName + ", " + birthday ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idReader;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reader other = (Reader) obj;
        return this.idReader == other.idReader;
    }
    
    /**
     * Generates random reader information using the Faker library.
     * 
     * @return The generated Reader object.
     */
    public Reader generateReader() {
        Faker f = new Faker();
        firstName = f.address().firstName();
        lastName = f.address().lastName();
        birthday = f.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        logPass = new Authorization(firstName +" "+ lastName, "123", this);
        
        return this;
    }
    public String showReadersWithAuthorization() {
        return  "id " + idReader + ": " + logPass;
    }
    
}
