package com.aby.repo;

import com.aby.model.Account;
import com.aby.web.AccountController;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByName(String name);
    List<Account> findByNumber(String number);
}
