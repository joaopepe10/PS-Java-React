package br.com.banco.config;


import br.com.banco.modelo.Conta;
import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.ContaRepository;
import br.com.banco.repositorio.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public void run(String... args) throws Exception {
        Conta c1 = new Conta("Fulano");
        Conta c2 = new Conta("Sicrano");
        contaRepository.saveAll(Arrays.asList(c1, c2));
        OffsetDateTime o1 = OffsetDateTime.of(2019,1,1,12,0,0,0, ZoneOffset.ofHours(3));
        OffsetDateTime o2 = OffsetDateTime.of(2019,2,3,9,53,27,0, ZoneOffset.ofHours(3));
        OffsetDateTime o3 = OffsetDateTime.of(2019,5,4,8,12,45,0, ZoneOffset.ofHours(3));
        OffsetDateTime o4 = OffsetDateTime.of(2019,8,7,8,12,45,0, ZoneOffset.ofHours(3));
        OffsetDateTime o5 = OffsetDateTime.of(2020,6,8,10,15,0,1, ZoneOffset.ofHours(3));
        OffsetDateTime o6 = OffsetDateTime.of(2021,4,1,12,12,0,4, ZoneOffset.ofHours(3));


        Transferencia t1 = new Transferencia(o1, 30895.46, "DEPOSITO", null, c1);
        Transferencia t2 = new Transferencia(o2, 12.24, "DEPOSITO", null, c2);
        Transferencia t3 = new Transferencia(o3, -500.5, "SAQUE", null, c1);
        Transferencia t4 = new Transferencia(o4, -530.5, "SAQUE", null, c2);
        Transferencia t5 = new Transferencia(o5, 3241.23, "TRANSFERENCIA", "Beltrano", c1);
        Transferencia t6 = new Transferencia(o6, 25173.09, "TRANSFERENCIA", "Ronnyscley", c2);
        transferenciaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));
    }
}
