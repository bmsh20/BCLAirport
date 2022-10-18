import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;

public class DepartureInterface extends JFrame {

	private JPanel contentPane;
	private JTable delayedDeparturetbl;
	private JTable londonDeparturetbl;
	private JTable allFlightsTbl;
	private Timer oneSInterval = new Timer();
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DepartureFilter filterInstance = new DepartureFilter();
	private ArrayList<FlightDeparture> bottomList = new ArrayList<FlightDeparture>();
	private ArrayList<FlightDeparture> delayedList = new ArrayList<FlightDeparture>();
	private ArrayList<FlightDeparture> londonList = new ArrayList<FlightDeparture>();
	private ArrayList<FlightDeparture> filterCodeList = new ArrayList<FlightDeparture>();
	private ArrayList<FlightDeparture> filterDayList = new ArrayList<FlightDeparture>();
	private ArrayList<FlightDeparture> filterTimeList = new ArrayList<FlightDeparture>();

	/**
	 * Create the frame.
	 */
	public DepartureInterface() {
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 923);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(16, 60, 841, 563);
		contentPane.add(mapPanel);
		mapPanel.setLayout(null);
		
		JPanel allFlightsPanel = new JPanel();
		allFlightsPanel.setBounds(18, 629, 839, 243);
		contentPane.add(allFlightsPanel);
		allFlightsPanel.setBackground(Color.BLACK);
		allFlightsPanel.setLayout(null);
		
		JLabel airportLabel = new JLabel("Hover on an airport label to view departures of the day");
		airportLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		airportLabel.setHorizontalAlignment(SwingConstants.LEFT);
		airportLabel.setForeground(Color.WHITE);
		airportLabel.setBounds(10, 6, 807, 33);
		allFlightsPanel.add(airportLabel);
		
		JLabel londonMapLabel = new JLabel("BCL");
		londonMapLabel.setForeground(new Color(0, 51, 153));
		londonMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		londonMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		londonMapLabel.setBounds(355, 113, 39, 21);
		mapPanel.add(londonMapLabel);
		addLabelHoverEvent(londonMapLabel, airportLabel, allFlightsPanel);
		
		JLabel hkMapLabel = new JLabel("HKG");
		hkMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hkMapLabel.setForeground(new Color(0, 51, 153));
		hkMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		hkMapLabel.setBounds(652, 221, 39, 21);
		mapPanel.add(hkMapLabel);
		addLabelHoverEvent(hkMapLabel, airportLabel, allFlightsPanel);
		
		JLabel tokyoMapLabel = new JLabel("HND");
		tokyoMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tokyoMapLabel.setForeground(new Color(0, 51, 153));
		tokyoMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		tokyoMapLabel.setBounds(727, 163, 39, 21);
		mapPanel.add(tokyoMapLabel);
		addLabelHoverEvent(tokyoMapLabel, airportLabel, allFlightsPanel);
		
		JLabel dubaiMapLabel = new JLabel("DXB");
		dubaiMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dubaiMapLabel.setForeground(new Color(0, 51, 153));
		dubaiMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		dubaiMapLabel.setBounds(506, 214, 39, 21);
		mapPanel.add(dubaiMapLabel);
		addLabelHoverEvent(dubaiMapLabel, airportLabel, allFlightsPanel);
		
		JLabel madridMapLabel = new JLabel("MAD");
		madridMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		madridMapLabel.setForeground(new Color(0, 51, 153));
		madridMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		madridMapLabel.setBounds(363, 159, 39, 21);
		mapPanel.add(madridMapLabel);
		addLabelHoverEvent(madridMapLabel, airportLabel, allFlightsPanel);
		
		JLabel nycMapLabel = new JLabel("JFK");
		nycMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nycMapLabel.setForeground(new Color(0, 51, 153));
		nycMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		nycMapLabel.setBounds(168, 149, 39, 21);
		mapPanel.add(nycMapLabel);
		addLabelHoverEvent(nycMapLabel, airportLabel, allFlightsPanel);
		
