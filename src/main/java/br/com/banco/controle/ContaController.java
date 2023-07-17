package br.com.banco.controle;

import br.com.banco.modelo.Conta;
import br.com.banco.servico.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/id/{id}")
    //METODO DE FILTRAR CONTA POR ID E MOSTRAR TRANSACOES
    public ResponseEntity<?> listarPorId(@PathVariable("id")Long id){
        return contaService.listarPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> listarPorNome(@PathVariable("nome")String nome){
       return contaService.listarPorNome(nome);
    }

    @GetMapping("/id/{id}/")
    //FAZ A FILTRAGEM DE ACORDO COM O ID DO USUARIO E O PERIODO DE TEMPO
    //localhost:8080/conta/id/1/?inicio=2019-01-01&fim=2029-02-08
    public ResponseEntity<?> listarPorId(@PathVariable("id")Long id,
                                         @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                                         @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){
        return contaService.listarPorId(id);
    }

   @GetMapping("/id/{id}/nome")
    public ResponseEntity<?> listarPorNome(
            @PathVariable("id")Long id,
            @RequestParam("name")String nome){
       return contaService.listarPorNomeAndId(id, nome);
   }

   @GetMapping("/periodo")
    public ResponseEntity<?> listarPorPeriodo(
           @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
           @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
   ){
       return contaService.listarPorPeriodo(inicio, fim);
   }

}
