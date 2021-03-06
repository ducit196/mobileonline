package core.dao.common;

import core.dto.model.common.Account;

import java.util.List;

public interface AccountDao {
    void insert(Account account);

    List<Account> getAll();

    Account getById(int id);

    Account login(Account account);

}
