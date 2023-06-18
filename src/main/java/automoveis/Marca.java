package automoveis;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome;
    }
    
}
