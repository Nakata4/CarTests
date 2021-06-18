package repository;

import java.util.List;

import entities.Mark;
import repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import repository.Query;
import repository.query.Param;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

	void save(Mark mark);

	Mark findOne(Integer id);

	List<Mark> findAll();
}
