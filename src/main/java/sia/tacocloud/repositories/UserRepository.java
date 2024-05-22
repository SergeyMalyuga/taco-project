package sia.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.entyties.UserM;

public interface UserRepository extends CrudRepository<UserM, Long> {
    UserM findByUsername(String username);
}
