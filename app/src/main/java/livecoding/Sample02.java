package livecoding;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Sample02 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        var arquivoJson = new File("faturamentos.json");

        List<Faturamento> faturamentos = objectMapper.readValue(arquivoJson, new TypeReference<List<Faturamento>>() {
        });

        faturamentos.forEach(System.out::println);

    }

}
