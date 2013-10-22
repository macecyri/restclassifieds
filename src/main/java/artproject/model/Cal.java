package artproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Calendar")
@Data
@NoArgsConstructor
public class Cal {
	
	@Id
    @Column(name="Id")
    @GeneratedValue
    private Integer id;
 
    @Column(name="Name")
    private String name;
    
    
    
    
}
