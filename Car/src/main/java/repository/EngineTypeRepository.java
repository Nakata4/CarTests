package repository;

import java.util.List;

import entities.EngineType;
import repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineTypeRepository extends JpaRepository<EngineType, Integer>{

	List<EngineType> findAll();

	EngineType findOne(Integer id);
}
