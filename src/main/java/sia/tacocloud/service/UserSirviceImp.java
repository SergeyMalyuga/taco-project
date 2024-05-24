package sia.tacocloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sia.tacocloud.entyties.UserM;
import sia.tacocloud.repositories.UserRepository;

@Service
public class UserSirviceImp {


    @Autowired
    private UserRepository repository;


    @PreAuthorize(value = "hasRole('USER')")
    public UserM getUser(UserM userM) {
       return repository.findById(userM.getId()).orElseThrow(()  -> new RuntimeException());

    }
}
