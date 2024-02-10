/**
 * @author Nicole Puente - npuente
 * CIS175 - Spring 2024
 * Feb 2, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.RoastInventory;

public class RoastInventoryHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeBeanOrders");

	public void addRoast(RoastInventory roastItem) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(roastItem);
		em.getTransaction().commit();
		em.close();

	}
	
	/**
	 * @return
	 */
	public List<RoastInventory> showAllRoasts() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<RoastInventory> allRoasts = em.createQuery("SELECT i FROM RoastInventory i").getResultList();
		return allRoasts;
	}

	
	public void deleteRoast(RoastInventory toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<RoastInventory> typedQuery = em.createQuery(
				"SELECT roastItem FROM RoastInventory roastItem WHERE roastItem.roastName = :selectedRoastName and roastItem.roastType = :selectedRoastType",
				RoastInventory.class);

		typedQuery.setParameter("selectedRoastName", toDelete.getRoastName());
		typedQuery.setParameter("selectedRoastType", toDelete.getRoastType());
		typedQuery.setMaxResults(1);

		RoastInventory result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateRoast(RoastInventory toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param roastName
	 * @return
	 */
	public List<RoastInventory> searchRoastName(String roastName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RoastInventory> typedQuery = em.createQuery(
				"SELECT roastItem FROM RoastInventory roastItem WHERE roastItem.roastName = :selectedRoastName",
				RoastInventory.class);
		typedQuery.setParameter("selectedRoastName", roastName);
		List<RoastInventory> foundItem = typedQuery.getResultList();
		em.close();
		return foundItem;
		
	}

	/**
	 * @param TypeName
	 * @return
	 */
	public List<RoastInventory> searchRoastType(String roastType) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RoastInventory> typedQuery = em.createQuery(
				"SELECT roastItem FROM RoastInventory roastItem WHERE roastItem.roastType = :selectedRoastType",
				RoastInventory.class);
		typedQuery.setParameter("selectedRoastType", roastType);
		List<RoastInventory> foundItem = typedQuery.getResultList();
		em.close();
		return foundItem;
	}

	/**
	 * @param idEdit
	 * @return
	 */
	public RoastInventory SearchRoastId(int idEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RoastInventory found = em.find(RoastInventory.class, idEdit);
		em.close();
		return found;
	}
	
	//close the entity manager factory once the program is done running
	public void cleanUp() {
		emfactory.close();
	}


}
