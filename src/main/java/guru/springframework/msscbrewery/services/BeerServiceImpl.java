package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
@Service
public class BeerServiceImpl implements BeerService {

    public static final String TEST_BEER_ID = "8ecea513-e9a2-4545-8c2f-b24001582237";

    public Optional<BeerDto> getBeer(UUID beerId) {
        if(UUID.fromString(TEST_BEER_ID).equals(beerId))
            return Optional.of(BeerDto.builder().beerId(beerId).beerName("Galaxy Cat").beerStyle("Lager").upc(12345L).build());
        return Optional.empty();
    }
}
