import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame{
	
	//Statements
	private JPanel panel;
	
	//Grid
	private GridLayout grid;
	
	//JTextField
	private JTextField screen;
	
	//Numbers'Buttons
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
	
	//Operations' Buttons
	private JButton btnAC;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiplicacion;
	private JButton btnDivition;
	private JButton btnExp;
	private JButton btnSqrt;
	private JButton btnPercent;
	private JButton btnEquals;
	private JButton btnDot;
	
	//Expression's Label
	private JLabel concept;
	
	//This string is for the screen
	private String expression1 = "";
	private String expression2 = "";
	//Decimal points
	boolean isDot1 = false;
	boolean isDot2 = false;
	//this is to know if there is any operation in process (/,*,-,+ )
	private boolean inOperation = false;
	//list of operators {'0','/','*','-','+'};
	//Know the operation
	private char operation = '0';
	
	//Brid's size
	public final static int BTN_SIZE = 66;
	
	//Builder
	public Calculadora(){
		components();
		iniWindow();
		iniactions();
	}
	
	//initialize the window
	private void iniWindow(){
		setSize(310,486);
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		setResizable(false); //The window must to keep its original size.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
	}
	
	//This method is for fill the window
	private void components() {
		
		//Put the grid type design on the panel to make it look pretty
		grid = new GridLayout();
		grid.setRows(6);
		grid.setColumns(4);
		grid.setHgap(5);	//Horizontal padding
		grid.setVgap(5);	//Vertical padding
		
		//Panel
		panel = new JPanel(grid);
		panel.setBackground(Color.BLACK);
		
		//JTextField for the answer
		screen = new JTextField("0");
		screen.setFont(new Font("ink free",Font.BOLD,30));
		screen.setPreferredSize(new Dimension(280,50));
		screen.setBackground(Color.BLACK);
		screen.setForeground(Color.WHITE);
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.enable(false); //Without inputs
		
		//Label where I'm going to put the expression
		concept = new JLabel("0");
		concept.setFont(new Font("Arial",Font.BOLD,12));
		concept.setForeground(Color.WHITE);
		
		//Numbers' Buttons
		btn1 = new JButton("1");
		btn1.setFont(new Font("Times new roman",Font.BOLD,20));
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn1.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Times new roman",Font.BOLD,20));
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn2.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Times new roman",Font.BOLD,20));
		btn3.setBackground(Color.BLACK);
		btn3.setForeground(Color.WHITE);
		btn3.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("Times new roman",Font.BOLD,20));
		btn4.setBackground(Color.BLACK);
		btn4.setForeground(Color.WHITE);
		btn4.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Times new roman",Font.BOLD,20));
		btn5.setBackground(Color.BLACK);
		btn5.setForeground(Color.WHITE);
		btn5.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Times new roman",Font.BOLD,20));
		btn6.setBackground(Color.BLACK);
		btn6.setForeground(Color.WHITE);
		btn6.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn7 = new JButton("7");
		btn7.setFont(new Font("Times new roman",Font.BOLD,20));
		btn7.setBackground(Color.BLACK);
		btn7.setForeground(Color.WHITE);
		btn7.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Times new roman",Font.BOLD,20));
		btn8.setBackground(Color.BLACK);
		btn8.setForeground(Color.WHITE);
		btn8.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Times new roman",Font.BOLD,20));
		btn9.setBackground(Color.BLACK);
		btn9.setForeground(Color.WHITE);
		btn9.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("Times new roman",Font.BOLD,20));
		btn0.setBackground(Color.BLACK);
		btn0.setForeground(Color.WHITE);
		btn0.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		//Operations' Buttons
		btnAC = new JButton("AC");
		btnAC.setFont(new Font("Times new roman",Font.BOLD,20));
		btnAC.setBackground(Color.BLACK);
		btnAC.setForeground(Color.GREEN);
		btnAC.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Times new roman",Font.BOLD,20));
		btnPlus.setBackground(Color.BLACK);
		btnPlus.setForeground(Color.GREEN);
		btnPlus.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Times new roman",Font.BOLD,20));
		btnMinus.setBackground(Color.BLACK);
		btnMinus.setForeground(Color.GREEN);
		btnMinus.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnMultiplicacion = new JButton("*");
		btnMultiplicacion.setFont(new Font("Times new roman",Font.BOLD,20));
		btnMultiplicacion.setBackground(Color.BLACK);
		btnMultiplicacion.setForeground(Color.GREEN);
		btnMultiplicacion.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnDivition = new JButton("/");
		btnDivition.setFont(new Font("Times new roman",Font.BOLD,20));
		btnDivition.setBackground(Color.BLACK);
		btnDivition.setForeground(Color.GREEN);
		btnDivition.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnExp = new JButton("^2");
		btnExp.setFont(new Font("Times new roman",Font.BOLD,20));
		btnExp.setBackground(Color.BLACK);
		btnExp.setForeground(Color.GREEN);
		btnExp.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnSqrt = new JButton("Sqrt");
		btnSqrt.setFont(new Font("Times new roman",Font.BOLD,15));
		btnSqrt.setBackground(Color.BLACK);
		btnSqrt.setForeground(Color.GREEN);
		btnSqrt.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnPercent = new JButton("%");
		btnPercent.setFont(new Font("Times new roman",Font.BOLD,20));
		btnPercent.setBackground(Color.BLACK);
		btnPercent.setForeground(Color.GREEN);
		btnPercent.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Times new roman",Font.BOLD,20));
		btnEquals.setBackground(Color.BLACK);
		btnEquals.setForeground(Color.GREEN);
		btnEquals.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		btnDot = new JButton(".");
		btnDot.setFont(new Font("Times new roman",Font.BOLD,20));
		btnDot.setBackground(Color.BLACK);
		btnDot.setForeground(Color.GREEN);
		btnDot.setPreferredSize(new Dimension(BTN_SIZE,BTN_SIZE));
		
		//Additions to Panels
		add(screen);
		add(concept);
		add(panel);
		panel.add(btnAC);	panel.add(btnSqrt);	panel.add(btnPercent);	panel.add(btnExp);
		panel.add(btn7);	panel.add(btn8);	panel.add(btn9);		panel.add(btnDivition);
		panel.add(btn4);	panel.add(btn5);	panel.add(btn6);		panel.add(btnMultiplicacion);
		panel.add(btn1);	panel.add(btn2);	panel.add(btn3);		panel.add(btnMinus);
		panel.add(btn0);	panel.add(btnDot);	panel.add(btnEquals);	panel.add(btnPlus);

		//while(true) System.out.println(panel.getSize()+"	"+this.getSize());
	}
	
	//Put events on the buttons
	public void iniactions() {
		
		btnAC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				expression1 = "";
				expression2 = "";
				inOperation = false;
				lock();
				isDot1 = false;
				isDot2 = false;
				operation = '0';
				screen.setText("0");
				concept.setText("0");
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "1";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "1";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "2";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "2";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "3";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "3";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "4";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "4";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "5";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "5";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "6";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "6";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "7";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "7";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "8";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "8";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "9";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "9";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btn0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression1.equals("0")) expression1 = "";
						expression1 += "0";
						screen.setText(expression1);
						concept.setText(expression1);
					}
				}else {
					if(inOperation && expression2.length() < 11) {
						expression2 += "0";
						screen.setText(expression2);
						concept.setText(expression1+operation+expression2);
					}
				}
			}
		});
		
		btnSqrt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation && expression1 != "0" && expression1 != "") {
					float aux = (float) Math.sqrt(Float.parseFloat(expression1));
					if(aux - (int) aux != 0) expression1 = ""+aux;
					else expression1 = ""+(int) aux;
					screen.setText(expression1);
					if(operation != '0') concept.setText(expression1+operation);
					else concept.setText(expression1);
				}
			}
		});
		
		btnPercent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1 == "") expression1 = "0.0";
					else if(expression1 != "") expression1 = ""+Float.parseFloat(expression1)/100;
					screen.setText(expression1);
					concept.setText(expression1);
					if(operation != '0') concept.setText(expression1+operation);
					else concept.setText(expression1);
				}
			}
		});
		
		btnExp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation) {
					if(expression1 != "") {
						System.out.println(expression1);
						float aux = (float) Math.pow(Double.parseDouble(expression1), 2);
						if(aux - (int) aux == 0) expression1 = String.valueOf((int)aux);
						else expression1 = String.valueOf(aux);
					}
					if(expression1 != "") {
						screen.setText(expression1);
						if(operation != '0') concept.setText(expression1+operation);
						else concept.setText(expression1);
					}
				}
			}
		});
		
		btnDivition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation && expression1 != "") {
					System.out.println(">Divition");
					inOperation = true;
					lock();
					operation = '/';
					concept.setText(expression1+operation);
				}
			}
		});
		
		btnMultiplicacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation && expression1 != "") {
					System.out.println(">Multiplication");
					inOperation = true;
					lock();
					operation = '*';
					concept.setText(expression1+operation);
				}
			}
		});
		
		btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation && expression1 != "") {
					System.out.println(">Minus");
					inOperation = true;
					lock();
					operation = '-';
					concept.setText(expression1+operation);
				}
			}
		});
		
		btnPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!inOperation && expression1 != "") {
					System.out.println(">Plus");
					inOperation = true;
					lock();
					operation = '+';
					concept.setText(expression1+operation);
				}
			}
		});
		
		btnEquals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(expression1 != "" && operation != '0' && expression2 != "") {
					
					float a = Float.parseFloat(expression1);
					float b = Float.parseFloat(expression2);
					float c = 0;
					
					if(operation == '/') {
						c = a/b;
						if(c - (int) c == 0) {
							screen.setText( "" + (int) c);
							concept.setText("" + (int) c);
						}else {
							screen.setText( ""+c);
							concept.setText(""+c);
						}
					}
					else if(operation == '*') {
						c = a*b;
						if(c - (int) c == 0) {
							screen.setText( "" + (int) c);
							concept.setText("" + (int) c);
						}else {
							screen.setText( ""+c);
							concept.setText(""+c);
						}
					}
					else if(operation == '-') {
						c = a-b;
						if(c - (int) c == 0) {
							screen.setText( "" + (int) c);
							concept.setText("" + (int) c);
						}else {
							screen.setText( ""+c);
							concept.setText(""+c);
						}
					}
					else if(operation == '+') {
						c = a+b;
						if(c - (int) c == 0) {
							screen.setText( "" + (int) c);
							concept.setText("" + (int) c);
						}else {
							screen.setText( ""+c);
							concept.setText(""+c);
						}
					}
					
					if(c - (int) c == 0) expression1 = ""+ (int) c;
					else expression1 = ""+c;
					expression2 = "";
					isDot2 = false;
					operation = '0';
					inOperation = false;
					lock();
				}
			}
		});
		
		btnDot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!inOperation) {
					if(expression1.length() < 11) {
						if(expression2 == "") {
							if(!isDot1) {
								isDot1 = true;
								if(expression1.equals("")) expression1 += "0.";
								else expression1 += ".";
								screen.setText(expression1);
								concept.setText(expression1);
							}
						}
					}
				}else {
					if(expression2.length() < 11) {
						if(!isDot2) {
							isDot2 = true;
							if(expression2.equals("")) expression2 += "0.";
							else expression2 += ".";
							screen.setText(expression2);
							concept.setText(expression1+operation+expression2);
						}
					}
				}
			}
		});
	}
	
	//This avoid add more than one operation
	private void lock() {
		System.out.println("In Operation: "+inOperation);
		if(inOperation) {
			btnDivition.enable(false);
			btnMultiplicacion.enable(false);
			btnMinus.enable(false);
			btnPlus.enable(false);
			btnSqrt.enable(false);
			btnPercent.enable(false);
			btnExp.enable(false);
		}else {
			btnDivition.enable(true);
			btnMultiplicacion.enable(true);
			btnMinus.enable(true);
			btnPlus.enable(true);
			btnSqrt.enable(true);
			btnPercent.enable(true);
			btnExp.enable(true);
		}
	}
}