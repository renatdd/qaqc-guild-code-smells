package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void shouldCreateNewClientWithPhoneAndAddress() {

        ClientAddress address = ClientAddress.builder()
                .street("Rua dos Carecas")
                .number("57")
                .district("Bairro dos Sem-Telha")
                .city("Baldtown")
                .build();
        ClientPhone phone = new ClientPhone("081999999999");
        Client client = new Client("Renato", "Feitosa", phone, address);

        TestUtils.printObject(client);

        Assertions.assertEquals("Renato", client.getFirstName());
        Assertions.assertEquals("Feitosa", client.getLastName());
        Assertions.assertEquals("Renato Feitosa", client.getFullName());

        Assertions.assertEquals("81", client.getPhone().getAreaCode());
        Assertions.assertEquals("999999999", client.getPhone().getNumber());
        Assertions.assertEquals("(81) 99999-9999", client.getPhone().toString());

        Assertions.assertEquals("Rua dos Carecas" , client.getAddress().getStreet());
        Assertions.assertEquals("57" , client.getAddress().getNumber());
        Assertions.assertEquals("Bairro dos Sem-Telha" , client.getAddress().getDistrict());
        Assertions.assertEquals("Baldtown" , client.getAddress().getCity());

    }
}