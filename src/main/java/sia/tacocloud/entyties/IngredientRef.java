package sia.tacocloud.entyties;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class IngredientRef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private final String ingredient;
}
