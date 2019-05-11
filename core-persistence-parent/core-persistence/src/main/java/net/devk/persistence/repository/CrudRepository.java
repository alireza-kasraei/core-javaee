package net.devk.persistence.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import javax.swing.SortOrder;

import net.devk.commons.data.Page;
import net.devk.commons.data.Pageable;
import net.devk.persistence.entity.AbstractPersistableEntity;

public interface CrudRepository<E extends AbstractPersistableEntity<U>, U extends Serializable> {

	/**
	 * Make an entity instance managed and persistent.
	 *
	 * @param entity
	 * @throws EntityExistsException
	 *             - if the entity already exists. (The EntityExistsException may be
	 *             thrown when the persist operation is invoked, or the
	 *             EntityExistsException or another PersistenceException may be
	 *             thrown at flush or commit time.)
	 * @throws IllegalStateException
	 *             - if this EntityManager has been closed.
	 * @throws IllegalArgumentException
	 *             - if not an entity
	 * @throws TransactionRequiredException
	 *             - if invoked on a container-managed entity manager of type
	 *             PersistenceContextType.TRANSACTION and there is no transaction.
	 */
	public void save(E entity);

	public void update(E e);

	public void remove(E e);
	
	public void remove(U id);

	public E findOne(U id);

	public E getOne(U id);

	public List<E> findAll();

	public Page<E> findAll(Pageable pageable);

	public Number countAll();

	public List<E> findAll(int pageSize, int pageNumber);

	public List<E> findByExample(E example);

	public List<E> findByExample(E example, Map<String, SortOrder> sortMap, int startIndex, int pageSize);

	public Number countByExample(E example, String countFieldName);

	/**
	 * Check if the instance belongs to the current persistence context.
	 *
	 * @param entity
	 * @return true if the instance belongs to the current persistence context.
	 * @throws IllegalStateException
	 *             if this EntityManager has been closed.
	 * @throws IllegalArgumentException
	 *             if not an entity
	 */
	boolean contains(E entity);

}
