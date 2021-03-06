package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import domain.RuralHouse;
import domain.Offer;
import dataAccess.*;

@WebService(endpointInterface = "businessLogic.OfferManager")
public class MyOfferManager implements OfferManager{
//ArrayList<RuralHouse> ruralHousessDB;
private RuralHouse_objectdbAccess ruralHousessDB;


public MyOfferManager () {
	
	ruralHousessDB = new RuralHouse_objectdbAccess();//ruralhouse sortzeko
	
	RuralHouse rh1 = ruralHousessDB.storeHouse("Donostia","Avenida, 7");

	ruralHousessDB.storeOffer(newDate(2016,1,1),3,3,0,rh1);  
	ruralHousessDB.storeOffer(newDate(2016,1,2),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,3),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,4),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,5),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,6),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,7),3,3,0,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,8),0,0,3,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,9),0,0,3,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,10),0,0,3,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,11),0,0,3,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,12),0,1,3,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,13),1,1,1,rh1);
	ruralHousessDB.storeOffer(newDate(2016,1,14),0,1,3,rh1);
	
	RuralHouse rh2 = ruralHousessDB.storeHouse("Donostia","San Martin, 13");
	ruralHousessDB.storeOffer(newDate(2016,1,2),1,1,1,rh2); 
	
	RuralHouse rh3 = ruralHousessDB.storeHouse("Bilbo","Zabalburu, 6");
	ruralHousessDB.storeOffer(newDate(2016,1,1),1,1,1,rh3);
	ruralHousessDB.storeOffer(newDate(2016,1,2),0,1,0,rh3);
	ruralHousessDB.storeOffer(newDate(2016,1,3),1,0,1,rh3);
	
	ruralHousessDB.close();		

	
}
		@WebMethod
		public Collection<Offer> getConcreteOffers(String city, Date date) {
			
				ArrayList<Offer> res = new ArrayList<Offer>();
				ArrayList<RuralHouse> rhdb = (ArrayList<RuralHouse>)ruralHousessDB.getAllHouses();
				for (RuralHouse rh : rhdb) 
					if ((rh.getCity().equals(city)))
						for (Offer off : rh.getOffers()) 
							if ((off.getDate().compareTo(date))==0) 
								res.add(off);
				ruralHousessDB.close();
				return res;	
		}
		
		private Date newDate(int year,int month,int day) {

		     Calendar calendar = Calendar.getInstance();
		     calendar.set(year, month, day,0,0,0);
		     calendar.set(Calendar.MILLISECOND, 0);

		     return calendar.getTime();
		}
		
}