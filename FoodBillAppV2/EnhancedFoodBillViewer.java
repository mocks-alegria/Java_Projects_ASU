import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EnhancedFoodBillViewer extends JFrame {
  private static final int FINAL_HEIGHT = 700;
  
  private static final int FINAL_WIDTH = 700;
  
  private JLabel currentTotal1;
  
  private JLabel currentTotalwTax1;
  
  private JLabel currentTotalwTip1;
  
  private double currentTotal = 0.0D;
  
  private double currentTotalwTax = 0.0D;
  
  private double currentTotalwTip = 0.0D;
  
  private String tipValue = "15";
  
  private String taxValue = "5.600";
  
  private double ataxValue = 5.6D;
  
  private double ctaxValue = 7.25D;
  
  private double cotaxValue = 2.9D;
  
  private double nmtaxValue = 5.125D;
  
  private double nvtaxValue = 6.85D;
  
  private JMenuBar menu;
  
  private JMenu file;
  
  private JMenu servers;
  
  private JMenuItem exitItem;
  
  private JMenuItem clearItem;
  
  private JMenuItem server1;
  
  private JMenuItem server2;
  
  private JMenuItem server3;
  
  private JMenuItem server4;
  
  private JMenuItem server5;
  
  private JLabel taxRateD;
  
  private JTextField taxRate;
  
  private JLabel taxRateP1;
  
  private JLabel tipRateD;
  
  private JTextField tipRate;
  
  private JLabel taxRateP2;
  
  private JButton firstFood;
  
  private JButton secondFood;
  
  private JButton thirdFood;
  
  private JButton fourthFood;
  
  private JButton fifthFood;
  
  private JButton adrink;
  
  private JButton mdrink;
  
  private JButton ddrink;
  
  private JButton afoodone;
  
  private JButton afoodtwo;
  
  private JButton mfoodone;
  
  private JButton mfoodtwo;
  
  private JButton dfoodone;
  
  private JButton dfoodtwo;
  
  private JButton dfoodthree;
  
  private JButton total;
  
  private JSlider tipRateSlider;
  
  private JRadioButton arizonaTax;
  
  private JRadioButton californiaTax;
  
  private JRadioButton coloradoTax;
  
  private JRadioButton newMexicoTax;
  
  private JRadioButton nevadaTax;
  
  private ButtonGroup radioButtons;
  
  private JTextArea list;
  
  private double totalCost;
  
  private boolean isFinished;
  
  private String thanks;
  
  private String name1 = "Maximiliano A.";
  
  private String name2 = "Alan T.";
  
  private String name3 = "Larry P.";
  
  private String name4 = "Grace H.";
  
  private String name5 = "David H.";
  
  public static void main(String[] args) {
    JFrame food = new EnhancedFoodBillViewer();
  }
  
  public EnhancedFoodBillViewer() {
    createComponents();
    setSize(700, 700);
    setTitle("Enhanced Restaurant Bill");
    setVisible(true);
    setDefaultCloseOperation(3);
    this.totalCost = 0.0D;
  }
  
  private void createComponents() {
    setLayout(new BorderLayout());
    this.thanks = String.format("\n\nIt was a pleasure serving you!\n   - %s", new Object[] { this.name1 });
    this.menu = new JMenuBar();
    setJMenuBar(this.menu);
    this.file = new JMenu("File");
    this.servers = new JMenu("Servers");
    this.clearItem = new JMenuItem("Clear");
    this.exitItem = new JMenuItem("Exit");
    this.exitItem.addActionListener(new exitButton());
    this.clearItem.addActionListener(new clearButton());
    this.server1 = new JMenuItem(this.name1);
    this.server2 = new JMenuItem(this.name2);
    this.server3 = new JMenuItem(this.name3);
    this.server4 = new JMenuItem(this.name4);
    this.server5 = new JMenuItem(this.name5);
    this.server1.addActionListener(new nameListener(this.name1));
    this.server2.addActionListener(new nameListener(this.name2));
    this.server3.addActionListener(new nameListener(this.name3));
    this.server4.addActionListener(new nameListener(this.name4));
    this.server5.addActionListener(new nameListener(this.name5));
    this.file.add(this.clearItem);
    this.file.add(this.exitItem);
    this.servers.add(this.server1);
    this.servers.add(this.server2);
    this.servers.add(this.server3);
    this.servers.add(this.server4);
    this.servers.add(this.server5);
    this.menu.add(this.file);
    this.menu.add(this.servers);
    JPanel panel1 = new JPanel();
    this.taxRateD = new JLabel("Tax Rate");
    this.taxRate = new JTextField(this.taxValue, 3);
    this.taxRate.setEditable(false);
    this.arizonaTax = new JRadioButton("AZ");
    this.arizonaTax.setSelected(true);
    this.arizonaTax.addActionListener(new radioListener(this.ataxValue));
    this.californiaTax = new JRadioButton("CA");
    this.californiaTax.addActionListener(new radioListener(this.ctaxValue));
    this.coloradoTax = new JRadioButton("CO");
    this.coloradoTax.addActionListener(new radioListener(this.cotaxValue));
    this.newMexicoTax = new JRadioButton("NM");
    this.newMexicoTax.addActionListener(new radioListener(this.nmtaxValue));
    this.nevadaTax = new JRadioButton("NV");
    this.nevadaTax.addActionListener(new radioListener(this.nvtaxValue));
    this.radioButtons = new ButtonGroup();
    this.radioButtons.add(this.arizonaTax);
    this.radioButtons.add(this.californiaTax);
    this.radioButtons.add(this.coloradoTax);
    this.radioButtons.add(this.newMexicoTax);
    this.radioButtons.add(this.nevadaTax);
    this.taxRateP1 = new JLabel("%");
    this.tipRateD = new JLabel("Tip");
    this.tipRate = new JTextField(this.tipValue, 3);
    this.tipRate.setEditable(false);
    this.taxRateP2 = new JLabel("%");
    this.tipRateSlider = new JSlider(1, 35, 15);
    this.tipRateSlider.addChangeListener(new sliderListener());
    JLabel appetizers = new JLabel("App.");
    this.thirdFood = new JButton("Veget");
    this.fourthFood = new JButton("Bones");
    this.adrink = new JButton("Pom Juice");
    this.afoodone = new JButton("Potatoes F");
    this.afoodtwo = new JButton("Onion Squares");
    JLabel mains = new JLabel("Main");
    this.firstFood = new JButton("VF Legs");
    this.secondFood = new JButton("B Pizza");
    this.mdrink = new JButton("Ramune");
    this.mfoodone = new JButton("I Burger");
    this.mfoodtwo = new JButton("Beef Sus");
    JLabel desserts = new JLabel("Dessert");
    this.fifthFood = new JButton("Rocks");
    this.ddrink = new JButton("H.O. Coffee Drink");
    this.dfoodone = new JButton("Cake");
    this.dfoodtwo = new JButton("Bigger Cake");
    this.dfoodthree = new JButton("Biggest Cake");
    this.currentTotal1 = new JLabel(String.format("Current Total: $%.2f", new Object[] { Double.valueOf(this.currentTotal) }));
    this.currentTotalwTax1 = new JLabel(String.format("Current Total w/Tax: $%.2f", new Object[] { Double.valueOf(this.currentTotalwTax) }));
    this.currentTotalwTip1 = new JLabel(String.format("Current Total w/Tip: $%.2f", new Object[] { Double.valueOf(this.currentTotalwTip) }));
    this.total = new JButton("Total");
    this.list = new JTextArea(30, 35);
    this.list.setEditable(false);
    Font font = new Font("Monospaced", 1, 12);
    this.list.setFont(font);
    JScrollPane scrollPane = new JScrollPane(this.list, 20, 31);
    JPanel taxRateandTip = new JPanel();
    taxRateandTip.setLayout(new GridLayout(2, 1));
    add(taxRateandTip, "North");
    JPanel taxRatePanel = new JPanel();
    taxRateandTip.add(taxRatePanel);
    JPanel tipRatePanel = new JPanel();
    taxRateandTip.add(tipRatePanel);
    JPanel menuPanel = new JPanel();
    menuPanel.setLayout(new GridLayout(6, 3, 10, 5));
    add(menuPanel, "West");
    JPanel totalCostsPanelwTotal = new JPanel();
    totalCostsPanelwTotal.setLayout(new GridLayout(2, 1));
    JPanel totalCostsPanel = new JPanel();
    totalCostsPanel.setLayout(new GridLayout(3, 1));
    add(totalCostsPanelwTotal, "South");
    totalCostsPanelwTotal.add(totalCostsPanel);
    add(scrollPane, "East");
    totalCostsPanelwTotal.add(this.total);
    totalCostsPanel.add(this.currentTotal1);
    totalCostsPanel.add(this.currentTotalwTax1);
    totalCostsPanel.add(this.currentTotalwTip1);
    taxRatePanel.add(this.taxRateD);
    taxRatePanel.add(this.arizonaTax);
    taxRatePanel.add(this.californiaTax);
    taxRatePanel.add(this.coloradoTax);
    taxRatePanel.add(this.newMexicoTax);
    taxRatePanel.add(this.nevadaTax);
    taxRatePanel.add(this.taxRate);
    taxRatePanel.add(this.taxRateP1);
    tipRatePanel.add(this.tipRateD);
    tipRatePanel.add(this.tipRateSlider);
    tipRatePanel.add(this.tipRate);
    tipRatePanel.add(this.taxRateP2);
    menuPanel.add(appetizers);
    menuPanel.add(mains);
    menuPanel.add(desserts);
    menuPanel.add(this.thirdFood);
    menuPanel.add(this.firstFood);
    menuPanel.add(this.fifthFood);
    menuPanel.add(this.fourthFood);
    menuPanel.add(this.secondFood);
    menuPanel.add(this.ddrink);
    menuPanel.add(this.adrink);
    menuPanel.add(this.mdrink);
    menuPanel.add(this.dfoodone);
    menuPanel.add(this.afoodone);
    menuPanel.add(this.mfoodone);
    menuPanel.add(this.dfoodtwo);
    menuPanel.add(this.afoodtwo);
    menuPanel.add(this.mfoodtwo);
    menuPanel.add(this.dfoodthree);
    this.firstFood.addActionListener(new foodButtons("Vegan Frog Legs", 6.99D));
    this.secondFood.addActionListener(new foodButtons("Boneless Pizza", 7.99D));
    this.thirdFood.addActionListener(new foodButtons("Potato", 8.99D));
    this.fourthFood.addActionListener(new foodButtons("Bones", 8.99D));
    this.fifthFood.addActionListener(new foodButtons("Rocks", 6.99D));
    this.mdrink.addActionListener(new foodButtons("Ramune", 6.99D));
    this.adrink.addActionListener(new foodButtons("Pomegranate Juice", 2.99D));
    this.ddrink.addActionListener(new foodButtons("Overpriced Starducks", 999.99D));
    this.afoodone.addActionListener(new foodButtons("French Potatoes", 4.99D));
    this.afoodtwo.addActionListener(new foodButtons("Fried Onion Squares", 2.99D));
    this.mfoodone.addActionListener(new foodButtons("Inverted Burger", 8.99D));
    this.mfoodtwo.addActionListener(new foodButtons("Beef Sushi", 5.99D));
    this.dfoodone.addActionListener(new foodButtons("Small Cake", 15.99D));
    this.dfoodtwo.addActionListener(new foodButtons("Medium Cake", 9.99D));
    this.dfoodthree.addActionListener(new foodButtons("Large Cake", 4.99D));
    this.total.addActionListener(new totalCollector());
    this.isFinished = false;
  }
  
  private class foodButtons implements ActionListener {
    private double cost;
    
    private String foodName;
    
    public void actionPerformed(ActionEvent event) {
      if (!EnhancedFoodBillViewer.this.isFinished) {
        EnhancedFoodBillViewer.this.totalCost += this.cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { this.foodName, Double.valueOf(this.cost) });
        EnhancedFoodBillViewer.this.list.append(add);
        EnhancedFoodBillViewer.this.currentTotal += this.cost;
        EnhancedFoodBillViewer.this.currentTotalwTax = EnhancedFoodBillViewer.this.currentTotal + EnhancedFoodBillViewer.this.currentTotal * Double.parseDouble(EnhancedFoodBillViewer.this.taxRate.getText()) / 100.0D;
        EnhancedFoodBillViewer.this.currentTotalwTip = EnhancedFoodBillViewer.this.currentTotalwTax + EnhancedFoodBillViewer.this.currentTotal * Double.parseDouble(EnhancedFoodBillViewer.this.tipValue) / 100.0D;
        EnhancedFoodBillViewer.this.currentTotal1.setText(String.format("Current Total: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotal) }));
        EnhancedFoodBillViewer.this.currentTotalwTax1.setText(String.format("Current Total w/Tax: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTax) }));
        EnhancedFoodBillViewer.this.currentTotalwTip1.setText(String.format("Current Total w/Tip: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTip) }));
      } 
    }
    
    private foodButtons(String foodName, double cost) {
      this.foodName = foodName;
      this.cost = cost;
    }
  }
  
  private class totalCollector implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!EnhancedFoodBillViewer.this.isFinished) {
        EnhancedFoodBillViewer.this.list.append("-------------------- ----------\n");
        String preTax = String.format("%-20s $%9.2f\n%-20s $%9.2f\n", new Object[] { "Pretax Total", Double.valueOf(EnhancedFoodBillViewer.this.totalCost), "Tax", Double.valueOf(EnhancedFoodBillViewer.this.totalCost * Double.parseDouble(EnhancedFoodBillViewer.this.taxRate.getText()) / 100.0D) });
        EnhancedFoodBillViewer.this.list.append(preTax);
        EnhancedFoodBillViewer.this.list.append("-------------------- ----------\n");
        String TotalWTax = String.format("%-20s $%9.2f\n%-20s $%9.2f\n", new Object[] { "Total w/Tax", Double.valueOf(EnhancedFoodBillViewer.this.totalCost + EnhancedFoodBillViewer.this.totalCost * Double.parseDouble(EnhancedFoodBillViewer.this.taxRate.getText()) / 100.0D), "Tip", Double.valueOf(EnhancedFoodBillViewer.this.totalCost * Double.parseDouble(EnhancedFoodBillViewer.this.tipRate.getText()) / 100.0D) });
        EnhancedFoodBillViewer.this.list.append(TotalWTax);
        EnhancedFoodBillViewer.this.list.append("-------------------- ----------\n");
        String totalMax = String.format("%-20s $%9.2f\n", new Object[] { "Total", Double.valueOf(EnhancedFoodBillViewer.this.totalCost + EnhancedFoodBillViewer.this.totalCost * Double.parseDouble(EnhancedFoodBillViewer.this.taxRate.getText()) / 100.0D + EnhancedFoodBillViewer.this.totalCost * Double.parseDouble(EnhancedFoodBillViewer.this.tipRate.getText()) / 100.0D) });
        EnhancedFoodBillViewer.this.list.append(totalMax);
        EnhancedFoodBillViewer.this.list.append(EnhancedFoodBillViewer.this.thanks);
        EnhancedFoodBillViewer.this.isFinished = true;
      } 
    }
  }
  
  private class exitButton implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      EnhancedFoodBillViewer.this.setVisible(false);
      EnhancedFoodBillViewer.this.dispose();
    }
  }
  
  private class clearButton implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      EnhancedFoodBillViewer.this.list.setText("");
      EnhancedFoodBillViewer.this.totalCost = 0.0D;
      EnhancedFoodBillViewer.this.currentTotal = 0.0D;
      EnhancedFoodBillViewer.this.currentTotalwTax = 0.0D;
      EnhancedFoodBillViewer.this.currentTotalwTip = 0.0D;
      EnhancedFoodBillViewer.this.currentTotal1.setText(String.format("Current Total: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotal) }));
      EnhancedFoodBillViewer.this.currentTotalwTax1.setText(String.format("Current Total w/Tax: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTax) }));
      EnhancedFoodBillViewer.this.currentTotalwTip1.setText(String.format("Current Total w/Tip: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTip) }));
      EnhancedFoodBillViewer.this.isFinished = false;
    }
  }
  
  private class nameListener implements ActionListener {
    private String name;
    
    public void actionPerformed(ActionEvent event) {
      EnhancedFoodBillViewer.this.thanks = String.format("\n\nIt was a pleasure serving you!\n   - %s", new Object[] { this.name });
    }
    
    public nameListener(String name) {
      this.name = name;
    }
  }
  
  private class sliderListener implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      EnhancedFoodBillViewer.this.tipValue = String.format("%d", new Object[] { Integer.valueOf(EnhancedFoodBillViewer.this.tipRateSlider.getValue()) });
      EnhancedFoodBillViewer.this.tipRate.setText("");
      EnhancedFoodBillViewer.this.tipRate.setText(EnhancedFoodBillViewer.this.tipValue);
      EnhancedFoodBillViewer.this.currentTotalwTip = EnhancedFoodBillViewer.this.currentTotalwTax + EnhancedFoodBillViewer.this.currentTotal * Double.parseDouble(EnhancedFoodBillViewer.this.tipValue) / 100.0D;
      EnhancedFoodBillViewer.this.currentTotalwTip1.setText(String.format("Current Total w/Tip: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTip) }));
    }
  }
  
  private class radioListener implements ActionListener {
    private double taxRateAppend;
    
    public void actionPerformed(ActionEvent event) {
      EnhancedFoodBillViewer.this.taxRate.setText("");
      EnhancedFoodBillViewer.this.taxRate.setText(String.format("%.3f", new Object[] { Double.valueOf(this.taxRateAppend) }));
      EnhancedFoodBillViewer.this.currentTotalwTax = EnhancedFoodBillViewer.this.currentTotal + EnhancedFoodBillViewer.this.currentTotal * Double.parseDouble(EnhancedFoodBillViewer.this.taxRate.getText()) / 100.0D;
      EnhancedFoodBillViewer.this.currentTotalwTax1.setText(String.format("Current Total w/Tax: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTax) }));
      EnhancedFoodBillViewer.this.currentTotalwTip = EnhancedFoodBillViewer.this.currentTotalwTax + EnhancedFoodBillViewer.this.currentTotal * Double.parseDouble(EnhancedFoodBillViewer.this.tipValue) / 100.0D;
      EnhancedFoodBillViewer.this.currentTotalwTip1.setText(String.format("Current Total w/Tip: $%.2f", new Object[] { Double.valueOf(EnhancedFoodBillViewer.this.currentTotalwTip) }));
    }
    
    public radioListener(double taxRateAppend) {
      this.taxRateAppend = taxRateAppend;
    }
  }
}