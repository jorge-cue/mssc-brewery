package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 2020-09-02
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        Optional<BeerDto> beerDto = beerService.getBeer(beerId);
        return beerDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {
        BeerDto created = beerService.createBeer(beerDto);
        URI locator = URI.create("/api/v1/beer/" + created.getBeerId().toString());
        return ResponseEntity.created(locator).body(created);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> handlePut(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        BeerDto updated = beerService.updateBeer(beerId, beerDto);
        URI locator = URI.create("/api/v1/beer/" + updated.getBeerId().toString());
        return ResponseEntity.accepted().location(locator).body(updated);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Void> handleDelete(@PathVariable UUID beerId) {
        beerService.delete(beerId);
        return ResponseEntity.noContent().build();
    }
}
