package br.com.banco.controle;

import br.com.banco.modelo.Transferencia;
import br.com.banco.servico.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/operacao")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;
    @PostMapping("/deposito")
    public ResponseEntity<?> operacao(@RequestBody Transferencia operacao){
        return transferenciaService.realizarOperacao(operacao);
    }

    @GetMapping("/")
    public ResponseEntity<?> listar(){
        return transferenciaService.listar();
    }

    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarPorNome(@RequestParam("name") String nome){
        return transferenciaService.filtrarPorNome(nome);
    }

    @GetMapping("/filtrar-periodo")
    public  ResponseEntity<?> filtrarPorPeriodo(
            @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate inicio,
            @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
            ){
        return transferenciaService.filtroPorPeriodo(inicio, fim);
    }

    @GetMapping("/filtrar-all")
    public ResponseEntity<?> filtrarPorNomePeriodo(
            @RequestParam("nome")String nome,
            @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate inicio,
            @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ){
        return transferenciaService.filtroPorPeriodoNome(nome, inicio, fim);
    }

}
