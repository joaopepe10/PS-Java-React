package br.com.banco.controle;

import br.com.banco.servico.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/operacao")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;

    //RETORNA TODAS AS TRANSFERENCIAS
    @GetMapping("/")
    public ResponseEntity<?> listar(){
        return transferenciaService.listar();
    }

    //FILTRA POR NOME DO OPERADOR
    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarPorNome(@RequestParam("name") String nome){
        return transferenciaService.filtrarPorNome(nome);
    }

    //FILTRA POR ID DA CONTA
    @GetMapping
    public ResponseEntity<?> filtrarPorId(@RequestParam("id")Long id){
        return transferenciaService.filtrarPorId(id);
    }

    @GetMapping("/filtrar-periodo")
    public  ResponseEntity<?> filtrarPorPeriodo(
            //URL DEVE SER TRATADA DA SEGUINTE FORMA localhost:8080/operacao/filtrar-periodo?inicio=inicio&fim=fim
            @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate inicio,
            @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
            ){
        return transferenciaService.filtroPorPeriodo(inicio, fim);
    }

    @GetMapping("/filtrar-all")
    public ResponseEntity<?> filtrarPorNomePeriodo(
            //URL DEVE SER TRATADA DA SEGUINTE FORMA localhost:8080/operacao/filtrar-all?nome=nome&inicio=inicio&fim=fim
            @RequestParam("nome")String nome,
            @RequestParam("inicio")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate inicio,
            @RequestParam("fim")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ){
        return transferenciaService.filtroPorPeriodoNome(nome, inicio, fim);
    }

}
