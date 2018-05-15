package com.paie.calcul_paie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.paie.calcul_paie.model.Employes;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbpam_hibernate");
		// premier essai
		EntityManager em = emf.createEntityManager();
		Employes Employes = (Employes) em.createQuery("select e from Employes e where e.nom=:nom")
				.setParameter("nom", "Jouveinal").getSingleResult();
		em.close();
		// on affiche l'employé
		try {
			System.out.println("Employé=" + Employes);
		} catch (Exception ex) {
			System.out.println("L'erreur suivante s'est produite : " + ex);
		}
		// deuxième essai
		em = emf.createEntityManager();
		Employes = (Employes) em.createQuery("select e from Employes e left join fetch e.indemnites where e.nom=:nom")
				.setParameter("nom", "Jouveinal").getSingleResult();
		// libérer les ressources
		em.close();
		// on affiche l'employé
		try {
			System.out.println("Employé=" + Employes);
		} catch (Exception ex) {
			System.out.println("L'erreur suivante s'est produite : " + ex);
		}
		// libération
	}
}
