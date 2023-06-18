package automoveis;

import javax.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private int potencia;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String descricao, int potencia, Marca marca) {
        this.descricao = descricao;
        this.potencia = potencia;
        this.marca = marca;
    }
    
}
