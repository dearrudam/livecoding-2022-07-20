package livecoding;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

public class Sample01 {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader input = new FileReader("faturamentos.json")) {

            JsonNode jsonNode = objectMapper.readTree(input);

            Iterator<JsonNode> elements = jsonNode.elements();
            while(elements.hasNext()){
                JsonNode node = elements.next();
                System.out.println("""
                        data=%s\tvalor=%s
                        """.strip().formatted(node.get("data"),node.get("valor")));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
