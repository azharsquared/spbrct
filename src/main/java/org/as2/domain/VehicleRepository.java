package org.as2.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
// The CrudRepository interface is a generic interface that defines CRUD methods like save(), findAll(), findById(), delete(), and deleteAll().
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    // Fetch cars by brand
    //List<Vehicle> findByBrand(String brand);
    // Fetch cars by color
    //List<Vehicle> findByColor(String color);
    // Fetch cars by model year
    List<Vehicle> findByModelYear(int modelYear);

    List<Vehicle> findByBrandAndModel(String brand, String model);
    // Fetch cars by brand or color
    List<Vehicle> findByBrandOrColor(String brand, String color);

    List<Vehicle> findByBrandOrderByModelYearAsc(String brand);

    // Fetch cars by brand using SQL
    @Query("select c from Vehicle c where c.brand = ?1")
    List<Vehicle> findByBrandQuery(String brand);

    // Fetch cars by brand using SQL
    @Query("select c from Vehicle c where c.brand like %?1")
    List<Vehicle> findByBrandEndsWith(String brand);

    //Query parameters are annotated with the @Param annotation
    // without the @Param annotation, the query will not work with data rest
    // Fetch cars by brand
    List<Vehicle> findByBrand(@Param("brand") String brand);
    // Fetch cars by color
    List<Vehicle> findByColor(@Param("color") String color);
}
