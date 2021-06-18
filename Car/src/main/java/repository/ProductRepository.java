package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beans.ProductBean;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer> {

}
