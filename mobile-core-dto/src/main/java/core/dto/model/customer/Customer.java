package core.dto.model.customer;

import core.dto.model.common.*;

import java.util.Date;

/**
 * @author DucBa
 */
public class Customer extends Person {
    private int id;
    private Account account;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String firstName, String middleName, String lastName, Address address, int gender, Date birthDay, int id) {
        super(firstName, middleName, lastName, address, gender, birthDay);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
