package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
@Service
public class BeerServiceImpl implements BeerService {

    public static final String TEST_BEER_ID = "8ecea513-e9a2-4545-8c2f-b24001582237";

    private final HashMap<UUID, BeerDto> beerRepository;

    public BeerServiceImpl() {
        this.beerRepository = new HashMap<>();

        UUID beerId = UUID.fromString(TEST_BEER_ID);
        beerRepository.put(beerId, BeerDto.builder().beerId(beerId).beerName("Galaxy Cat").beerStyle("Lager").upc(12345L).build());
    }

    public Optional<BeerDto> getBeer(UUID beerId) {
        return Optional.ofNullable(beerRepository.get(beerId));
    }

    public BeerDto createBeer(BeerDto beerDto) {
        UUID beerId = UUID.randomUUID();
        beerDto.setBeerId(beerId);
        beerRepository.put(beerId, beerDto);
        return beerDto;
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        return null;
    }

    @Override
    public void delete(UUID beerId) {
        beerRepository.remove(beerId);
    }
}
