package br.com.banco.servico;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
