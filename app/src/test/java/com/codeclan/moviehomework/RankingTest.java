package com.codeclan.moviehomework;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 07/08/2017.
 */

public class RankingTest {
    Movie movie1;
    Movie movie2;
    Movie movie3;
    Movie movie4;
    Movie movie5;
    Movie movie6;
    Movie movie7;
    Movie movie8;
    Movie movie9;
    Movie movie10;
    Ranking rankings;
    Movie[] currentRankings;


    @Before
    public void before(){
        movie1 = new Movie("The Hobbit", "Adventure", 1);
        movie2 = new Movie("The Hobbit 2", "Adventure", 2);
        movie3 = new Movie("The Hobbit 3", "Adventure", 3);
        movie4 = new Movie("Jurassic Park", "Adventure", 4);
        movie5 = new Movie("The Terminator", "Action", 5);
        movie6 = new Movie("The Journey to the center of the earth", "Adventure", 6);
        movie7 = new Movie("The Beginning", "Adventure", 7);
        movie8 = new Movie("The Ring", "Horror", 8);
        movie9 = new Movie("The Chase", "Thriller", 9);
        movie10 = new Movie("The Police", "Thriller", 10);
        currentRankings = new Movie[]{
                movie1,
                movie2,
                movie3,
                movie4,
                movie5,
                movie6,
                movie7,
                movie8,
                movie9,
                movie10
        };
        rankings = new Ranking(currentRankings);
    }

    @Test
    public void canGetRankingsMovieByIndex(){
        assertEquals(movie1, rankings.getRanking(1));
    }

    @Test
    public void canSetNewMovieAtEndOfRankings(){
        Movie newMovie = new Movie("Robocop", "Action", 10);
        rankings.addMovie(newMovie);
        assertEquals(newMovie, rankings.getRanking(newMovie.getRanking()));
    }

    @Test
    public void canGetMovieIndex(){
        assertEquals(9, rankings.getIndex(movie10));
    }
    @Test
    public void canChangeMoviesRankingUp(){
        rankings.movieChangeRanking(movie10, -1);
        System.out.println(rankings.toString());
        assertEquals(movie10, rankings.getRanking(9));
        assertEquals(movie9, rankings.getRanking(10));
    }

    @Test
    public void canPrintRankingsList(){
        System.out.println(rankings.toString());
        assertNotNull(rankings.toString());
    }
    @Test
    public  void canChangeMovieRankingDown(){
        System.out.println(rankings.toString());
        rankings.movieChangeRanking(movie1, 1);
        assertEquals(movie1, rankings.getRanking(2));
        assertEquals(movie2, rankings.getRanking(1));
    }
}
