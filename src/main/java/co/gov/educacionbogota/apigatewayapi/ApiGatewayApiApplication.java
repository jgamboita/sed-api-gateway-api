package co.gov.educacionbogota.apigatewayapi;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiGatewayApiApplication {
	@Autowired
	private final RouteDefinitionLocator locator = null;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApiApplication.class, args);
	}

	private GroupedOpenApi prepareGroup(String pGroup, String pPath) {
		return GroupedOpenApi.builder()
				.group(pGroup)
				.pathsToMatch(pPath)
				.build();
	}
	

	 @Bean
	    public List<GroupedOpenApi> apisAPI() {
	        List<GroupedOpenApi> groups = new ArrayList<>();
	        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
			   definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-api")).forEach(routeDefinition -> {
				      String name = routeDefinition.getId().replaceAll("-api", "");
	            GroupedOpenApi api = GroupedOpenApi.builder()
	            		.pathsToMatch("/" + name + "/**")
	            		.group(name)
	            		.build();
	            groups.add(api);
	        });
	        return groups;
	    }
	 
	
		public List<GroupedOpenApi> apisAPI2() {
		   List<GroupedOpenApi> groups = new ArrayList<>();
		   List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		   definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-api")).forEach(routeDefinition -> {
		      String name = routeDefinition.getId().replaceAll("-api", "");
		      GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
		   });
		   return groups;
		}

}
