package com.example.myeongseongservertest.datafetchers;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowDataFetcher.class})
class ShowDataFetcherTest {

    @Autowired
    DgsQueryExecutor queryExecutor;

    @Test
    void shows() {

//        new GraphQLQueryRequest()

        String query = "query {\n" +
                "\tshows(titleFilter: \"Wonbin\"){\n" +
                "    title\n" +
                "    releaseYear\n" +
                "  }\n" +
                "}";

        List<String> titles = queryExecutor.executeAndExtractJsonPath(query, "data.shows[*].title");
        assertThat(titles).contains("Wonbin");
    }

}