package com.amal.test;

import com.amal.dao.PieceTHDao;
import com.amal.entities.PieceTH;

public class PieceTest {

	public static void main(String[] args) {
		//créer un objet client
		PieceTH c = new PieceTH();
		c.setNom("romio et juliette");
		c.setAuteur("William Shakespeare");
		
		PieceTH c1 = new PieceTH();
		c1.setNom("Hamlet");
		c1.setAuteur("William Shakespeare");
		
		PieceTH c2 = new PieceTH();
		c2.setNom("Antigone");
		c2.setAuteur("William Shakespeare");
		
		//ajouter l'objet client à la BD
		PieceTHDao cltDao = new PieceTHDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c1);
		cltDao.ajouter(c2);
		System.out.println("Appel de la méthode listerTous");
		for (PieceTH cl : cltDao.listerTous())
		System.out.println(cl.getCode()+" "+cl.getNom());
		System.out.println("Appel de la méthode listerParNom");
		for (PieceTH cl : cltDao.listerParNom("ro"))

		System.out.println(cl.getCode()+" "+cl.getNom());
		//supprimer
		System.out.println("supprision de la piece hamlet ");
		cltDao.supprimer(c1);
		//modifier
		System.out.println("modification de la piece romio et juliette ");
		c.setNom("Romio et Juliette");
		cltDao.modifier(c);
		}

	}


