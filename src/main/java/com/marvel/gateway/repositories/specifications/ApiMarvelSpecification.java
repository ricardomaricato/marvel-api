package com.marvel.gateway.repositories.specifications;

import com.marvel.gateway.models.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.Locale;

public class ApiMarvelSpecification {

    public static Specification<Hero> heroWithName(String name, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            ListJoin<Hero, Result> join = root.joinList("results");
            criteriaQuery.orderBy(criteriaBuilder.asc(join.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.equal(join.get("name"), name);
        });
    }

    public static Specification<Hero> heroWithNameStartsWith(String name, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            ListJoin<Hero, Result> join = root.joinList("results");
            criteriaQuery.orderBy(criteriaBuilder.asc(join.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.like(join.get("name"), "%" + name + "%");
        });
    }

    public static Specification<Hero> heroWithComic(Integer parameter, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<Hero, Result> resultJoin = root.join("results");
            Join<Result, Comic> resultComicJoin = resultJoin.join("comics");
            Predicate predicateAvailable = criteriaBuilder.equal(resultComicJoin.get("available"), parameter);
            Predicate predicateReturned = criteriaBuilder.equal(resultComicJoin.get("returned"), parameter);
            criteriaQuery.orderBy(criteriaBuilder.asc(resultJoin.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.and(predicateAvailable, predicateReturned);
        });
    }

    public static Specification<Hero> heroWithStorie(Integer parameter, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<Hero, Result> resultJoin = root.join("results");
            Join<Result, Storie> resultComicJoin = resultJoin.join("stories");
            Predicate predicateAvailable = criteriaBuilder.equal(resultComicJoin.get("available"), parameter);
            Predicate predicateReturned = criteriaBuilder.equal(resultComicJoin.get("returned"), parameter);
            criteriaQuery.orderBy(criteriaBuilder.asc(resultJoin.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.and(predicateAvailable, predicateReturned);
        });
    }

    public static Specification<Hero> heroWithEvent(Integer parameter, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<Hero, Result> resultJoin = root.join("results");
            Join<Result, Event> resultComicJoin = resultJoin.join("events");
            Predicate predicateAvailable = criteriaBuilder.equal(resultComicJoin.get("available"), parameter);
            Predicate predicateReturned = criteriaBuilder.equal(resultComicJoin.get("returned"), parameter);
            criteriaQuery.orderBy(criteriaBuilder.asc(resultJoin.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.and(predicateAvailable, predicateReturned);
        });
    }

    public static Specification<Hero> heroWithSerie(Integer parameter, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<Hero, Result> resultJoin = root.join("results");
            Join<Result, Serie> resultComicJoin = resultJoin.join("series");
            Predicate predicateAvailable = criteriaBuilder.equal(resultComicJoin.get("available"), parameter);
            Predicate predicateReturned = criteriaBuilder.equal(resultComicJoin.get("returned"), parameter);
            criteriaQuery.orderBy(criteriaBuilder.asc(resultJoin.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.and(predicateAvailable, predicateReturned);
        });
    }

    public static Specification<Hero> heroWithModifiedSince(LocalDate modified, String order) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            ListJoin<Hero, Result> join = root.joinList("results");
            criteriaQuery.orderBy(criteriaBuilder.asc(join.get(order.toLowerCase(Locale.ROOT))));
            return criteriaBuilder.equal(join.get("modified"), modified);
        });
    }

}