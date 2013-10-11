package artproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Classified")
@Data
public class Classified {

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer id;

	@Column(name = "Title")
	private String title;

	@ManyToMany
	@JoinTable(name = "Classified_Tag", joinColumns = { @JoinColumn(name = "Id_classified", referencedColumnName = "Id") }, inverseJoinColumns = { @JoinColumn(name = "Id_tag", referencedColumnName = "Id") })
	private Set<Tag> relatedTags;	
	
	public Classified(){
		relatedTags = new HashSet<Tag>();
	}
	
	

}
