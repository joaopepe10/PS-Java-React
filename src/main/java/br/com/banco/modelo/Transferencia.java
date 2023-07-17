package br.com.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "transferencia")
public class Transferencia {
    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "data_transferencia", columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
    private OffsetDateTime data;

    @Column(columnDefinition = "NUMERIC (20,2) NOT NULL")
    private Double valor;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String tipo;

    @Column(columnDefinition = "VARCHAR (50)", name = "nome_operador_transacao")
    private String nome;


    @ManyToOne
    @JoinColumn(name = "conta_id", columnDefinition = "INT NOT NULL")
    @JsonIgnore
    private Conta conta;


    //CONTRUTORES
    public Transferencia() {
    }

    public Transferencia(OffsetDateTime dataTransferencia, Double valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        this.data = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nome = nomeOperadorTransacao;
        this.conta = conta;
    }

    public Transferencia(Long id, OffsetDateTime data, Double valor, String tipo, String nome, Conta conta) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.nome = nome;
        this.conta = conta;
    }
}
