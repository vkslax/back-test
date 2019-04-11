package com.nabenik.repository;


import com.nabenik.model.Movie;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;

@Local
@Stateless
public class MovieRepository {

    @PersistenceContext(unitName = "back-PU")
    EntityManager em;

    public Movie findById(Long id){
        Movie response;
        try
        {
            response = em.find(Movie.class, id);
        }
        catch (NoResultException ex)
        {
            System.out.println("Movie cannot be found");
            response = null;
        }
        return response;
    }

    public void create(@Valid Movie movie){
        em.persist(movie);
    }

    public Movie update(Long id, @Valid Movie movie){
        Movie toEdit = findById(id);
        if (toEdit != null)
        {
            toEdit.setDuration(movie.getDuration());
            toEdit.setTitle(movie.getTitle());
            toEdit.setYear(movie.getYear());
        }
        return toEdit;
    }

    public void delete(Long id){
        Movie movie = findById(id);
        em.remove(movie);
    }

    public List<Movie> listAll(String title){

        String query = "SELECT m FROM Movie m " +
                "where m.title LIKE :title";

        Query typedQuery = em.createQuery(query)
                .setParameter("title", "%".concat(title).concat("%"));

        return typedQuery.getResultList();
    }

    public List<Movie> listAllNoRestriction(){

        String query = "SELECT m FROM Movie m ";
        return em.createQuery(query).getResultList();
    }
}
