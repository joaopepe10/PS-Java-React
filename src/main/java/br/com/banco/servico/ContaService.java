package br.com.banco.servico;

import br.com.banco.modelo.Conta;
import br.com.banco.repositorio.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(contaRepository.findAll(), HttpStatus.OK);
    }
}
