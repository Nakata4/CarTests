package repository;

import entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>{

    @Query("select c from Car c where (c.markTable.mark = :mark or '' = :mark) " +
            "and (c.typeTable.type = :type or '' = :type)" +
            "and (c.engineTable.engineType.type = :engineType or '' = :engineType) " +
            "and (c.year between :stYear and :endYear) " +
            "and (c.price between :stPrice and :endPrice)" +
            "and (c.mileage between :stMileage and :endMileage)")
    List<Car> getCarsByParams(@Param("mark")String mark,
                              @Param("type")String type,
                              @Param("engineType")String engineType,
                              @Param("stYear")Integer stYear,
                              @Param("endYear")Integer endYear,
                              @Param("stPrice")Integer stPrice,
                              @Param("endPrice")Integer endPrice,
                              @Param("stMileage")Integer stMileage,
                              @Param("endMileage")Integer endMileage);

    @Modifying
    @Query("update Car c set c.model = :model, c.mileage = :mileage," +
            " c.typeTable = :type, c.doors = :doors, c.year = :year," +
            " c.information = :info, c.price = :price where c.id = :id")
    void updateCarById(@Param("model")String model,
                       @Param("mileage")Integer mileage,
                       @Param("type")Type type,
                       @Param("id")Integer id,
                       @Param("doors")Integer doors,
                       @Param("year")Integer year,
                       @Param("info")String info,
                       @Param("price")Integer price);
}
