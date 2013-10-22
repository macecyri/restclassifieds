package artproject.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassifiedSaveQuery {
	private String title;
	private String description;
	private ArrayList<Integer> parameterTagIds;
	private ArrayList<Integer> parameterDepIds;
	private ArrayList<Integer> parameterCalIds;
}
