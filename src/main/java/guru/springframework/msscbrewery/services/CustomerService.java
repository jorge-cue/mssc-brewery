package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.Optional;
import java.util.UUID;

/*
 * Created by jhcue on 02/09/2020
 */
public interface CustomerService {
    /**
     *
     * @param customerId
     * @return
     */
    Optional<CustomerDto> getCustomer(UUID customerId);
}
