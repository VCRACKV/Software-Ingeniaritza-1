package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Offer implements Serializable  {
	private Date date;
	private static int numOffer=1;
	
	private Integer offerNumber;
	private int tripleNumber;
	private int doubleNumber;
	private int singleNumber;
	@XmlIDREF
	private RuralHouse rh;

	public Offer(Date date, int tripleNumber, int doubleNumber, int singleNumber, RuralHouse rh, int offerNum) {
		super();
		this.date = date;
		this.tripleNumber = tripleNumber;
		this.doubleNumber = doubleNumber;
		this.singleNumber = singleNumber;
		this.rh = rh;
		this.offerNumber=Offer.numOffer++;
		this.offerNumber = offerNum;
	}
	public Offer(Date date, int tripleNumber, int doubleNumber, int singleNumber, RuralHouse rh) {
		super();
		this.date = date;
		this.tripleNumber = tripleNumber;
		this.doubleNumber = doubleNumber;
		this.singleNumber = singleNumber;
		this.rh=rh;
		this.offerNumber=Offer.numOffer++;
		
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOfferNumber(){
		return this.offerNumber;
	}
	public int getTripleNumber() {
		return tripleNumber;
	}
	public void setTripleNumber(int tripleNumber) {
		this.tripleNumber = tripleNumber;
	}
	public int getDoubleNumber() {
		return doubleNumber;
	}
	public void setDoubleNumber(int doubleNumber) {
		this.doubleNumber = doubleNumber;
	}
	public int getSingleNumber() {
		return singleNumber;
	}
	public void setSingleNumber(int singleNumber) {
		this.singleNumber = singleNumber;
	}
	public RuralHouse getRuralHouse(){
		return this.rh;
	}
	
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return rh.toString()+"/ "+df.format(date);}
}


