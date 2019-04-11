package com.nabenik.repository;

import com.nabenik.model.Actor;
import com.nabenik.model.Movie;
import com.nabenik.rest.JAXRSConfiguration;
import com.nabenik.util.EntityManagerProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MovieRepositoryTest {

    @Inject
    MovieRepository movieRepository;

    @Deployment
    public static WebArchive createDeployment(){
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(Movie.class)
                .addClass(Actor.class)
                .addClass(EntityManagerProducer.class)
                .addClass(MovieRepository.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");

        System.out.println(war.toString(true));

        return war;
    }

    @Test
    public void create() {
        Movie movie = new Movie("El silencio de Jimmy", "2014", "4 años");
        movieRepository.create(movie);
        System.out.println("Movie Id " + movie.getMovieId());
        assertNotNull(movie.getMovieId());
        // se añadió otro registro solo para pruebas
        movie = new Movie("El silencio de Jimmy 2", "2015", "4 días");
        movieRepository.create(movie);
        movie = new Movie("El silencio de Jimmy 3", "2015", "4 días");
        movieRepository.create(movie);

    }

    @Test //TEST UPDATE
    public void testUpdate()
    {
        Movie movie = movieRepository.findById(2L);
        movie.setYear("2014");
        movieRepository.update(2L,movie);

        movie = movieRepository.findById(2L);
        assertEquals(movie.getYear(),"2014");
    }

   @Test //TEST GET INDIVIDUAL
    public void testGetById() {
        Movie movie = movieRepository.findById(1L);
        System.out.println("Movie Title " + movie.getTitle());
        assertNotNull(movie);

    }

    @Test //TEST GETALL
    public void testGetAllByTitle() {
        List<Movie> movieList = movieRepository.listAll("silencio");
        System.out.println("Tamaño: " + movieList.size());
        assertNotNull(movieList);
    }

    @Test //TEST DELETE
    public void testDelete() {
        movieRepository.delete(3L);
        List<Movie> movieList = movieRepository.listAll("silencio");
        System.out.println("Nuevo tamaño de lista " + movieList.size());

    }


}
