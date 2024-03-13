package com.amal.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.amal.entities.PieceTH;
import com.amal.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)

public class PieceTHDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA");
			
	//méthode ajouter d'une entité à la bd
	public void ajouter(PieceTH c)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(PieceTH c)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(PieceTH c)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c=entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public PieceTH consulter(PieceTH c,Object id)
	{
		return entityManager.find(c.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<PieceTH> listerTous() {
		List<PieceTH> PieceTHs =entityManager.createQuery("select c from PieceTH c").getResultList();
	
		return PieceTHs;
	}
	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<PieceTH> listerParNom(String nom) {
		List<PieceTH> PieceTHs=entityManager.createQuery( "select c from PieceTH c where c.nom like :pnom").setParameter("pnom","%"+nom+"%").getResultList();

	return PieceTHs; }
	}

