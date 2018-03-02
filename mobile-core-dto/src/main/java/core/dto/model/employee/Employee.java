package core.dto.model.employee;

import core.dto.model.common.Account;
import core.dto.model.common.Person;
import core.dto.model.common.Role;

/**
 * @author DucBa
 */
public class Employee extends Person{
    private long id;
    private Account account;

    public Employee() {
    }

    public Employee(long id, Account account) {
        this.id = id;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

