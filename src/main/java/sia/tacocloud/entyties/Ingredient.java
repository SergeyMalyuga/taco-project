package sia.tacocloud.entyties;

import jakarta.persistence.*;
import lombok.*;


@Data
@Table
@Entity
@AllArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String id;
    private final String name;
    private final Type type;
}
