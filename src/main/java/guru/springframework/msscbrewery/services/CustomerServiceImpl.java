package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    public Optional<CustomerDto> getCustomer(UUID customerId) {
        return Optional.of(CustomerDto.builder().customerId(customerId).name("John Doe").build());
    }

    public Optional<CustomerDto> createCustomer(CustomerDto customerDto) {
        if (customerDto.getCustomerId() == null)
            customerDto.setCustomerId(UUID.randomUUID());
        return Optional.of(customerDto);
    }

    public Optional<CustomerDto> updateCustomer(UUID customerId, CustomerDto customerDto) {
        return Optional.empty();
    }

    public void deleteCustomer(UUID customerId) {
    }
}