		JLabel romeMapLabel = new JLabel("FCO");
		romeMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		romeMapLabel.setForeground(new Color(0, 51, 153));
		romeMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		romeMapLabel.setBounds(401, 148, 39, 21);
		mapPanel.add(romeMapLabel);
		addLabelHoverEvent(romeMapLabel, airportLabel, allFlightsPanel);
		
		JLabel sydneyMapLabel = new JLabel("SYD");
		sydneyMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sydneyMapLabel.setForeground(new Color(0, 51, 153));
		sydneyMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		sydneyMapLabel.setBounds(753, 448, 39, 21);
		mapPanel.add(sydneyMapLabel);
		addLabelHoverEvent(sydneyMapLabel, airportLabel, allFlightsPanel);
		
		JLabel delhiMapLabel = new JLabel("DEL");
		delhiMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		delhiMapLabel.setForeground(new Color(0, 51, 153));
		delhiMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		delhiMapLabel.setBounds(568, 204, 39, 21);
		mapPanel.add(delhiMapLabel);
		addLabelHoverEvent(delhiMapLabel, airportLabel, allFlightsPanel);
		
		JLabel saopaoloMapLabel = new JLabel("GRU");
		saopaoloMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saopaoloMapLabel.setForeground(new Color(0, 51, 153));
		saopaoloMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		saopaoloMapLabel.setBounds(230, 405, 39, 21);
		mapPanel.add(saopaoloMapLabel);
		addLabelHoverEvent(saopaoloMapLabel, airportLabel, allFlightsPanel);
		
		JLabel torontoMapLabel = new JLabel("YYZ");
		torontoMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		torontoMapLabel.setForeground(new Color(0, 51, 153));
		torontoMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		torontoMapLabel.setBounds(157, 119, 39, 21);
		mapPanel.add(torontoMapLabel);
		addLabelHoverEvent(torontoMapLabel, airportLabel, allFlightsPanel);
		
		JLabel mexicoMapLabel = new JLabel("MEX");
		mexicoMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mexicoMapLabel.setForeground(new Color(0, 51, 153));
		mexicoMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		mexicoMapLabel.setBounds(84, 240, 39, 21);
		mapPanel.add(mexicoMapLabel);
		addLabelHoverEvent(mexicoMapLabel, airportLabel, allFlightsPanel);
		
		JLabel swedenMapLabel = new JLabel("ARN");
		swedenMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		swedenMapLabel.setForeground(new Color(0, 51, 153));
		swedenMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		swedenMapLabel.setBounds(404, 69, 39, 21);
		mapPanel.add(swedenMapLabel);
		addLabelHoverEvent(swedenMapLabel, airportLabel, allFlightsPanel);
		
		JLabel cairoMapLabel = new JLabel("CAI");
		cairoMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cairoMapLabel.setForeground(new Color(0, 51, 153));
		cairoMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		cairoMapLabel.setBounds(438, 206, 39, 21);
		mapPanel.add(cairoMapLabel);
		addLabelHoverEvent(cairoMapLabel, airportLabel, allFlightsPanel);
		
		JLabel lagosMapLabel = new JLabel("LOS");
		lagosMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lagosMapLabel.setForeground(new Color(0, 51, 153));
		lagosMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lagosMapLabel.setBounds(378, 282, 39, 21);
		mapPanel.add(lagosMapLabel);
		addLabelHoverEvent(lagosMapLabel, airportLabel, allFlightsPanel);
		
		JLabel moscowMapLabel = new JLabel("SVO");
		moscowMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moscowMapLabel.setForeground(new Color(0, 51, 153));
		moscowMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		moscowMapLabel.setBounds(454, 90, 39, 21);
		mapPanel.add(moscowMapLabel);
		addLabelHoverEvent(moscowMapLabel, airportLabel, allFlightsPanel);
		
