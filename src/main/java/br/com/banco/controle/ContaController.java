package br.com.banco.controlador;

import br.com.banco.modelo.Conta;
import br.com.banco.servico.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
   @Autowired
    private ContaService contaService;

   @GetMapping("/listar")
    public ResponseEntity<?> listar(){
       return contaService.listar();
   }

   @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Conta conta){
       return contaService.cadastrarConta(conta);
   }

}
