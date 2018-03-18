package core.dao.common;

import core.dto.model.common.Account;

import java.util.List;

public interface AccountDao {
    void insert(Account account);

    void update(Account account);

    void delete(long id);

    List<Account> getAll();

    List<Account> getById(long id);

    Account login(Account account);

}
