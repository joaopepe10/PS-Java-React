package br.com.banco.repositorio;

import br.com.banco.modelo.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    @Query(value = "select * from transferencia " +
            "where nome_operador_transacao = ?1", nativeQuery = true)
    List<Transferencia> filtroPorNome(String nome);

    List<Transferencia> findByNome(String nome);

    List<Transferencia> findByDataBetween(OffsetDateTime inicio, OffsetDateTime fim);


}
