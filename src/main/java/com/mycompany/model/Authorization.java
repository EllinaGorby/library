package com.mycompany.model;

/**
 * This class represents an Authorization for a library system. It contains
 * information about login, password, and associated reader.
 *
 * @author: Ellina
 */
public class Authorization {

    private String login;
    private String pass;
    private Reader reader;

    /**
     * Constructor with parameters. Creates an Authorization with given login,
     * password, and associated reader.
     *
     * @param login Login for the authorization
     * @param pass Password for the authorization
     * @param reader Associated reader
     */
    public Authorization(String login, String pass, Reader reader) {
        this.login = login;
        this.pass = pass;
        this.reader = reader;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "login=" + login + ", pass=" + pass + " ";
    }

    public String toStringfull() {
        return "authorization{" + "login=" + login + ", pass=" + pass + ", reader=" + reader + '}';
    }

}
