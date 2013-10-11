package artproject;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import artproject.dao.ArtDao;
import artproject.model.Tag;


@Path("/tags")
@Data
public class TagResource {

	@Autowired
    private ArtDao artDao;
	
   @GET
   @Produces("application/json")
    public List<Tag> getTags(){
        return artDao.getAllTags();
    }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public void save(@HeaderParam("name") String tagName){
	   Tag tag = new Tag();
	   tag.setName(tagName);
	   artDao.createTag(tag);
   }
}
