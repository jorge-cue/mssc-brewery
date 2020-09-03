package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
public interface BeerService {
    /**
     *
     * @param beerId
     * @return
     */
    Optional<BeerDto> getBeer(UUID beerId);

    /**
     *
     * @param beerDto
     * @return
     */
    BeerDto createBeer(BeerDto beerDto);

    /**
     *
     * @param beerId
     * @param beerDto
     * @return
     */
    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    /**
     *
     * @param beerId
     */
    void delete(UUID beerId);
}
