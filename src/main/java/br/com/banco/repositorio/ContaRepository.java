package br.com.banco.repositorio;

import br.com.banco.modelo.Conta;
import br.com.banco.modelo.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByIdAndNome(Long id, String nome);
    Conta findByNome(String nome);
    @Query(
            value = "SELECT t FROM Conta c JOIN c.transferencias t WHERE t.data BETWEEN ?1 AND ?2"
    )

    List<Transferencia> intervalo(OffsetDateTime inicio, OffsetDateTime fim);

    @Query(
            value = "SELECT t FROM Conta c JOIN c.transferencias t WHERE c.id = ?1 AND t.data BETWEEN ?2 AND ?3"
    )

    List<Transferencia> intervalo(Long id, OffsetDateTime inicio, OffsetDateTime fim);
}
