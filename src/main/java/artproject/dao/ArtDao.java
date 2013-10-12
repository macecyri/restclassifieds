package artproject.dao;

import java.util.List;

import artproject.model.Classified;
import artproject.model.Tag;

public interface ArtDao {
	public List<Tag> getAllTags();
	public void createTag(Tag tag);
	public Tag getTag(Integer tagId);
	public List<Classified> getClassifieds(List<Integer> listTagsId);
	public List<Classified> getAllClassifieds();
	public void createClassified(Classified classified);

}
