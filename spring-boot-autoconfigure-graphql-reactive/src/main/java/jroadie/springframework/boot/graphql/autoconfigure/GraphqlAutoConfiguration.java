package graphql4j.springframework.boot.graphql.autoconfigure;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static graphql.GraphQL.*;
import static graphql.Scalars.*;
import static graphql.schema.GraphQLFieldDefinition.*;
import static graphql.schema.GraphQLObjectType.*;
import static graphql.schema.GraphQLSchema.*;

@Configuration
@EnableConfigurationProperties(GraphqlProperties.class)
@Import(SimpleGraphqlController.class)
public class GraphqlAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(GraphQLObjectType.class)
    public GraphQLObjectType graphqlQuery() {
        return newObject()
                .name("RootQuery")
                .description("testing object type")
                .field(newFieldDefinition()
                        .name("hello")
                        .type(GraphQLString)
                        .dataFetcher(environment -> "Bangladesh!")
                        .build()
                )
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(GraphQLObjectType.class)
    public GraphQLObjectType graphqlMutation() {
        return newObject()
                .name("RootQuery")
                .description("testing object type")
                .field(newFieldDefinition()
                        .name("hello")
                        .type(GraphQLString)
                        .dataFetcher(environment -> "Bangladesh!")
                        .build()
                )
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(GraphQLSchema.class)
    public GraphQLSchema graphQLSchema(GraphQLObjectType graphqlQuery, GraphQLObjectType graphqlMutation) {
        return newSchema()
                .query(graphqlQuery)
                .mutation(graphqlMutation)
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(GraphQL.class)
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return newGraphQL(graphQLSchema).build();
    }

}