		JLabel marrakeshMapLabel = new JLabel("RAK");
		marrakeshMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marrakeshMapLabel.setForeground(new Color(0, 51, 153));
		marrakeshMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		marrakeshMapLabel.setBounds(340, 189, 39, 21);
		mapPanel.add(marrakeshMapLabel);
		addLabelHoverEvent(marrakeshMapLabel, airportLabel, allFlightsPanel);
		
		JLabel lasvegasMapLabel = new JLabel("LVS");
		lasvegasMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lasvegasMapLabel.setForeground(new Color(0, 51, 153));
		lasvegasMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lasvegasMapLabel.setBounds(67, 163, 39, 21);
		mapPanel.add(lasvegasMapLabel);
		addLabelHoverEvent(lasvegasMapLabel, airportLabel, allFlightsPanel);
		
		JLabel johannesburgMapLabel = new JLabel("JNB");
		johannesburgMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		johannesburgMapLabel.setForeground(new Color(0, 51, 153));
		johannesburgMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		johannesburgMapLabel.setBounds(429, 434, 39, 21);
		mapPanel.add(johannesburgMapLabel);
		addLabelHoverEvent(johannesburgMapLabel, airportLabel, allFlightsPanel);
		
		JLabel bangkokMapLabel = new JLabel("BKK");
		bangkokMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bangkokMapLabel.setForeground(new Color(0, 51, 153));
		bangkokMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		bangkokMapLabel.setBounds(635, 255, 39, 21);
		mapPanel.add(bangkokMapLabel);
		addLabelHoverEvent(bangkokMapLabel, airportLabel, allFlightsPanel);
		
		JLabel dublinMapLabel = new JLabel("DUB");
		dublinMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dublinMapLabel.setForeground(new Color(0, 51, 153));
		dublinMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		dublinMapLabel.setBounds(326, 94, 39, 21);
		mapPanel.add(dublinMapLabel);
		addLabelHoverEvent(dublinMapLabel, airportLabel, allFlightsPanel);
		
		JLabel lisbonMapLabel = new JLabel("LIS");
		lisbonMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lisbonMapLabel.setForeground(new Color(0, 51, 153));
		lisbonMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lisbonMapLabel.setBounds(322, 154, 39, 21);
		mapPanel.add(lisbonMapLabel);
		addLabelHoverEvent(lisbonMapLabel, airportLabel, allFlightsPanel);
		
		JLabel athensMapLabel = new JLabel("ATH");
		athensMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athensMapLabel.setForeground(new Color(0, 51, 153));
		athensMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		athensMapLabel.setBounds(424, 169, 39, 21);
		mapPanel.add(athensMapLabel);
		addLabelHoverEvent(athensMapLabel, airportLabel, allFlightsPanel);
		
		JLabel texasMapLabel = new JLabel("DFW");
		texasMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		texasMapLabel.setForeground(new Color(0, 51, 153));
		texasMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		texasMapLabel.setBounds(102, 184, 39, 21);
		mapPanel.add(texasMapLabel);
		addLabelHoverEvent(texasMapLabel, airportLabel, allFlightsPanel);
		
		JLabel parisMapLabel = new JLabel("CDG");
		parisMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		parisMapLabel.setForeground(new Color(0, 51, 153));
		parisMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		parisMapLabel.setBounds(359, 135, 39, 21);
		mapPanel.add(parisMapLabel);
		addLabelHoverEvent(parisMapLabel, airportLabel, allFlightsPanel);
		
		JLabel amsterdamMapLabel = new JLabel("AMS");
		amsterdamMapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amsterdamMapLabel.setForeground(new Color(0, 51, 153));
		amsterdamMapLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		amsterdamMapLabel.setBounds(393, 96, 39, 21);
		mapPanel.add(amsterdamMapLabel);
		addLabelHoverEvent(amsterdamMapLabel, airportLabel, allFlightsPanel);
		
