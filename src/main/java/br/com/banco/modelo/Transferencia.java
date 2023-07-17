package br.com.banco.modelo;

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
    private OffsetDateTime dataTransferencia;

    @Column(columnDefinition = "NUMERIC (20,2) NOT NULL")
    private Double valor;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String tipo;

    @Column(columnDefinition = "VARCHAR (50)")
    private String nomeOperadorTransacao;


    @ManyToOne
    @JoinColumn(name = "conta_id", columnDefinition = "INT NOT NULL", referencedColumnName = "id_conta")
    private Conta contaId;


    //CONTRUTORES
    public Transferencia() {
    }

    public Transferencia(OffsetDateTime dataTransferencia, Double valor, String tipo, String nomeOperadorTransacao, Conta contaId) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.contaId = contaId;
    }

    public Transferencia(Long id, OffsetDateTime dataTransferencia, Double valor, String tipo, String nomeOperadorTransacao, Conta contaId) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.contaId = contaId;
    }
}
