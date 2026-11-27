package com.reynolds.safeguard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SafeguardApplicationTests {

	@Test
	void contextLoads() {
	}

}
