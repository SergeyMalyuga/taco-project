package sia.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.entyties.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