		//renders image at the last so labels (airport codes) take precedence over it when displayed
		JLabel mapLabel = new JLabel();
		mapLabel.setBounds(0, 0, 841, 563);
		mapPanel.add(mapLabel);
		ImageIcon mapFile = new ImageIcon(this.getClass().getResource("/images/map.png"));
		Image img = mapFile.getImage();
		Image scaledImg = img.getScaledInstance(mapLabel.getWidth(), mapLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(scaledImg);
		mapLabel.setIcon(newImg);
		
		
		
		JPanel delayedtblPanel = new JPanel();
		delayedtblPanel.setBackground(Color.BLACK);
		delayedtblPanel.setBounds(874, 22, 380, 333);
		contentPane.add(delayedtblPanel);
		delayedtblPanel.setLayout(null);
		
		JPanel delayedtblContainer = new JPanel();
		delayedtblContainer.setBounds(0, 45, 380, 288);
		delayedtblPanel.add(delayedtblContainer);
		delayedtblContainer.setLayout(null);
		
		//every 5 mins, repopulate table
		delayedDeparturetbl = new JTable();
		delayedDeparturetbl.setRowSelectionAllowed(false);
		delayedDeparturetbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		delayedDeparturetbl.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
					"FlightNumber", "DepTime", "DepPort", "ArrivalCity", "ArrivalPort", "ArrivalTime", "Delay", "newArrivalTime"
			}
		));
		delayedDeparturetbl.setBounds(0, 16, 380, 272);
		delayedtblContainer.add(delayedDeparturetbl);
		delayedList = filterInstance.filterDeparturesByCurrentDay(filterInstance.getDepartureList());
		addToDelayedTable(filterInstance.filterByDelayedDeparture(delayedList));
		
		JLabel headerdFlightNo = new JLabel("FlightNo");
		headerdFlightNo.setHorizontalAlignment(SwingConstants.CENTER);
		headerdFlightNo.setBounds(1, 1, 46, 14);
		delayedtblContainer.add(headerdFlightNo);
		
		JLabel headerdDepPort = new JLabel("DepPort");
		headerdDepPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerdDepPort.setBounds(97, 1, 54, 14);
		delayedtblContainer.add(headerdDepPort);
		
		JLabel headerdArrivalPort = new JLabel("Arr. Airport");
		headerdArrivalPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerdArrivalPort.setBounds(152, 1, 77, 14);
		delayedtblContainer.add(headerdArrivalPort);
		
		JLabel headerdArrivalTime = new JLabel("Arrival");
		headerdArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerdArrivalTime.setForeground(new Color(0, 0, 0));
		headerdArrivalTime.setBounds(240, 0, 39, 14);
		delayedtblContainer.add(headerdArrivalTime);
		
		JLabel headerdDelay = new JLabel("Delay (m)");
		headerdDelay.setBounds(289, 0, 46, 14);
		delayedtblContainer.add(headerdDelay);
		
		JLabel headerdNewArrivalTime = new JLabel("New");
		headerdNewArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerdNewArrivalTime.setBounds(339, 0, 39, 14);
		delayedtblContainer.add(headerdNewArrivalTime);
		
		JLabel headerdDepTime = new JLabel("DepTime");
		headerdDepTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerdDepTime.setBounds(46, 1, 54, 14);
		delayedtblContainer.add(headerdDepTime);
		
		JLabel lblNewLabel = new JLabel("Delayed Departures");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 380, 45);
		delayedtblPanel.add(lblNewLabel);
		
		JPanel londontblPanel = new JPanel();
		londontblPanel.setBackground(Color.BLACK);
		londontblPanel.setLayout(null);
		londontblPanel.setBounds(874, 369, 380, 494);
		contentPane.add(londontblPanel);
		
		JPanel londontblContainer = new JPanel();
		londontblContainer.setLayout(null);
		londontblContainer.setBounds(0, 45, 380, 449);
		londontblPanel.add(londontblContainer);
		
		londonDeparturetbl = new JTable();
		londonDeparturetbl.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"FlightNumber", "Date", "DepPort", "ArrivalCity", "ArrivalPort", "ArrivalTime", "Delay", "newArrivalTime"
			}
		));
		londonDeparturetbl.setRowSelectionAllowed(false);
		londonDeparturetbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		londonDeparturetbl.setBounds(0, 16, 380, 432);
		londontblContainer.add(londonDeparturetbl);
		
		// Causes visual glitch on bottom left table
		Timer londonTimer = new Timer();
		TimerTask updateLondonList = new TimerTask() {
			@Override
			public void run() {
				londonList = filterInstance.filterDeparturesByAfterCurrentTime(filterInstance.filterByCode(londonMapLabel.getText()));
				addToBCLTable(filterInstance.filterDeparturesByCurrentDay(londonList));
			}
		};
		
		londonTimer.scheduleAtFixedRate(updateLondonList, 0, 300000);
		
		//london
		
		JLabel headerlFlightNo = new JLabel("FlightNo");
		headerlFlightNo.setHorizontalAlignment(SwingConstants.CENTER);
		headerlFlightNo.setBounds(1, 1, 46, 14);
		londontblContainer.add(headerlFlightNo);
		
		JLabel headerlDepPort = new JLabel("DepPort");
		headerlDepPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerlDepPort.setBounds(98, 1, 58, 14);
		londontblContainer.add(headerlDepPort);
		
		JLabel headerlArrivalPort = new JLabel("Arr. Airport");
		headerlArrivalPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerlArrivalPort.setBounds(153, 0, 77, 14);
		londontblContainer.add(headerlArrivalPort);
		
		JLabel headerlArrivalTime = new JLabel("Arrival");
		headerlArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerlArrivalTime.setBounds(232, 1, 58, 14);
		londontblContainer.add(headerlArrivalTime);
		
		JLabel headerlDelay = new JLabel("Delay (m)");
		headerlDelay.setHorizontalAlignment(SwingConstants.CENTER);
		headerlDelay.setBounds(286, 0, 53, 14);
		londontblContainer.add(headerlDelay);
		
		JLabel headerlNewArrivalTime = new JLabel("New");
		headerlNewArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerlNewArrivalTime.setBounds(339, 0, 39, 14);
		londontblContainer.add(headerlNewArrivalTime);
		
		JLabel headerlDepTime = new JLabel("DepTime");
		headerlDepTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerlDepTime.setBounds(46, 1, 58, 14);
		londontblContainer.add(headerlDepTime);
		
		JLabel lblNewLabel_1 = new JLabel("BCL Departures");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(0, 0, 380, 46);
		londontblPanel.add(lblNewLabel_1);
		
		JLabel headerPFlightNo = new JLabel("FlightNo");
		headerPFlightNo.setForeground(Color.WHITE);
		headerPFlightNo.setBounds(31, 52, 46, 14);
		allFlightsPanel.add(headerPFlightNo);
		
		JLabel headerPDate = new JLabel("Date");
		headerPDate.setHorizontalAlignment(SwingConstants.CENTER);
		headerPDate.setForeground(Color.WHITE);
		headerPDate.setBounds(117, 52, 73, 14);
		allFlightsPanel.add(headerPDate);
		
		JLabel headerPDepPort = new JLabel("Departure Airport");
		headerPDepPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerPDepPort.setForeground(Color.WHITE);
		headerPDepPort.setBounds(189, 52, 143, 14);
		allFlightsPanel.add(headerPDepPort);
		
		JLabel headerPArrivalPort = new JLabel("Arrival Airport");
		headerPArrivalPort.setHorizontalAlignment(SwingConstants.CENTER);
		headerPArrivalPort.setForeground(Color.WHITE);
		headerPArrivalPort.setBounds(418, 53, 109, 14);
		allFlightsPanel.add(headerPArrivalPort);
		
		JLabel headerPArrivalTime = new JLabel("Arrival Time");
		headerPArrivalTime.setForeground(Color.WHITE);
		headerPArrivalTime.setBounds(545, 52, 68, 14);
		allFlightsPanel.add(headerPArrivalTime);
		
		JLabel headerPDelay = new JLabel("Delay (m)");
		headerPDelay.setHorizontalAlignment(SwingConstants.CENTER);
		headerPDelay.setForeground(Color.WHITE);
		headerPDelay.setBounds(635, 52, 91, 14);
		allFlightsPanel.add(headerPDelay);
		
		JLabel headerPNewArrivalTime = new JLabel("New Arrival Time");
		headerPNewArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerPNewArrivalTime.setForeground(Color.WHITE);
		headerPNewArrivalTime.setBounds(736, 52, 107, 14);
		allFlightsPanel.add(headerPNewArrivalTime);
		
		
		JLabel headerFlightDepMap = new JLabel("Flight Departures Map");
		headerFlightDepMap.setBackground(Color.DARK_GRAY);
		headerFlightDepMap.setHorizontalAlignment(SwingConstants.LEFT);
		headerFlightDepMap.setForeground(Color.BLACK);
		headerFlightDepMap.setFont(new Font("Tahoma", Font.BOLD, 28));
		headerFlightDepMap.setBounds(16, 11, 341, 33);
		contentPane.add(headerFlightDepMap);
		
		//Captures current local time and displays it on interface
		JLabel systemLocalTime = new JLabel("Current Local Time: ");
		systemLocalTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		systemLocalTime.setHorizontalAlignment(SwingConstants.LEFT);
		systemLocalTime.setBounds(617, 32, 240, 28);
		contentPane.add(systemLocalTime);
		TimerTask updateLocalTime = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				LocalTime currentTime = LocalTime.now();
				String formattedCurrentTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				systemLocalTime.setText("Current Local Time: " + formattedCurrentTime);
			}
		};
		oneSInterval.scheduleAtFixedRate(updateLocalTime, 0, 1000);
		
		allFlightsTbl = new JTable();
		allFlightsTbl.setRowSelectionAllowed(false);
		allFlightsTbl.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
						"FlightNumber", "DepTime", "DepPort", "ArrivalCity", "ArrivalPort", "ArrivalTime", "Delay", "newArrivalTime"
				}
				));
		allFlightsTbl.setBounds(0, 67, 839, 176);
		allFlightsPanel.add(allFlightsTbl);
		
		JLabel headerPDepTime = new JLabel("DepartureTime");
		headerPDepTime.setHorizontalAlignment(SwingConstants.CENTER);
		headerPDepTime.setForeground(Color.WHITE);
		headerPDepTime.setBounds(313, 52, 109, 14);
		allFlightsPanel.add(headerPDepTime);
		
		
		
	}
	
	// METHODS
	
	private void addLabelHoverEvent(JLabel mapLabel, JLabel airportLabel, JPanel allFlightsPanel) {
		mapLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				mapLabel.setForeground(new Color(0, 51, 153));
				bottomList.removeAll(bottomList);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mapLabel.setForeground(new Color(7, 85, 240));
				airportLabel.setText(mapLabel.getText() + " Flights Departing Today:");
				filterCodeList = filterInstance.filterByCode(mapLabel.getText());
				filterDayList = filterInstance.filterDeparturesByCurrentDay(filterCodeList);
				//filterTimeList = filterInstance.filterDeparturesByCurrentTime(filterTimeList);
				bottomList = filterDayList;
				addToBottomTable(bottomList);
			}
		});
	}
	
	private void addToBottomTable(ArrayList<FlightDeparture> sortedList) {
		
		int rowCounter = 0;
		int availableRowSize = allFlightsTbl.getModel().getRowCount();
		if(sortedList.size() < availableRowSize) {
			availableRowSize = sortedList.size();
		}
		while(rowCounter < availableRowSize) {
			for(int i = 0; i < availableRowSize; i++) {
				String[] flightArray = new String[8];
				flightArray[0] = sortedList.get(i).getFlightNumber();
				flightArray[1] = sortedList.get(i).getDateOfFlight().format(dateFormatter);
				flightArray[2] = sortedList.get(i).getDepartureAirport();
				flightArray[3] = sortedList.get(i).getDepartureTime().toString();
				flightArray[4] = sortedList.get(i).getArrivalAirport();
				flightArray[5] = sortedList.get(i).getArrivalTime().toString();
				flightArray[6] = String.valueOf(sortedList.get(i).getDelay());
				flightArray[7] = sortedList.get(i).getNewArrivalTime().toString();
				
				if(flightArray[6].equals("0.0")) {
					flightArray[6] = "---";
				}
				
				if(flightArray[7].equals("00:00")) {
					flightArray[7] = "---";
				}
				
				for(int j = 0; j < allFlightsTbl.getModel().getColumnCount(); j++) {
					
					allFlightsTbl.getModel().setValueAt(flightArray[j], rowCounter, j);
				}
				rowCounter++;
			}
		}
	}
	
	private void addToDelayedTable(ArrayList<FlightDeparture> sortedList) {
		int rowCounter = 0;
		int availableRowSize = delayedDeparturetbl.getModel().getRowCount();
		if(sortedList.size() < availableRowSize) {
			availableRowSize = sortedList.size();
		}
		while(rowCounter < availableRowSize) {
			for(int i = 0; i < availableRowSize; i++) {
				String[] flightArray = new String[8];
				flightArray[0] = sortedList.get(i).getFlightNumber();
				flightArray[1] = sortedList.get(i).getDepartureTime().toString();
				flightArray[2] = sortedList.get(i).getDepartureAirport();
				flightArray[3] = sortedList.get(i).getArrivalAirport();
				flightArray[4] = sortedList.get(i).getArrivalCity();
				flightArray[5] = sortedList.get(i).getArrivalTime().toString();
				flightArray[6] = String.valueOf(sortedList.get(i).getDelay());
				flightArray[7] = sortedList.get(i).getNewArrivalTime().toString();
				
				for(int j = 0; j < delayedDeparturetbl.getModel().getColumnCount(); j++) {

					delayedDeparturetbl.getModel().setValueAt(flightArray[j], rowCounter, j);
				}
				rowCounter++;
			}
		}
	}
	
	private void addToBCLTable(ArrayList<FlightDeparture> sortedList) {
		int rowCounter = 0;
		int availableRowSize = londonDeparturetbl.getModel().getRowCount();
		if(sortedList.size() < availableRowSize) {
			availableRowSize = sortedList.size();
		}
		while(rowCounter < availableRowSize) {
			for(int i = 0; i < availableRowSize; i++) {
				String[] flightArray = new String[8];
				flightArray[0] = sortedList.get(i).getFlightNumber();
				flightArray[1] = sortedList.get(i).getDepartureTime().toString();
				flightArray[2] = sortedList.get(i).getDepartureAirport();
				flightArray[3] = sortedList.get(i).getArrivalAirport();
				flightArray[4] = sortedList.get(i).getArrivalCity();
				flightArray[5] = sortedList.get(i).getArrivalTime().toString();
				flightArray[6] = String.valueOf(sortedList.get(i).getDelay());
				
				if(flightArray[6].equals("0.0")) {
					flightArray[6] = "---";
				}
				
				flightArray[7] = sortedList.get(i).getNewArrivalTime().toString();
				if(flightArray[7].equals("00:00")) {
					flightArray[7] = "---";
					for(int j = 0; j < londonDeparturetbl.getModel().getColumnCount(); j++) {
						
						londonDeparturetbl.getModel().setValueAt(flightArray[j], rowCounter, j);
						
					}
				}
				else {
					for(int j = 0; j < londonDeparturetbl.getModel().getColumnCount(); j++) {
	
						londonDeparturetbl.getModel().setValueAt(flightArray[j], rowCounter, j);
						
					}
				}
				
				
				rowCounter++;
			}
		}
	}
	
}
