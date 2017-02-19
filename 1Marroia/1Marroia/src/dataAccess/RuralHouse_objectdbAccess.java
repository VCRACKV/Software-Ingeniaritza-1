package dataAccess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domain.*;


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
//RuralHousak datu basean gordetzeko
	public void storeHouse(RuralHouse rh) {
		db.getTransaction().begin();
		db.persist(rh);
		db.getTransaction().commit();
		System.out.println("Etxea sartu da: " + rh);
	}
	
//Triple motako gelak aktualizatzeko
	public int updateTriple(int offerNum){
		TypedQuery<Offer> query = db.createQuery("SELECT p FROM Offer p",Offer.class);
		List<Offer> offers = query.getResultList();
		int num=-1;
		for(Offer off : offers){
			if(off.getOfferNumber()==offerNum){
				num=off.getTripleNumber()-1;
				db.getTransaction().begin();
				off.setTripleNumber(off.getTripleNumber()-1);
				db.getTransaction().commit();
			}
		}
		return num;
	}
	//Double motako gelak aktualizatzeko
	public int updateDouble(int offerNum){
		TypedQuery<Offer> query = db.createQuery("SELECT p FROM Offer p",Offer.class);
		List<Offer> offers = query.getResultList();
		int num=-1;
		for(Offer off : offers){
			if(off.getOfferNumber()==offerNum){
				num=off.getDoubleNumber()-1;
				db.getTransaction().begin();
				off.setDoubleNumber(off.getDoubleNumber()-1);
				db.getTransaction().commit();
			}
		}
		return num;
	}
	//Single motako gelak aktualizatzeko
	public int updateSingle(int offerNum){
		TypedQuery<Offer> query = db.createQuery("SELECT p FROM Offer p",Offer.class);
		List<Offer> offers = query.getResultList();
		int num=-1;
		for(Offer off : offers){
			if(off.getOfferNumber()==offerNum){
				num=off.getSingleNumber()-1;
				db.getTransaction().begin();
				off.setSingleNumber(off.getSingleNumber()-1);
				db.getTransaction().commit();
			}
		}
		return num;
	}
	//MyOfferreko metodoa baino Datu basetik atzitzen
	@WebMethod
	public Collection<Offer> getConcreteOffers(String city, Date date) {
		TypedQuery<RuralHouse> query = db.createQuery("SELECT p FROM RuralHouse p",RuralHouse.class);
		ArrayList<Offer> res = new ArrayList<Offer>();
		List<RuralHouse> rhs = query.getResultList();
		for (RuralHouse rh : rhs) 
			if ((rh.getCity().equals(city)))
				for (Offer off : rh.getOffers()) 
					if ((off.getDate().compareTo(date))==0) 
						res.add(off);
		return res;	
	}
}
