package repository;

import entities.Engine;
import entities.EngineType;
import entities.Transmission;
import repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import repository.Modifying;
import repository.Query;
import repository.query.Param;

public interface EngineRepository extends JpaRepository<Engine, Integer>{

    @Modifying
    @Query("update Engine e set e.engineType = :engineType, e.volume = :volume, e.hp = :hp," +
            "e.nm = :nm, e.transmission = :transmission where e.id = :id")
    void updateEngineById(@Param("id")Integer id, @Param("engineType")EngineType engineType,
                          @Param("volume")Integer volume, @Param("hp")Integer hp,
                          @Param("nm")Integer nm, @Param("transmission")Transmission transmission);

	void save(Engine engine);

	void delete(Engine engine);
}
