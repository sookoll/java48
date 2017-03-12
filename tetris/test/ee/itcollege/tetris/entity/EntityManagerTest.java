package ee.itcollege.tetris.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;


public class EntityManagerTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("top10");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		Player player = new Player();
		player.setName("Mati");
		player.setPoints((int)(Math.random() * 100));
		em.persist(player);
		tr.commit();
		
		
		List<Player> players = em.createQuery("from Player", Player.class).getResultList();
		
		em.close();
		emf.close();
		
		for (Player p : players) {
			System.out.println(p);
		}
		
		int howManyDeleted = em.createQuery("delete from Player").executeUpdate();
		
	}
}
