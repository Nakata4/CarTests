package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beans.UserBean;

@Repository
public interface UserRepo extends JpaRepository<UserBean, Integer> {
	
	UserBean findUserByUsernameAndPassword(String username, String password);
	UserBean findByUsername(String username);
	UserBean findByEmail(String email);


}
