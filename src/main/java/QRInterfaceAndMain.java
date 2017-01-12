import java.awt.*; // Using AWT container and component classes
import java.awt.event.*; // Using AWT event classes and listener interfaces

import javax.swing.JButton;
//cb: a  d: 1, b:1 s:1 d:1 
// An AWT GUI program inherits from the top-level container java.awt.Frame
public class QRInterfaceAndMain extends Frame implements ActionListener, WindowListener {
	private Label HospitalText;
	Label incorrectData;
	private Label idText;
	private Label doorText;
	private Label binText;
	private Label drawerText;
	private Label shelfText;
	private TextField shelfAmount;
	private TextField drawerAmount;
	private TextField binAmount;
	private TextField doorAmount;
	private TextField Hospital;
	private TextField cabID;
	private Label cartOrCabnet;
	private Choice Chooser;
	// Accumulated sum, init to 0

	// Constructor to setup the GUI components and event handlers
	public QRInterfaceAndMain() {
		System.out.println("asdf");

		setLayout(new FlowLayout());
		// "super" Frame (a Container) sets layout to FlowLayout, which arranges
		// the components from left-to-right, and flow to next row from
		// top-to-bottom.

		HospitalText = new Label("Enter Hospital ID: "); // Construct Label
		add(HospitalText); // "super" Frame adds Label

		Hospital = new TextField(10); // Construct TextField
		add(Hospital); // "super" Frame adds TextField

		// Hospital.addActionListener(this);

		idText = new Label("Enter Cart/Cabnet ID: ");
		add(idText);

		cabID = new TextField(10); // Construct TextField
		add(cabID); // "super" Frame adds TextField

		// Quantity.addActionListener(this);
		cartOrCabnet = new Label("Cart or Cabnet: ");
		add(cartOrCabnet);
		Chooser = new Choice();
		Chooser.add("Cabnet");
		Chooser.add("Cart");
		add(Chooser);

		doorText = new Label("Number of doors: ");
		add(doorText);
		doorAmount = new TextField(10); // Construct TextField
		add(doorAmount);

		shelfText = new Label("Number of shelves: ");
		add(shelfText);
		shelfAmount = new TextField(10); // Construct TextField
		add(shelfAmount);

		drawerText = new Label("Number of drawers: ");
		add(drawerText);
		drawerAmount = new TextField(10); // Construct TextField
		add(drawerAmount);

		binText = new Label("Number of bins: ");
		add(binText);
		binAmount = new TextField(10); // Construct TextField
		add(binAmount);

		JButton j1 = new JButton();
		j1.setText("Create");

		add(j1);
		j1.addActionListener(this);

		// tfInput is the source object that fires ActionEvent when entered.
		// The source add "this" instance as an ActionEvent listener, which
		// provides
		// an ActionEvent handler called actionPerformed().
		// Hitting the Create button invokes actionPerformed().
		addWindowListener(this);
		setTitle("QR Generator"); // "super" Frame sets title
		setSize(300, 320); // "super" Frame sets initial window size
		setVisible(true); // "super" Frame shows
	}

	// The entry main() method
	public static void main(String[] args) {
		// Invoke the constructor to setup the GUI, by allocating an anonymous
		// instance
		System.out.println("asdf");
		new QRInterfaceAndMain();
	}

	// ActionEvent handler - Called back upon hitting enter key on TextField
	@Override
	public void actionPerformed(ActionEvent evt) {
		// Get the String entered into the TextField tfInput, convert to int
		String HID = Hospital.getText();
		int id, door, shelf, drawer, bin;
		String cabOrCart;
		boolean isCabnet;
		try {
			id = Integer.parseInt(cabID.getText());
			cabOrCart = Chooser.getSelectedItem();
			door = Integer.parseInt(doorAmount.getText());
			shelf = Integer.parseInt(shelfAmount.getText());
			drawer = Integer.parseInt(drawerAmount.getText());
			bin = Integer.parseInt(binAmount.getText());
		} catch (Exception E) {
			incorrectData = new Label("Incorrect data try again");
			//incorrectData.enableInputMethods(false);
			add(incorrectData);
			return;
		}
		isCabnet = (cabOrCart.equals("Cabnet"));
		QRCodeCreator c1 = new QRCodeCreator();
		System.out.println("qwe");

		for (int i = 1; i <= door; i++) {
			for (int j = 1; j <= shelf; j++) {
				for (int k = 1; k <= drawer; k++) {
					for (int l = 1; l <= bin; l++) {
						String temp = "";
						String description= "";
						temp += HID;
						if (isCabnet) {
							temp += 0;
							description+= "CAB:";
						} else {
							temp += 1;

							description+= "CRT:";
						}
						Character ch = new Character((char) ((id+65)-1));
						System.out.println(ch);
						description+= ""+ ch +" ";
						if (id < 10) {
							temp += "0" + id;
						} else {
							temp += id;
						}
						description+= " D:"+ i;
						if (i < 10) {
							temp += "0" + i;
						} else {
							temp += "" + i;
						}
						description+= " DW:"+ k;
						if (k < 10) {
							temp += "0" + k;
						} else {
							temp += "" + k;
						}
						description+= " B:"+ l;
						if (l < 10) {
							temp += "0" + l;
						} else {
							temp += "" + l;
						}
						description+= " S:"+ j;
						if (j < 10) {
							temp += "0" + j;
						} else {
							temp += "" + j;
						}

					
						c1.CreateQRCode(temp, temp /*+" "+ description*/, description);
						
					}
				}
			}

		}
		System.exit(0);
		// c1.CreateQRCode("test", "");

	}

	public void windowClosing(WindowEvent evt) {
		System.exit(0); // Terminate the program
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}