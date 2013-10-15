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
	private ArrayList<Integer> parameterTagIds;
}
