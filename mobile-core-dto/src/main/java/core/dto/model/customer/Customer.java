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

    public Customer(int id, String firstName, String middleName, String lastName, int gender, Date birthDay, String phone, Account account, Address address) {
        super(firstName, middleName, lastName, address, gender, birthDay, phone);
        this.id = id;
        this.account = account;
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
