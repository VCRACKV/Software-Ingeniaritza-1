package dataAccess;

import java.awt.List;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.*;
import businessLogic.*;
import presentation.*;

import domain.Offer;
import domain.RuralHouse;

public class RuralHouse_objectdbAccess {
	private EntityManager db;
	private EntityManagerFactory emf;
	String fileName = "ruralHousessDB.odb";

	public RuralHouse_objectdbAccess() {
		emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db = emf.createEntityManager();
		System.out.println("DataBase opened");
	}
	//klaseko datubase metodoak
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	public RuralHouse storeHouse(String city, String address) {
		db.getTransaction().begin();
		RuralHouse house = new RuralHouse(city, address);
		db.persist(house);
		db.getTransaction().commit();
		System.out.println("Insertado: " + house);
		return house;
	}

	

	public void storeOffer(Date date, int tripleNumber, int doubleNumber, int singleNumber, RuralHouse rh) {
		db.getTransaction().begin();
		Offer oferta = new Offer(date, tripleNumber, doubleNumber, singleNumber, rh);
		rh.add(oferta);
		db.persist(oferta);
		db.getTransaction().commit();
		System.out.println("Oferta sartu da: " + oferta);

	}

	

	public List<RuralHouse> getAllHouses() {
		TypedQuery<RuralHouse> query = db.createQuery("SELECT rh FROM RuralHouse rh", RuralHouse.class);
		List<RuralHouse> rh = query.getResultList();
		System.out.println("Datu basean dagoena:");
		for (RuralHouse casa : rh)
			System.out.println(casa.toString());

		return rh;
	}
}