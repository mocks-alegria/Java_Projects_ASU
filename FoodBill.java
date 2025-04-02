import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FoodBill extends JFrame {
  private static final int FINAL_HEIGHT = 700;
  
  private static final int FINAL_WIDTH = 450;
  
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
  
  private JButton drink;
  
  private JButton total;
  
  private JButton clear;
  
  private JTextArea list;
  
  private double totalCost;
  
  private boolean isFinished;
  
  public static void main(String[] args) {
    JFrame food = new FoodBill();
  }
  
  public FoodBill() {
    createComponents();
    setSize(450, 700);
    setTitle("Restaurant Bill");
    setVisible(true);
    setDefaultCloseOperation(3);
    this.totalCost = 0.0D;
  }
  
  private void createComponents() {
    JPanel panel1 = new JPanel();
    this.taxRateD = new JLabel("Tax Rate");
    this.taxRate = new JTextField("5.6", 3);
    this.taxRateP1 = new JLabel("%");
    this.tipRateD = new JLabel("Tip");
    this.tipRate = new JTextField("15.0", 3);
    this.taxRateP2 = new JLabel("%");
    panel1.add(this.taxRateD);
    panel1.add(this.taxRate);
    panel1.add(this.taxRateP1);
    panel1.add(this.tipRateD);
    panel1.add(this.tipRate);
    panel1.add(this.taxRateP2);
    this.firstFood = new JButton("VF Legs");
    this.secondFood = new JButton("B Pizza");
    this.thirdFood = new JButton("Veget");
    this.fourthFood = new JButton("Bones");
    this.fifthFood = new JButton("Rocks");
    this.drink = new JButton("Drink");
    this.total = new JButton("Total");
    this.clear = new JButton("Clear");
    panel1.add(this.firstFood);
    panel1.add(this.secondFood);
    panel1.add(this.thirdFood);
    panel1.add(this.fourthFood);
    panel1.add(this.fifthFood);
    panel1.add(this.drink);
    panel1.add(this.total);
    panel1.add(this.clear);
    this.list = new JTextArea(30, 35);
    this.list.setEditable(false);
    Font font = new Font("Monospaced", 1, 12);
    this.list.setFont(font);
    JScrollPane scrollPane = new JScrollPane(this.list);
    panel1.add(scrollPane);
    ActionListener listener1 = new ClickListener1();
    ActionListener listener2 = new ClickListener2();
    ActionListener listener3 = new ClickListener3();
    ActionListener listener4 = new ClickListener4();
    ActionListener listener5 = new ClickListener5();
    ActionListener listener6 = new ClickListener6();
    ActionListener listener7 = new ClickListener7();
    ActionListener listener8 = new ClickListener8();
    this.firstFood.addActionListener(listener1);
    this.secondFood.addActionListener(listener2);
    this.thirdFood.addActionListener(listener3);
    this.fourthFood.addActionListener(listener4);
    this.fifthFood.addActionListener(listener5);
    this.drink.addActionListener(listener6);
    this.total.addActionListener(listener7);
    this.clear.addActionListener(listener8);
    this.isFinished = false;
    add(panel1);
  }
  
  private class ClickListener1 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String food = "Vegan Frog Legs";
        double cost = 6.99D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { food, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener2 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String food = "Boneless Pizza";
        double cost = 7.99D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { food, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener3 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String food = "Potato";
        double cost = 8.99D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { food, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener4 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String food = "Bones";
        double cost = 8.99D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { food, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener5 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String food = "Rocks";
        double cost = 6.99D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { food, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener6 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        String drink = "Ramune";
        double cost = 2.0D;
        FoodBill.this.totalCost += cost;
        String add = String.format("%-20s $%9.2f\n", new Object[] { drink, Double.valueOf(cost) });
        FoodBill.this.list.append(add);
      } 
    }
  }
  
  private class ClickListener7 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!FoodBill.this.isFinished) {
        FoodBill.this.list.append("-------------------- ----------\n");
        String preTax = String.format("%-20s $%9.2f\n%-20s $%9.2f\n", new Object[] { "Pretax Total", Double.valueOf(FoodBill.this.totalCost), "Tax", Double.valueOf(FoodBill.this.totalCost * Double.parseDouble(FoodBill.this.taxRate.getText()) / 100.0D) });
        FoodBill.this.list.append(preTax);
        FoodBill.this.list.append("-------------------- ----------\n");
        String TotalWTax = String.format("%-20s $%9.2f\n%-20s $%9.2f\n", new Object[] { "Total w/Tax", Double.valueOf(FoodBill.this.totalCost + FoodBill.this.totalCost * Double.parseDouble(FoodBill.this.taxRate.getText()) / 100.0D), "Tip", Double.valueOf(FoodBill.this.totalCost * Double.parseDouble(FoodBill.this.tipRate.getText()) / 100.0D) });
        FoodBill.this.list.append(TotalWTax);
        FoodBill.this.list.append("-------------------- ----------\n");
        String totalMax = String.format("%-20s $%9.2f\n", new Object[] { "Total", Double.valueOf(FoodBill.this.totalCost + FoodBill.this.totalCost * Double.parseDouble(FoodBill.this.taxRate.getText()) / 100.0D + FoodBill.this.totalCost * Double.parseDouble(FoodBill.this.tipRate.getText()) / 100.0D) });
        FoodBill.this.list.append(totalMax);
        FoodBill.this.isFinished = true;
      } 
    }
  }
  
  private class ClickListener8 implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      FoodBill.this.list.setText(null);
      FoodBill.this.isFinished = false;
      FoodBill.this.totalCost = 0.0D;
    }
  }
}
