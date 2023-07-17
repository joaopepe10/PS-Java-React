package br.com.banco.servico;

import br.com.banco.modelo.Conta;
import br.com.banco.repositorio.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(contaRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorId(Long id){
        return new ResponseEntity<>(contaRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorId(Long id, LocalDate inicio, LocalDate fim){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(contaRepository.intervalo(id, s, f), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorNomeAndId(Long id,String nome) {
        return new ResponseEntity<>(contaRepository.findByIdAndNome(id, nome), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorPeriodo(LocalDate inicio, LocalDate fim){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(contaRepository.intervalo(s, f), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorNome(String nome) {
        return new ResponseEntity<>(contaRepository.findByNome(nome),HttpStatus.OK);
    }
}
