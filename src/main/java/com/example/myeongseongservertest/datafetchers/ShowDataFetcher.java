package com.example.myeongseongservertest.datafetchers;

import com.example.myeongseongservertest.entity.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowDataFetcher {
    public List<Show> showData = List.of(
            Show.builder().title("Wonbin").releaseYear(2023).build(),
            Show.builder().title("Choi").releaseYear(2022).build()
    );

    @DgsData(parentType = "Query", field = "shows")
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter != null) {
            return showData.stream().filter(f -> f.getTitle().startsWith(titleFilter)).collect(Collectors.toList());
        }

        return showData;
    }

}

