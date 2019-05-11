package net.devk.persistence.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.SortOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devk.commons.data.Page;
import net.devk.commons.data.PageImpl;
import net.devk.commons.data.Pageable;
import net.devk.commons.exception.DataAccessException;
import net.devk.persistence.entity.AbstractPersistableEntity;

/**
 * base repository implementation , it supports basic CRUD operations.
 *
 * @param <E>
 *            entity class generic type
 * @param <U>
 *            primary key generic type
 */
// TODO FIXME rename it to AbstractCrudRepository
public abstract class AbstractCrudRepository<E extends AbstractPersistableEntity<U>, U extends Serializable>
		implements CrudRepository<E, U> {

	protected static final Logger log = LoggerFactory.getLogger(AbstractCrudRepository.class);

	/**
	 * produced by the application
	 */
	protected EntityManager entityManager;
	protected Class<E> entityClass;

	public AbstractCrudRepository() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] fieldArgTypes = pt.getActualTypeArguments();
			entityClass = (Class<E>) fieldArgTypes[0];
		}
	}

	@Inject
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(E e) {
		entityManager.merge(e);
	}

	@Override
	public void remove(E e) {
		entityManager.remove(e);
	}

	@Override
	public void remove(U id) {
		Query query = entityManager.createQuery("delete from " + entityClass.getName() + " e where e.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public E findOne(U id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public E getOne(U id) {
		return entityManager.getReference(entityClass, id);
	}

	@Override
	public List<E> findAll() {
		CriteriaQuery<E> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<E> findAll(int pageSize, int pageNumber) {
		CriteriaQuery<E> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		TypedQuery<E> query = entityManager.createQuery(cq);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		// counts all entities
		Number totalCount = countAll();
		List<E> resultList = null;
		if (totalCount.longValue() != 0) {
			CriteriaQuery<E> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
			cq.select(cq.from(entityClass));
			TypedQuery<E> query = entityManager.createQuery(cq);
			query.setFirstResult(pageable.getFirstRecordNumber());
			query.setMaxResults(pageable.getPageSize());
			resultList = query.getResultList();
		} else {
			resultList = new ArrayList<E>();
		}
		return new PageImpl<>(resultList, totalCount.longValue(), pageable.getPageNumber(), pageable.getPageSize());

	}

	@Override
	public Number countAll() {
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(entityClass)));
		return entityManager.createQuery(cq).getSingleResult();
	}

	@Override
	public List<E> findByExample(E example) {
		try {
			Object object = example;
			String query = "SELECT e from " + object.getClass().getName() + " e where 1 = 1";
			for (Field field : object.getClass().getDeclaredFields()) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							query += " and e." + field.getName() + " LIKE :" + field.getName();
						} else if (!(fieldValue instanceof String)) {
							query += " and e." + field.getName() + " = :" + field.getName();
						}
					}
				}
			}

			Query q = entityManager.createQuery(query, object.getClass());

			for (Field field : object.getClass().getDeclaredFields()) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							q.setParameter(field.getName(), "%" + field.get(object) + "%");
						} else if (!(fieldValue instanceof String)) {
							q.setParameter(field.getName(), field.get(object));
						}
					}
				}
			}
			return q.getResultList();

		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {

			log.error(e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public List<E> findByExample(E example, Map<String, SortOrder> sortMap, int startIndex, int pageSize) {
		try {
			Object object = example;
			String query = "SELECT e from " + object.getClass().getName() + " e where 1 = 1";
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							query += " and e." + field.getName() + " LIKE :" + field.getName();
						} else if (!(fieldValue instanceof String)) {
							query += " and e." + field.getName() + " = :" + field.getName();
						}
					}
				}
			}
			if (sortMap != null && !sortMap.isEmpty()) {
				for (Map.Entry<String, SortOrder> entry : sortMap.entrySet()) {
					query += " ORDER BY e." + entry.getKey() + " " + entry.getValue().name();
				}
			}
			Query q = entityManager.createQuery(query, object.getClass());

			for (Field field : fields) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							q.setParameter(field.getName(), "%" + field.get(object) + "%");
						} else if (!(fieldValue instanceof String)) {
							q.setParameter(field.getName(), field.get(object));
						}
					}
				}
			}
			return q.setFirstResult(startIndex).setMaxResults(pageSize).getResultList();

		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			log.error(e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public Number countByExample(E example, String countFieldName) {
		try {
			Object object = example;
			String query = "SELECT COUNT(e." + countFieldName + ") from " + object.getClass().getName()
					+ " e where 1 = 1";
			for (Field field : object.getClass().getDeclaredFields()) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							query += " and e." + field.getName() + " LIKE :" + field.getName();
						} else if (!(fieldValue instanceof String)) {
							query += " and e." + field.getName() + " = :" + field.getName();
						}
					}
				}
			}

			Query q = entityManager.createQuery(query, Long.class);

			for (Field field : object.getClass().getDeclaredFields()) {
				Object fieldValue;
				field.setAccessible(true);
				if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
						|| field.getName().startsWith("_")) {
					continue;
				} else {
					fieldValue = field.get(object);
					if (fieldValue != null) {
						if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
							q.setParameter(field.getName(), "%" + field.get(object) + "%");
						} else if (!(fieldValue instanceof String)) {
							q.setParameter(field.getName(), field.get(object));
						}
					}
				}
			}
			return (Long) q.getSingleResult();

		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			log.error(e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public boolean contains(E entity) {
		return entityManager.contains(entity);
	}

}