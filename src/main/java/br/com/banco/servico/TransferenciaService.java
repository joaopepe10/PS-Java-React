package br.com.banco.servico;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public ResponseEntity<?> realizarOperacao(Transferencia t){
        return new ResponseEntity<>(transferenciaRepository.save(t), HttpStatus.CREATED);
    }

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(transferenciaRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> filtrarPorNome(String nome){
        return new ResponseEntity<>(transferenciaRepository.filtroPorNome(  nome), HttpStatus.OK);
    }

    public ResponseEntity<?> filtroPorPeriodo(LocalDate inicio, LocalDate fim){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(transferenciaRepository.findByDataBetween(s, f), HttpStatus.OK);
    }

    public ResponseEntity<?> filtroPorPeriodoNome(String nome, LocalDate inicio, LocalDate fim){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String tmz = "T00:00:00+03";
        String start = inicio.toString() + tmz;
        String end = fim.toString() + tmz;
        OffsetDateTime s = OffsetDateTime.parse(start);
        OffsetDateTime f = OffsetDateTime.parse(end);
        return new ResponseEntity<>(transferenciaRepository.findByNomeAndDataBetween(nome, s,f), HttpStatus.OK);
    }
}
