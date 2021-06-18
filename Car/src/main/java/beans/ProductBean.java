package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class ProductBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME", nullable=false, unique=true, length = 40)
	private String name;
	@Column(name="DESCRIPTION", nullable=false, unique=false, length = 255)
	private String description;
	@Column(name="IMAGE_PATH", nullable=false, unique=false, length = 255)
	private String imagePath;
	@Column(name="WEIGHT")
	private double weight;
	@Column(name="HORSEPOWER")
	private double horsePowers;
	@Column(name="AUTHOR_ID")
	private int authorId;

	public void removeRelations() {
		}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHorsePower() {
		return horsePowers;
	}
	public void setHorsePower(double horsePowers) {
		this.horsePowers = horsePowers;
	}

	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}		
}


