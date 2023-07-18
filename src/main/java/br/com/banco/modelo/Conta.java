package br.com.banco.modelo;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

    public Conta(String nome) {
        this.nome = nome;
    }
}
