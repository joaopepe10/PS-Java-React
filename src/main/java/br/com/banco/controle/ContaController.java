package br.com.banco.controle;

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

   @GetMapping("/")
   //LISTA TODAS AS CONTAS E SUAS RESPECTIVAS TRANSACOES
    public ResponseEntity<?> listar(){
       return contaService.listar();
   }

   @GetMapping("/id")
   //METODO DE FILTRAR CONTA POR ID E MOSTRAR TRANSACOES
    public ResponseEntity<?> listarPorId(@RequestParam("id")Long id){
       return contaService.listarPorId(id);
   }

}
