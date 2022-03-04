package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Car;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT carModel FROM Car")
    public List<String> carModel();

    @Query("SELECT  price FROM Car order by price ASC ")
    public List<String> Ascprice();

    @Query("SELECT price FROM Car order by price DESC ")
    public List<String> Desprices();

    @Query("SELECT carModel,avg (rating) FROM Car group by carModel having count (carModel)>1 ")
    List<String> getAverageRating();

}
