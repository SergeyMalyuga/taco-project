package sia.tacocloud.entyties;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    @ManyToMany()
    @JoinTable(name = "Ingredient_Ref",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "taco_id"))
    private List<Taco> tacos;
    @Enumerated(EnumType.STRING)
    private final Type type;
}
