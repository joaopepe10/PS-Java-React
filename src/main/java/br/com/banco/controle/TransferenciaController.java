package br.com.banco.controle;

import br.com.banco.modelo.Transferencia;
import br.com.banco.servico.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/operacao")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;
    @PostMapping("/deposito")
    public ResponseEntity<?> operacao(@RequestBody Transferencia operacao){
        return transferenciaService.realizarOperacao(operacao);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return transferenciaService.listar();
    }

    @GetMapping("/filtrar/{nome}")
    public ResponseEntity<?> filtrar(@PathVariable String nome){
        return transferenciaService.filtrar(nome);
    }


}
