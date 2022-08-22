package co.gov.educacionbogota.apigatewayapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiGatewayApiApplicationTests {


	@Test
	void testDoSomething() {
		ApiGatewayApiApplication apigw = new ApiGatewayApiApplication();
		//Assertions.assertNotNull(apigw.apisAPI());  // JUnit assertion
	}

}
