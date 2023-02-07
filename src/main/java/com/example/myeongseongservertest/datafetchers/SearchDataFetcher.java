package com.example.myeongseongservertest.datafetchers;

import com.example.myeongseongservertest.DgsConstants;
import com.example.myeongseongservertest.types.Movie;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.util.Set;
import java.util.stream.Collectors;

@DgsComponent
public class SearchDataFetcher {

    // codegen types 사용
    private final Set<Movie> movies = Set.of(
            Movie.newBuilder().title("올빼미").releaseYear(2022).build(),
            Movie.newBuilder().title("아바타2").releaseYear(2022).build(),
            Movie.newBuilder().title("오펜하이머").releaseYear(2023).build()
    );

//    @DgsData(parentType = "Query", field = "search")
//    public Set<Movie> search(@InputArgument String title) {
//        return movies.stream().filter(m -> m.getTitle().startsWith(title)).collect(Collectors.toSet());
//    }

    // DgsConstants 사용
    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Search)
    public Set<Movie> search(@InputArgument String title) {
        return movies.stream().filter(m -> m.getTitle().startsWith(title)).collect(Collectors.toSet());
    }
}
