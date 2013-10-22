package artproject;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import artproject.dao.ArtDao;
import artproject.model.Post;
import artproject.model.PostSaveQuery;

@Path("/classifieds/{classifiedid}/posts")
@Data
public class PostResource {
	@Autowired
	private ArtDao artDao;

	@GET
	@Produces("application/json")
	public List<Post> getPostss(@PathParam("classifiedid") Integer classifiedid) {
		return artDao.getAllPostsClassified(classifiedid);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(@PathParam("classifiedid") Integer classifiedid, PostSaveQuery query) {
		String submitter = query.getSubmitter();
		String content = query.getContent();
		Post post = new Post();
		post.setClassifiedId(classifiedid);
		post.setSubmitter(submitter);
		post.setContent(content);
		artDao.createPost(post);
	}
}
