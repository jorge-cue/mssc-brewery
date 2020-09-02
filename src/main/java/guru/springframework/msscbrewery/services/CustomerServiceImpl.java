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

    public static final String TEST_CUSTOMER_ID = "3d45d09e-f2b6-412f-bed9-c712ccbcfea1";

    public Optional<CustomerDto> getCustomer(UUID customerId) {
        if (UUID.fromString(TEST_CUSTOMER_ID).equals(customerId))
            return Optional.of(CustomerDto.builder().customerId(customerId).name("John Doe").build());
        return Optional.empty();
    }
}
