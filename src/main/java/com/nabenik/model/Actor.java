package com.nabenik.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Actor")
public class Actor implements Serializable {

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long actorId;

    @Column
    public String name;

    @Column
    private String country;

    @Column
    private String birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
