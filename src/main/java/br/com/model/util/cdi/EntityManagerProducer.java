package br.com.model.util.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

	
	@PersistenceContext
	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("hermesPU");
	}
	
	@Produces
	@Default
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes @Default EntityManager manager) {
		if(manager.isOpen()){
			manager.close();
		}
		
	}
 
}