/*
    Interface
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame implements ActionListener
{  	
	Container cnt= getContentPane();

	Color white = new Color(255,255,255);
        
        JPanel panel = new JPanel();
	
	JButton start = new JButton("Start Simulation");
	JButton quit = new JButton("Quit Simulation");
	JButton left = new JButton("Left");
	JButton right = new JButton("Right");
		
	public Interface() 
	{  
		super("VOR"); 
		
		cnt.setLayout(null);
                cnt.setBackground(white);
		setSize(500,500);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                cnt.add(panel,BorderLayout.PAGE_END);
		
                start.addActionListener(this);
		panel.add(start);
		quit.addActionListener(this);
		panel.add(quit);
		left.addActionListener(this);
		panel.add(left);
		right.addActionListener(this);
		panel.add(right);
    
	}
        
        public void actionPerformed(ActionEvent ae) 
        {
	        if(ae.getSource() == left)
                {
		}
		
                if(ae.getSource() == right)
                {
		}
		
                if(ae.getSource() == quit)
                {
		}
		
                if(ae.getSource() == start)
                {
		}
	}
		

	public static void main(String [] args)  
	{
		Interface VOR = new Interface();
	}

}
