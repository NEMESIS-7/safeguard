package com.reynolds.safeguard;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTests {

    @Test
    void ModularityTest(){
        ApplicationModules.of(SafeguardApplication.class).verify();
    }
}
