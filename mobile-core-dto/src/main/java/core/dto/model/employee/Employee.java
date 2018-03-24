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

    public Employee(String firstName, String middleName, String lastName, Address address, int gender, Date birthDay, int id) {
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

