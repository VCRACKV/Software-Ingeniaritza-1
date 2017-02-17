package dataAccess;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Offer;
import domain.RuralHouse;

public class Offer_objectdbAccess {
	private EntityManager db;
	private EntityManagerFactory emf;
	String fileName = "offers.odb";

	public Offer_objectdbAccess() {
		emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db = emf.createEntityManager();
		System.out.println("DataBase opened");
	}
	//klaseko datubase metodoak
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}


	public void storeOffer (Date date, int tripleNumber, int doubleNumber, int singleNumber, RuralHouse rh, int offerNum){
		db.getTransaction().begin();
		Offer offer = new Offer(date, tripleNumber, doubleNumber, singleNumber, rh);
		db.persist(offer);
		db.getTransaction().commit();
		System.out.println("Gordeta " + offer);	
	}
	
	

	public void updateOffer(Date date, int tripleNumber, int doubleNumber, int singleNumber, RuralHouse rh) {
		Offer offer=getPilotByZenb(name);
		if (pilot==null)
			System.out.println(name + " it is not in the database");
		else {
			db.getTransaction().begin();
			pilot.addPoints(points);
			db.getTransaction().commit();
			System.out.println(pilot + " has been updated");
		}
	}
}

