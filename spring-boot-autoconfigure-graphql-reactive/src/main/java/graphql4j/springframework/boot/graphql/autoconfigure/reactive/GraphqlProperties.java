package graphql4j.springframework.boot.graphql.autoconfigure.reactive;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.graphql")
public class GraphqlProperties {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
