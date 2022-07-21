package livecoding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Sample03 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        var arquivoJson = new File("faturamentos_2.json");

        objectMapper
                //.writerWithDefaultPrettyPrinter()
                .writeValue(
                        arquivoJson,
                        List.of(
                                new Faturamento(LocalDate.now(), BigDecimal.valueOf(100.0)),
                                new Faturamento(LocalDate.now(), BigDecimal.valueOf(50.0)),
                                new Faturamento(LocalDate.now().plusDays(1), BigDecimal.valueOf(60.0)),
                                new Faturamento(LocalDate.now().plusDays(1), BigDecimal.valueOf(70.0)),
                                new Faturamento(LocalDate.now().plusDays(2), BigDecimal.valueOf(77.33)),
                                new Faturamento(LocalDate.now().plusDays(2), BigDecimal.valueOf(55.33))
                        ));
        System.out.println("Arquivo %s foi gravado com sucesso!".formatted(arquivoJson.getAbsolutePath()));
    }
}
