package br.com.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "conta")
public class Conta {
    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta", nullable = false)
    private Long id;

    @Column(name = "nome_responsavel", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "conta")
    @Column(nullable = false)
    private List<Transferencia> transferencias;



    //CONSTRUTORES
    public Conta() {
    }

    public Conta(String nome) {
        this.nome = nome;
    }

    public Conta(Long idConta, String nome) {
        this.id = idConta;
        this.nome = nome;
    }

}
