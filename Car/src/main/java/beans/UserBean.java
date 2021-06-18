package beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class UserBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username", nullable=false, unique=true, length = 255)
	private String username;
	@Column(name="password", nullable=false, length=60)
	private String password;
	@Column(name="email", nullable=false, unique=true, length=255)
	private String email;
    @ManyToMany( fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="USER_CAR",
    		joinColumns = @JoinColumn(name="USER_ID"), 
    		inverseJoinColumns = @JoinColumn(name="CAR_ID")
    		)
    private Set<CarBean> cars;
	@ManyToOne()
    private CarBean car;	

    public UserBean() {};
    public UserBean(String username, String email) {
    	this.username = username;
    	this.email = email;
    	
    };
    public UserBean(String username, String password, String email ) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<CarBean> getAllCars() {
		return cars;
	}
	public void setSelectedCars(Set<CarBean> cars) {
		this.cars = cars;
	}
	public CarBean getCars() {
		return car;
	}
	public void addCar(CarBean care) {
		car.add(car);
	}
	@PreRemove
	public void removeRelations() {
		cars.forEach(car -> car.removeUser(this));
		car = null;
		}
	public void setCars(Set<CarBean> cars2) {
		// TODO Auto-generated method stub
		
	}
	
}

