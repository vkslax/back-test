package com.nabenik.repository;


import com.nabenik.model.Movie;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
@Default
public class MovieRepository {

    @Inject
    EntityManager em;

    public Movie findById(Long id){
        return em.find(Movie.class, id);
    }

    public void create(Movie movie){
        em.persist(movie);
    }

    public Movie update(Movie movie){
        return em.merge(movie);
    }

    public void delete(Movie movie){
        em.remove(movie);
    }

    public List<Movie> listAll(String title){

        String query = "SELECT m FROM Movie m " +
                "where m.title LIKE :title";

        Query typedQuery = em.createQuery(query)
                .setParameter("title", "%".concat(title).concat("%"));

        return typedQuery.getResultList();
    }
}
