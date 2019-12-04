package com.evolent.contactinformation;

import com.evolent.contactinformation.controller.ContactInformationController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactInformationApplicationTests {

    @Autowired
    private ContactInformationController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }

}
