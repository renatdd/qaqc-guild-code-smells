package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientPhoneTest {

    @Test
    void shouldCreatePhoneWithAreaAndNumberProps() {
        ClientPhone phone = new ClientPhone("081999999999");

        TestUtils.printObject(phone);

        Assertions.assertEquals("81", phone.getAreaCode());
        Assertions.assertEquals("999999999", phone.getNumber());
        Assertions.assertEquals("(81) 99999-9999", phone.toString());

    }
}