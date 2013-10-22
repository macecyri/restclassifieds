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
	
	@Column(name = "Description")
	private String description;

	@ManyToMany
	@JoinTable(name = "Classified_Tag", joinColumns = { @JoinColumn(name = "Id_classified", referencedColumnName = "Id") }, inverseJoinColumns = { @JoinColumn(name = "Id_tag", referencedColumnName = "Id") })
	private Set<Tag> relatedTags;
	
	@ManyToMany
	@JoinTable(name = "Classified_Dep", joinColumns = { @JoinColumn(name = "Id_classified", referencedColumnName = "Id") }, inverseJoinColumns = { @JoinColumn(name = "Id_dep", referencedColumnName = "Id") })
	private Set<Dep> relatedDeps;	
	
	@ManyToMany
	@JoinTable(name = "Classified_Cal", joinColumns = { @JoinColumn(name = "Id_classified", referencedColumnName = "Id") }, inverseJoinColumns = { @JoinColumn(name = "Id_cal", referencedColumnName = "Id") })
	private Set<Cal> relatedCals;	
	
	public Classified(){
		relatedTags = new HashSet<Tag>();
		relatedDeps = new HashSet<Dep>();
		relatedCals = new HashSet<Cal>();
	}
	
	

}
