package br.com.banco.servico;

import br.com.banco.repositorio.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ResponseEntity<?> listarTodasContas(){
        return new ResponseEntity<>(contaRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorIdEInicioFim(Long id){
        return new ResponseEntity<>(contaRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorIdEInicioFim(Long id, LocalDate inicio, LocalDate fim){
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(contaRepository.findByBetween(id, s, f), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorNomeEId(Long id, String nome) {
        return new ResponseEntity<>(contaRepository.findByIdAndNome(id, nome), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorPeriodo(LocalDate inicio, LocalDate fim){
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(contaRepository.findByBetween(s, f), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorNome(String nome) {
        return new ResponseEntity<>(contaRepository.findByNome(nome),HttpStatus.OK);
    }
}
