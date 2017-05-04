package domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class RuralHouse implements Serializable  {

	private static int numberOfHouses=1;
	
	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer houseNumber;
	private String city;
	private String address;
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Offer> offers;



	public RuralHouse(String city,String address, Integer num, Collection<Offer> offers) {
		super();
		houseNumber=num;
		this.city = city;
		this.address=address;
		this.offers=offers;

	}
	public RuralHouse(String city,String address) {
		super();
		houseNumber=RuralHouse.numberOfHouses++;
		this.city = city;
		this.address=address;
		this.offers = new ArrayList<Offer>();
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void add(Offer o){
		offers.add(o);
	}

	public Collection<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Collection<Offer> offers) {
		this.offers = offers;
	}
	public String toString() {return houseNumber+"/"+city+"/"+address;}

	public Offer addOffer(Date date, int tripleNumber, int doubleNumber, int singleNumber){
		Offer o=new Offer(date, tripleNumber, doubleNumber, singleNumber, this);
		offers.add(o);
		return o;
	}
}
