package com.example.services;

import com.example.dto.UserAccountDTO;
import com.example.entitys.UserAccount;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Osvaldo on 7/28/2016.
 */
@Service
public class UserService {
    private UserRepository repository;
    UserAccountDTO userAccountDTO;


    public UserService(UserRepository repository) {
        this.repository = repository;
        userAccountDTO = new UserAccountDTO();
    }

    public boolean login(String name, String passsword) {
        return getUser(name) != null ? getUser(name).getPassword().equals(passsword) : false;
    }

    public UserAccount getUser(String name) {
        return repository.findByName(name);
    }

    public String findUser(String name) {
        return userAccountDTO.getJsonUsserAccount(getUser(name));
    }

    public String getJsonUserAccoutn(UserAccount userAccount) {
        return userAccountDTO.getJsonUsserAccount(userAccount);
    }


    public void save(UserAccount userAccount) {
        repository.save(userAccount);
    }
}
