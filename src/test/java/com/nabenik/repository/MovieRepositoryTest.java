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

import javax.inject.Inject;

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
    }

}
