package sia.tacocloud.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.entyties.Taco;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    List<Taco> findAll(Pageable pageable);
}
