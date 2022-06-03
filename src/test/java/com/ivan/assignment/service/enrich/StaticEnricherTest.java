package com.ivan.assignment.service.enrich;

import com.ivan.assignment.repository.model.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StaticEnricherTest {

	@Autowired
	private StaticEnricher enricher;

	@ParameterizedTest
	@CsvSource({"Nokia, WINDOWS",
	            "Samsung, ANDROID",
	            "Apple, IOS",
				"Noname, UNKNOWN"})
	void test(String deviceName, Phone.Technology technology) {
		var phone = Phone.builder().deviceName(deviceName).build();
		enricher.enrich(phone);

		Assertions.assertEquals(technology, phone.getTechnology());
	}

}
