package beans;

import java.util.List;
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
import javax.persistence.PreRemove;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CATEGORY")
@JsonIgnoreProperties({"cars"})
public class CategoryBean implements Comparable<CategoryBean> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name", nullable=false, unique=false, length = 255)
	private String name;
	@Column(name="type", nullable=false, unique=false, length = 255)
	private String type;
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private Set<CarBean> cars;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<CarBean> getCars() {
		return cars;
	}
	public void setCars(Set<CarBean> diets) {
		this.cars = cars;
	}
	@Override
    public boolean equals(Object o) { 
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof CategoryBean)) { 
            return false; 
        } 
        CategoryBean c = (CategoryBean) o; 

        return this.getId()==c.getId(); 
    }
	@Override
	public int compareTo(CategoryBean category) {
		if (this.getId() == 0 || category.getId() == 0) { 
		      return 0; 
		    } 
		    return Integer.compare(this.getId(), category.getId());
		  }
	@PreRemove
	public void removeRelations() {
		cars.forEach(car->car.removeCategory(this));
		}
	public void removeCar(CarBean car) {
		if(cars.contains(car)) {
			cars.remove(car);
		}
	}

	
}