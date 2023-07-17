package br.com.banco.modelo;

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
    private Long idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsavel;

    @OneToMany(mappedBy = "contaId")
    @Column(nullable = false)
    private List<Transferencia> transferencias;



    //CONSTRUTORES
    public Conta() {
    }

    public Conta(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Conta(Long idConta, String nomeResponsavel) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
    }

}
