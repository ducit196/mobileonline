package core.dto.model.employee;

import core.dto.model.common.Account;
import core.dto.model.common.Address;
import core.dto.model.common.Person;
import core.dto.model.common.Role;

import java.util.Date;

/**
 * @author DucBa
 */
public class Employee extends Person{
    private int id;
    private Account account;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String firstName, String middleName, String lastName, Address address,
                    int gender, Date birthDay, String phone, int id, Account account) {
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

