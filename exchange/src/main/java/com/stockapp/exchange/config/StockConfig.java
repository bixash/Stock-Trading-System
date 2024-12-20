package com.stockapp.exchange.config;

import com.stockapp.exchange.models.Stock;
import com.stockapp.exchange.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Configuration
public class StockConfig {

    @Bean("StockConfig")
    CommandLineRunner commandLineRunner (StockRepository stockRepository){
        return args ->  {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            stockRepository.saveAll(
                    List.of(
                    new Stock("LEAF",
                            formatter.format(LocalTime.now()),
                            LocalDate.now().toString(),
                            110,
                            120,
                            120,
                            120,
                            110,
                            1,
                            120,
                            10,
                            9.09f,
                            1,
                            1,
                            110),
                    new Stock("FONE",
                            formatter.format(LocalTime.now()),
                            LocalDate.now().toString(),
                            110,
                            110,
                            110,
                            110,
                            110,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            110),
                    new Stock("YCO",
                            formatter.format(LocalTime.now()),
                            LocalDate.now().toString(),
                            50,
                            53,
                            53,
                            53,
                            50,
                            1,
                            53,
                            3,
                            6,
                            1,
                            1,
                            50),
                    new Stock("META",
                            formatter.format(LocalTime.now()),
                            LocalDate.now().toString(),
                            500,
                            495,
                            495,
                            500,
                            495,
                            1,
                            495,
                            -5,
                            -1f,
                            1,
                            1,
                            500),
                    new Stock("NESDO",
                            formatter.format(LocalTime.now()),
                            LocalDate.now().toString(),
                            100,
                            0,
                            100,
                            100,
                            100,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            100),
                            new Stock("GOOGL",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    1000,
                                    999,
                                    999,
                                    1000,
                                    999,
                                    1,
                                    999,
                                    -1,
                                    -0.1f,
                                    1,
                                    1,
                                    1000),
                            new Stock("HDL",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("MSFT",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("NCELL",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("NTC",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("FUSE",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("BHOOS",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100),
                            new Stock("NICA",
                                    formatter.format(LocalTime.now()),
                                    LocalDate.now().toString(),
                                    100,
                                    0,
                                    100,
                                    100,
                                    100,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    100)

                    )

            );

        };
    }
}
