package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        Optional<CustomerDto> customerDto = customerService.getCustomer(customerId);
        return customerDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Optional<CustomerDto> created = customerService.createCustomer(customerDto);
        return created
                .map(c -> {
                    URI uri = URI.create("/api/v1/customer/" + c.getCustomerId().toString());
                    return ResponseEntity.created(uri).body(c);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        Optional<CustomerDto> updated = customerService.updateCustomer(customerId, customerDto);
        return updated
                .map(c -> {
                    URI uri = URI.create("/api/v1/customer/" + c.getCustomerId().toString());
                    return ResponseEntity.accepted().location(uri).body(c);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
