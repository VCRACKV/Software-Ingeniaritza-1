package presentation;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import businessLogic.OfferManager;
import businessLogic.MyOfferManager;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;




import dataAccess.*;
import domain.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class OfferBooking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField city = null;
	private JLabel jLabel2 = null;
	private JTextField day = null;
	private JComboBox<String> month = null;
	private JTextField year = null;
	private JLabel roomType;
	private JRadioButton tripleRooms = null;
	private JRadioButton doubleRooms = null;
	private JRadioButton singleRooms = null;

	private ButtonGroup fareButtonGroup = new ButtonGroup();  //  @jve:decl-index=0:
	private JButton lookforOffers = null;

	private JButton bookOffer = null;


	private DefaultComboBoxModel<String> monthNames = new DefaultComboBoxModel<String>();

	private DefaultComboBoxModel<Offer> offerInfo = new DefaultComboBoxModel<Offer>();

	private Collection<Offer> coleccion;

	private OfferManager businessLogic;  //  @jve:decl-index=0:
	private JScrollPane offerListScrollPane = null;
	private JLabel monthLabel = null;
	private JLabel dayLabel = null;
	private JLabel searchResult = null;

	private Offer selectedOffer;
	private JComboBox<Offer> offerBox;
	/**
	 * This is the default constructor
	 */


	public OfferBooking() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		this.setSize(500, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("RuralHouses Offer Book");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			searchResult = new JLabel();
			searchResult.setBounds(new Rectangle(54, 176, 325, 20));
			searchResult.setHorizontalAlignment(SwingConstants.CENTER);
			searchResult.setHorizontalTextPosition(SwingConstants.CENTER);
			searchResult.setText("");
			dayLabel = new JLabel();
			dayLabel.setBounds(new Rectangle(342, 61, 50, 28));
			dayLabel.setText("Day:");
			monthLabel = new JLabel();
			monthLabel.setBounds(new Rectangle(126, 63, 52, 26));
			monthLabel.setText("Month:");
			roomType = new JLabel();
			roomType.setBounds(new Rectangle(6, 95, 90, 32));
			roomType.setText("Room Type:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(7, 63, 111, 28));
			jLabel2.setText("Year:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(6, 10, 137, 22));
			jLabel.setText("City:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getCity(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getDay(), null);
			jContentPane.add(getMonth(), null);
			jContentPane.add(getYear(), null);
			jContentPane.add(roomType, null);
			jContentPane.add(getTripleRooms(), null);
			jContentPane.add(getDoubleRooms(), null);
			jContentPane.add(getSingleRooms(), null);
			jContentPane.add(getLookForOffers(), null);
			jContentPane.add(getBookOffer(), null);
			//jContentPane.add(getOfferListScrollPane(), null);
			jContentPane.add(monthLabel, null);
			jContentPane.add(dayLabel, null);
			jContentPane.add(searchResult, null);
			jContentPane.add(getOfferBox());
		}
		return jContentPane;
	}

	/**
	 * This method initializes departingCity	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCity() {
		if (city == null) {
			city = new JTextField();
			city.setBounds(new Rectangle(98, 9, 294, 24));
		}
		return city;
	}

	/**
	 * This method initializes day	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDay() {
		if (day == null) {
			day = new JTextField();
			day.setBounds(new Rectangle(371, 63, 70, 29));
		}
		return day;
	}

	/**
	 * This method initializes month	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getMonth() {
		if (month == null) {
			month = new JComboBox<String>();
			month.setBounds(new Rectangle(170, 64, 165, 28));


			month.setModel(monthNames);
			monthNames.addElement("January");
			monthNames.addElement("February");
			monthNames.addElement("March");
			monthNames.addElement("April");
			monthNames.addElement("May");
			monthNames.addElement("June");
			monthNames.addElement("July");
			monthNames.addElement("August");
			monthNames.addElement("September");
			monthNames.addElement("October");
			monthNames.addElement("November");
			monthNames.addElement("December");


		}
		return month;
	}

	/**
	 * This method initializes year	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getYear() {
		if (year == null) {
			year = new JTextField();
			year.setBounds(new Rectangle(45, 64, 65, 30));
		}
		return year;
	}

	/**
	 * This method initializes business	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getTripleRooms() {
		if (tripleRooms == null) {
			tripleRooms = new JRadioButton();
			tripleRooms.setBounds(new Rectangle(98, 93, 80, 36));
			tripleRooms.setText("Triple");
			fareButtonGroup.add(tripleRooms);
		}
		return tripleRooms;
	}

	/**
	 * This method initializes first	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getDoubleRooms() {
		if (doubleRooms == null) {
			doubleRooms = new JRadioButton();
			doubleRooms.setBounds(new Rectangle(180, 97, 79, 29));
			doubleRooms.setText("Double");

			fareButtonGroup.add(doubleRooms);
		}
		return doubleRooms;
	}

	/**
	 * This method initializes tourist	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSingleRooms() {
		if (singleRooms == null) {
			singleRooms = new JRadioButton();
			singleRooms.setBounds(new Rectangle(271, 98, 121, 27));
			singleRooms.setSelected(true);
			singleRooms.setText("Single");
			fareButtonGroup.add(singleRooms);
		}
		return singleRooms;
	}

	public void setBusinessLogic(OfferManager g) {businessLogic = g;}

	/**
	 * This method initializes lookForOffers	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLookForOffers() {
		if (lookforOffers == null) {
			lookforOffers = new JButton();
			lookforOffers.setBounds(new Rectangle(81, 134, 264, 36));
			lookforOffers.setText("Look for Concrete Offers");
			lookforOffers.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bookOffer.setEnabled(true);
					offerInfo.removeAllElements();
					bookOffer.setText("");
					try{
						java.util.Date date =newDate(Integer.parseInt(year.getText()),month.getSelectedIndex(),Integer.parseInt(day.getText()));
						

						MyOfferManager offerm = new MyOfferManager();
						coleccion = offerm.getConcreteOffers(city.getText(), date);
						for (Offer v : coleccion)  offerInfo.addElement(v); 
						if (coleccion.isEmpty()) searchResult.setText("No offers in that city in that date");
						else searchResult.setText("Choose an available offer in this list:");
					}
					catch (NumberFormatException n){
						searchResult.setText("You must write a correct date!");
					}

				}
			});
		}
		return lookforOffers;
	}

	/**
	 * This method initializes jList1	
	 * 	
	 * @return javax.swing.JList	
	 */
	/**
	 * This method initializes getBookOffer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBookOffer() {
		if (bookOffer== null) {
			bookOffer = new JButton();
			bookOffer.setBounds(new Rectangle(22, 286, 413, 38));
			bookOffer.setEnabled(false);
			bookOffer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int num=0;
					boolean error=false;
					RuralHouse_objectdbAccess datubasea = new RuralHouse_objectdbAccess();
					if (tripleRooms.isSelected()) { 						
						num=datubasea.updateTriple(selectedOffer.getOfferNumber());
						if(num<0)error=true;
					}
					else if (doubleRooms.isSelected()) {
						num=datubasea.updateDouble(selectedOffer.getOfferNumber());
						if(num<0)error=true;
					}
					else if (singleRooms.isSelected()) {
						num=datubasea.updateSingle(selectedOffer.getOfferNumber());
						if(num<0)error=true;
					}
					if (error) bookOffer.setText("Error: There were no offers available!");
					else bookOffer.setText("Booked. #rooms left: "+(num));
					bookOffer.setEnabled(false);
					datubasea.close();
				}
			});
		}
		return bookOffer;
	}

	/**
	 * This method initializes offerListScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OfferBooking p = new OfferBooking();
		p.setBusinessLogic(new MyOfferManager());
		p.setVisible(true);

	}
	private Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);


		return calendar.getTime();
	}
	private JComboBox<Offer> getOfferBox() {
		if (offerBox == null) {
			offerBox = new JComboBox<Offer>();
			offerBox.setBounds(64, 204, 330, 32);
			offerBox.setModel(offerInfo);
			offerBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(offerBox.getItemCount()!=0){
						selectedOffer = (Offer) offerBox.getSelectedItem();
						int num=0;
						boolean error=false;
						if (tripleRooms.isSelected()) { 
							num=selectedOffer.getTripleNumber();
							if(num==0) error=true; else error=false;
						}
						else if (doubleRooms.isSelected()) {
							num=selectedOffer.getDoubleNumber();
							if(num==0) error=true; else error=false;
						}
						else if (singleRooms.isSelected()) {
							num=selectedOffer.getSingleNumber();
							if(num==0) error=true; else error=false;
						}
						if(error==true){
							bookOffer.setText("No available offers for this room type."); 
							bookOffer.setEnabled(false);
						} else{
							bookOffer.setText("Book this offer: "+selectedOffer);
							bookOffer.setEnabled(true);
						}
					}
				}
			});
		}
		return offerBox;
	}
}  //  @jve:decl-index=0:visual-constraint="18,9"

