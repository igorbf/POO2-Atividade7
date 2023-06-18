package automoveis;

import javax.persistence.*;

@Entity
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int anoFabricacao;
    private int anoModelo;
    private String observacao;
    private float preco;
    private int kilometragem;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    public Automovel() {
    }

    public Automovel(int anoFabricacao, int anoModelo, String observacao, float preco, int kilometragem, Modelo modelo) {
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.observacao = observacao;
        this.preco = preco;
        this.kilometragem = kilometragem;
        this.modelo = modelo;
    }
}
