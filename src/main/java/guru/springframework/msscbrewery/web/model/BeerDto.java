package guru.springframework.msscbrewery.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/*
 * Created by jhcue on 2020-09-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {
    private UUID beerId;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
