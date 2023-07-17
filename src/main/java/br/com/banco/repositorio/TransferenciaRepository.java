package br.com.banco.repositorio;

import br.com.banco.modelo.Transferencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Long> {
}
