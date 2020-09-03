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

    /**
     *
     * @param customerDto
     * @return
     */
    Optional<CustomerDto> createCustomer(CustomerDto customerDto);

    /**
     *
     * @param customerId
     * @param customerDto
     * @return
     */
    Optional<CustomerDto> updateCustomer(UUID customerId, CustomerDto customerDto);

    /**
     *
     * @param customerId
     */
    void deleteCustomer(UUID customerId);
}
