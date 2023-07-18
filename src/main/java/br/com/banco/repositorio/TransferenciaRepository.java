package br.com.banco.repositorio;

import br.com.banco.modelo.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByNome(String nome);
    List<Transferencia> findByDataBetween(OffsetDateTime inicio, OffsetDateTime fim);
    List<Transferencia> findByNomeAndDataBetween(String nome, OffsetDateTime inicio, OffsetDateTime fim);


}
