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
import artproject.model.Classified;
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

	public Tag getTag(Integer tagId) {
		return (Tag) sessionFactory.getCurrentSession().get(Tag.class, tagId);
	}

	public void createTag(Tag tag) {
		sessionFactory.getCurrentSession().save(tag);
	}

	public List<Classified> getAllClassifieds() {
		List<Classified> listClassifieds = sessionFactory.getCurrentSession()
				.createQuery("from Classified").list();
		for (Classified classified : listClassifieds) {
			Hibernate.initialize(classified.getRelatedTags());
		}
		return listClassifieds;
	}

	public List<Classified> getClassifieds(List<Integer> listTagsId) {
		Criteria criteria = sessionFactory
				.getCurrentSession()
				.createCriteria(Classified.class, "classified")
				.createAlias("classified.relatedTags", "relatedTags")
				.setResultTransformer(
						CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<Classified> listClassifieds = criteria.add(
				Restrictions.in("relatedTags.id", listTagsId)).list();

		for (Classified classified : listClassifieds) {
			Hibernate.initialize(classified.getRelatedTags());
		}
		return listClassifieds;
	}

	public void createClassified(Classified classified) {
		sessionFactory.getCurrentSession().save(classified);
	}

}
