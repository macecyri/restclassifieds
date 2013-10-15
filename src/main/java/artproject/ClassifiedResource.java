package artproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import artproject.dao.ArtDao;
import artproject.model.Classified;
import artproject.model.ClassifiedSaveQuery;
import artproject.model.Tag;

@Path("/classifieds")
@Data
public class ClassifiedResource {
	@Autowired
	private ArtDao artDao;

	@GET
	@Produces("application/json")
	public List<Classified> getClassifieds(@QueryParam("tags") String tagsId) {
		if (tagsId != null){
			List<String> listTagsId = new ArrayList<String>(Arrays.asList(tagsId.replaceAll("\\s+","").split(",")));
			List<Integer> listTagsIntegerId = new ArrayList<Integer>();
			for (String tagId : listTagsId){
				listTagsIntegerId.add(Integer.parseInt(tagId));
			}
			return artDao.getClassifieds(listTagsIntegerId);
		}
		else{
			return artDao.getAllClassifieds();
		}
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(ClassifiedSaveQuery query) {
	String title = query.getTitle();
	List<Integer>  relatedTags = query.getParameterTagIds();
	Classified classified = new Classified();
		classified.setTitle(title);
		for (Integer tagId : relatedTags){
			Tag tag = artDao.getTag(tagId);
			classified.getRelatedTags().add(tag);
		}
		artDao.createClassified(classified);
	}
}
