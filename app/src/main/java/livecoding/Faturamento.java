package livecoding;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Faturamento (
            @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
            LocalDate data,
            BigDecimal valor
    ){
}