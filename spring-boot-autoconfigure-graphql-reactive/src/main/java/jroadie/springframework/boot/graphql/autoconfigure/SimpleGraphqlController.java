package graphql4j.springframework.boot.graphql.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@ConditionalOnMissingBean(GraphqlController.class)
@RestController
@RequestMapping("${spring.graphql.baseUrl:/graphql}")
public class SimpleGraphqlController implements GraphqlController<Map> {

    @PostMapping
    public Map<String, ?> index() {
        System.out.println("7777777777777777777777777777");
        return Collections.emptyMap();
    }

}
