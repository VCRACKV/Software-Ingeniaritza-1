package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dataAccess.*;
import domain.*;

@WebService(endpointInterface = "businessLogic.OfferManager")
public class MyOfferManager implements OfferManager{
	ArrayList<RuralHouse> ruralHousessDB;

	public MyOfferManager () {

		
		RuralHouse_objectdbAccess rhdb = new RuralHouse_objectdbAccess();
		
		Collection<Offer> db1 = new ArrayList<Offer>();
		RuralHouse rh1 = new RuralHouse("Donostia","Avenida, 7");


		rh1.addOffer(newDate(2016,1,1),3,3,0);  
		rh1.addOffer(newDate(2016,1,2),3,3,0);
		rh1.addOffer(newDate(2016,1,3),3,3,0);
		rh1.addOffer(newDate(2016,1,4),3,3,0);
		rh1.addOffer(newDate(2016,1,5),3,3,0);
		rh1.addOffer(newDate(2016,1,6),3,3,0);
		rh1.addOffer(newDate(2016,1,7),3,3,0);
		rh1.addOffer(newDate(2016,1,8),0,0,3);
		rh1.addOffer(newDate(2016,1,9),0,0,3);
		rh1.addOffer(newDate(2016,1,10),0,0,3);
		rh1.addOffer(newDate(2016,1,11),0,0,3);
		rh1.addOffer(newDate(2016,1,12),0,1,3);
		rh1.addOffer(newDate(2016,1,13),1,1,1);
		rh1.addOffer(newDate(2016,1,14),0,1,3);
		
		Collection<Offer> db2 = new ArrayList<Offer>();
		RuralHouse rh2 = new RuralHouse("Donostia","San Martin, 13");
		rh2.addOffer(newDate(2016,1,2),1,1,1);
		
		
		Collection<Offer> db3 = new ArrayList<Offer>();
		RuralHouse rh3 = new RuralHouse("Bilbo","Zabalburu, 6");
		rh3.addOffer(newDate(2016,1,1),1,1,1);
		rh3.addOffer(newDate(2016,1,2),0,1,0);
		rh3.addOffer(newDate(2016,1,3),1,0,1);

		db1.add(new Offer(newDate(2016,1,1),3,3,0,rh1,1));
		db1.add(new Offer(newDate(2016,1,2),3,3,0,rh1,2));
		db1.add(new Offer(newDate(2016,1,3),3,3,0,rh1,3));
		db1.add(new Offer(newDate(2016,1,4),3,3,0,rh1,4));
		db1.add(new Offer(newDate(2016,1,5),3,3,0,rh1,5));
		db1.add(new Offer(newDate(2016,1,6),3,3,0,rh1,6));
		db1.add(new Offer(newDate(2016,1,7),3,3,0,rh1,7));
		db1.add(new Offer(newDate(2016,1,8),0,0,3,rh1,8));
		db1.add(new Offer(newDate(2016,1,9),0,0,3,rh1,9));
		db1.add(new Offer(newDate(2016,1,10),0,0,3,rh1,10));
		db1.add(new Offer(newDate(2016,1,11),0,0,3,rh1,11));
		db1.add(new Offer(newDate(2016,1,12),0,1,3,rh1,12));
		db1.add(new Offer(newDate(2016,1,13),3,3,0,rh1,13));
		db1.add(new Offer(newDate(2016,1,14),0,1,3,rh1,14));

		db2.add(new Offer(newDate(2016,1,2),1,1,1,rh2,15));

		db3.add(new Offer(newDate(2016,1,1),1,1,1,rh3,16));
		db3.add(new Offer(newDate(2016,1,2),0,1,0,rh3,17));
		db3.add(new Offer(newDate(2016,1,3),1,0,1,rh3,18));
	
		//¡¡¡¡¡¡¡OSO IMPORTANTEA!!!!!!!	
		//Behin datuak datu basean kargatuta beheko hiru hauek komentario moduan jarri bestela berriz saiatuko da satzen
		
		rhdb.storeHouse(rh1);
		rhdb.storeHouse(rh2);
		rhdb.storeHouse(rh3);
		


	}
	@WebMethod
	public Collection<Offer> getConcreteOffers(String city, Date date) {

		ArrayList<Offer> res = new ArrayList<Offer>();
		for (RuralHouse rh : ruralHousessDB) 
			if ((rh.getCity().equals(city)))
				for (Offer off : rh.getOffers()) 
					if ((off.getDate().compareTo(date))==0) 
						res.add(off);
		return res;	
	}

	private Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}