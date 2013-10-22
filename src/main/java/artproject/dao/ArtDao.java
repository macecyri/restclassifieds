package artproject.dao;

import java.util.List;

import artproject.model.Cal;
import artproject.model.Classified;
import artproject.model.Dep;
import artproject.model.Post;
import artproject.model.Tag;

public interface ArtDao {
	public List<Tag> getAllTags();
	public List<Dep> getAllDeps();
	public List<Cal> getAllCals();
	public void createTag(Tag tag);
	public Tag getTag(Integer tagId);
	public Dep getDep(Integer depId);
	public Cal getCal(Integer calId);
	public Classified getClassified(Integer classifiedId);
	public List<Classified> getClassifieds(List<Integer> listTagsId);
	public List<Classified> getAllClassifieds();
	public void createClassified(Classified classified);
	public List<Post>  getAllPostsClassified(Integer classifiedId);
	public void createPost(Post post);

}
