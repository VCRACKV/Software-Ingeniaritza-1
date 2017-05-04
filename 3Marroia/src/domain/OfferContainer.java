package domain;


import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferContainer {
	private Offer o;
	private RuralHouse rh;
	
	public OfferContainer(Offer o) {
		this.o = o;
		this.rh=o.getRuralHouse(); }
	
	public OfferContainer() {
		o = null;
		rh = null; }
	
	public Offer getOffer(){
		return o; }
	
	public RuralHouse getRuralHouse(){
		return rh; }
	
	public String toString(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return this.rh.toString()+"/ "+df.format(this.o.getDate());}
}