
import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class LoanCalculator extends JFrame{
	
	private JTextField jtfAnnualInt, jtfNumOfYears, jtfLoanAmount, jtfMonthlyPay, jtfTotal;
	private JButton jbtCalculate;

	public static void main(String[] args) {
		LoanCalculator frame =new LoanCalculator();
		
		frame.pack();
		frame.setTitle("LoanCalculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	public LoanCalculator() {
		JPanel p1=new JPanel();
		p1.add(new JLabel("Annual Interest Rate:"));
		p1.add(jtfAnnualInt= new JTextField(4));
		p1.add(new JLabel("Number Of Years"));
		p1.add(jtfNumOfYears=new JTextField(3));
		p1.add(new JLabel("Loan Amount"));
		p1.add(jtfLoanAmount = new JTextField(4));
		p1.add(new JLabel("Monthly Payment"));
		p1.add(jtfMonthlyPay= new JTextField(14));
		p1.add(new JLabel("Total Payment"));
		p1.add(jtfTotal=new JTextField(14));
		jtfMonthlyPay.setEditable(false);
		jtfTotal.setEditable(false);
		
		
		JPanel p2=new JPanel();
		p2.add(jbtCalculate=new JButton("Calculate"));
		
		add(p1, BorderLayout.WEST);
		add(p2, BorderLayout.SOUTH);
		
		jbtCalculate.addActionListener(new Listener());
		
		
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if("Calculate".equals(actionCommand))
				getMonthlyPayment();
			getTotalPayment();
			
			
		}
		
	}
	
       @SuppressWarnings("removal")
	public double getMonthlyPayment() {
		
		
		double annualInterestRate =new Double(jtfAnnualInt.getText().trim()).doubleValue();
		double loanAmount= new Double(jtfLoanAmount.getText().trim()).doubleValue();
		double numberOfYears =new Double(jtfNumOfYears.getText().trim()).doubleValue();
		
		
		
		   double monthlyInterestRate = annualInterestRate / 1200;
		   double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
		     (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		   jtfMonthlyPay.setText("$"+String.valueOf(monthlyPayment));
		return monthlyPayment;    

       }
public void getTotalPayment() {
	@SuppressWarnings("removal")
	double numberOfYears =new Double(jtfNumOfYears.getText().trim()).doubleValue();
	double monthlyPayment = getMonthlyPayment();
	double totalPayment=monthlyPayment*numberOfYears*12;
	
	jtfTotal.setText("$"+String.valueOf(totalPayment));
}
       }


	
       

 