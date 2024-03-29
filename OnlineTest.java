package quiz.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener{

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];

	// creating jFrame with radioButton and JButton
	OnlineTest(String s) {
		
		label = new JLabel();
		add(label);

		bg = new ButtonGroup();
		for (int i=0;i<5;i++){
			radioButton [i]=new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext= new JButton("Next");
		btnBookmark= new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handling all actions based on event
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnNext){
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9){
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		//for bookmark
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(true);
		}
		for (int i=0,y=1;i<x;i++,y++) {
			if (e.getActionCommand().equals("Bookmark"+y)){
				if (check())
					count=count+1;
				now=current;
				current=m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current=now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this, "Your Score is : " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0){
			label.setText("Que1:  Which one of the following is not a java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("portable");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (current==1){
			label.setText("Que2:  What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
		}
		if (current == 2){
			label.setText("Que3: Which of the following is not an OOPS concept in java?");
			radioButton[0].setText("Polymorphism");
			radioButton[1].setText("Inheritance");
			radioButton[2].setText("compilation");
			radioButton[3].setText("Encapsulation");
		}
		if (current == 3){
			label.setText("Que4: Which of these are selection statements in java?");
			radioButton[0].setText("break");
			radioButton[1].setText("continue");
			radioButton[2].setText("for()");
			radioButton[3].setText("if()");
		}
		if (current == 4){
			label.setText("Que5:  Which one of the following is not an access modifier?");
			radioButton[0].setText(" protected");
			radioButton[1].setText("void");
			radioButton[2].setText("public");
			radioButton[3].setText("private");
		}
		if (current == 5){
			label.setText("Que6: What is the smallest header in html by default? ");
			radioButton[0].setText("h1");
			radioButton[1].setText("h2");
			radioButton[2].setText("h6");
			radioButton[3].setText("h4");
		}
		if (current == 6){
			label.setText("Que7:  How to create ordered list in html?");
			radioButton[0].setText("<ul>");
			radioButton[1].setText("<ol>");
			radioButton[2].setText("<href>");
			radioButton[3].setText("<b>");
		}
		if (current == 7){
			label.setText("Que8:  Which of the following tags doesn't require a closing tag?");
			radioButton[0].setText("<br>");
			radioButton[1].setText("<hr>");
			radioButton[2].setText("Both ");
			radioButton[3].setText("None of the above");
		}
		if (current == 8){
			label.setText("Que9: Which attribute is used to provide a unique name to an HTML?");
			radioButton[0].setText("id");
			radioButton[1].setText("class");
			radioButton[2].setText("style");
			radioButton[3].setText("none of the above");
		}
		if (current == 9){
			label.setText("Que10: What tag is used to render an image on a web page?");
			radioButton[0].setText("img");
			radioButton[1].setText("src");
			radioButton[2].setText("image");
			radioButton[3].setText("all the above");
		}
		
	}

	// declaring right answers.
	boolean check(){ 
		if (current==0)
			return (radioButton[2].isSelected());
		if (current==1)
			return (radioButton[3].isSelected());
		if (current==2)
			return (radioButton[2].isSelected());
		if (current==3)
			return (radioButton[3].isSelected());
		if (current==4)
			return (radioButton[1].isSelected());
		if (current==5)
			return (radioButton[2].isSelected());
		if (current==6)
			return (radioButton[1].isSelected());
		if (current==7)
			return (radioButton[1].isSelected());
		if (current==8)
			return (radioButton[0].isSelected());
		if (current==9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}