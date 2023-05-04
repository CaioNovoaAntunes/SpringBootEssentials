package academy.devdojo.springboot2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimePostRequestBody {
    private String name;
}