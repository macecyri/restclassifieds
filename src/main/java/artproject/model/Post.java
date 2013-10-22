package artproject.model;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ClassifiedPost")
@Data
@NoArgsConstructor
public class Post {

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer id;

	@Column(name = "ClassifiedId")
	private Integer classifiedId;
	
	@Column(name = "Submitter")
	private String submitter;
	
	@Column(name = "Content")
	private String content;

}
