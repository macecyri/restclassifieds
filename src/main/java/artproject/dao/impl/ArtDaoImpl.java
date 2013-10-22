package artproject.dao.impl;

import java.util.List;

import lombok.Data;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import artproject.dao.ArtDao;
import artproject.model.Cal;
import artproject.model.Classified;
import artproject.model.Dep;
import artproject.model.Post;
import artproject.model.Tag;

@Component
@Data
@Transactional
@SuppressWarnings("unchecked")
public class ArtDaoImpl implements ArtDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Tag> getAllTags() {
		return sessionFactory.getCurrentSession().createQuery("from Tag")
				.list();
	}
	
	public List<Dep> getAllDeps() {
		return sessionFactory.getCurrentSession().createQuery("from Dep")
				.list();
	}
	
	public List<Cal> getAllCals() {
		return sessionFactory.getCurrentSession().createQuery("from Cal")
				.list();
	}

	public Tag getTag(Integer tagId) {
		return (Tag) sessionFactory.getCurrentSession().get(Tag.class, tagId);
	}
	
	public Dep getDep(Integer depId) {
		return (Dep) sessionFactory.getCurrentSession().get(Dep.class, depId);
	}
	
	public Cal getCal(Integer calId) {
		return (Cal) sessionFactory.getCurrentSession().get(Cal.class, calId);
	}
	
	public Classified getClassified(Integer classifiedId) {
		Classified classified =  (Classified) sessionFactory.getCurrentSession().get(Classified.class, classifiedId);
		Hibernate.initialize(classified.getRelatedTags());
		Hibernate.initialize(classified.getRelatedDeps());
		Hibernate.initialize(classified.getRelatedCals());
		return classified;
	}

	public void createTag(Tag tag) {
		sessionFactory.getCurrentSession().save(tag);
	}

	public List<Classified> getAllClassifieds() {
		List<Classified> listClassifieds = sessionFactory.getCurrentSession()
				.createQuery("from Classified").list();
		for (Classified classified : listClassifieds) {
			Hibernate.initialize(classified.getRelatedTags());
			Hibernate.initialize(classified.getRelatedDeps());
			Hibernate.initialize(classified.getRelatedCals());
		}
		return listClassifieds;
	}

	public List<Classified> getClassifieds(List<Integer> listTagsId) {
		Criteria criteria = sessionFactory
				.getCurrentSession()
				.createCriteria(Classified.class, "classified")
				.createAlias("classified.relatedTags", "relatedTags")
				.createAlias("classified.relatedDeps", "relatedDeps")
				.createAlias("classified.relatedCals", "relatedCals")
				.setResultTransformer(
						CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<Classified> listClassifieds = criteria.add(
				Restrictions.in("relatedTags.id", listTagsId)).add(
						Restrictions.in("relatedDeps.id", listTagsId)).add(
								Restrictions.in("relatedCals.id", listTagsId)).list();

		for (Classified classified : listClassifieds) {
			Hibernate.initialize(classified.getRelatedTags());
			Hibernate.initialize(classified.getRelatedDeps());
			Hibernate.initialize(classified.getRelatedCals());
		}
		return listClassifieds;
	}

	public void createClassified(Classified classified) {
		sessionFactory.getCurrentSession().save(classified);
	}
	
	public List<Post>  getAllPostsClassified(Integer classifiedId){
		Criteria criteria = sessionFactory
				.getCurrentSession()
				.createCriteria(Post.class, "classified")
				.add(Restrictions.eq("classifiedId", classifiedId));
		
		return criteria.list();
	}
	
	public void createPost(Post post){
		sessionFactory.getCurrentSession().save(post);
	}

}
