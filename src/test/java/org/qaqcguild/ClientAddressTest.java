package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientAddressTest {

    @Test
    void shouldCreateAddress() {
        ClientAddress address = ClientAddress.builder()
                .street("Rua dos Carecas")
                .number("57")
                .district("Bairro dos Sem-Telha")
                .city("Baldtown")
                .build();

        TestUtils.printObject(address);

        Assertions.assertEquals("Rua dos Carecas" , address.getStreet());
        Assertions.assertEquals("57" , address.getNumber());
        Assertions.assertEquals("Bairro dos Sem-Telha" , address.getDistrict());
        Assertions.assertEquals("Baldtown" , address.getCity());
    }
}