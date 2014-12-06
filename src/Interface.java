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

        Radio radio = new Radio(0);
                
        VOR r = new VOR(radio.getRadial());
            
        
	Color white = new Color(255,255,255);
        
        JPanel panel = new JPanel();
	
        JLabel lfreq = new JLabel("Frequency");
        JTextField tfreq = new JTextField();
        
        JLabel lid = new JLabel("ID");
        JTextField tid = new JTextField();
                
        JLabel lobs = new JLabel("OBS");
        JTextField tobs = new JTextField();
        
        JLabel lradial = new JLabel("Radial");
        JTextField tradial = new JTextField();
        
        JLabel ltofrom = new JLabel("To/From");
        JTextField ttofrom = new JTextField();
        
        JLabel lbad = new JLabel("Good/Bad");
        JTextField tbad = new JTextField();
                
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JButton left = new JButton("Left");
	JButton right = new JButton("Right");
        
	public Interface() 
	{
                super("VOR"); 
		
       		cnt.setLayout(null);
                cnt.setBackground(white);
		setSize(500,500);
                setVisible(true);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                panel.setLayout(null);
		panel.setBackground(white);
		panel.setEnabled(true);
		panel.setVisible(true);
                        
                cnt.add(panel);
                panel.setBounds(0,300,500,200);
		
                panel.add(lfreq);
		panel.add(tfreq);
                panel.add(lid);
		panel.add(tid);
                panel.add(lobs);
		panel.add(tobs);
                panel.add(lradial);
		panel.add(tradial);
		panel.add(ltofrom);
		panel.add(ttofrom);
		panel.add(lbad);
		panel.add(tbad);
                
                start.addActionListener(this);
		panel.add(start);
		stop.addActionListener(this);
		panel.add(stop);
		left.addActionListener(this);
		panel.add(left);
		right.addActionListener(this);
		panel.add(right);
                
                lfreq.setBounds(50,20,75,25);
		tfreq.setBounds(150,20,75,25);
		lid.setBounds(250,20,75,25);
		tid.setBounds(350,20,75,25);
                lobs.setBounds(50,50,75,25);
		tobs.setBounds(150,50,75,25);
		lradial.setBounds(250,50,75,25);
		tradial.setBounds(350,50,75,25);
		ltofrom.setBounds(50,80,75,25);
		ttofrom.setBounds(150,80,75,25);
		lbad.setBounds(250,80,75,25);
		tbad.setBounds(350,80,75,25);
		left.setBounds(50,110,75,25);
		right.setBounds(150,110,75,25);
		start.setBounds(250,110,75,25);
		stop.setBounds(350,110,75,25);
    
	}
        
        public void actionPerformed(ActionEvent ae) 
        {
	        if(ae.getSource() == left)
                {
                    left();
		}
		
                if(ae.getSource() == right)
                {
                    right();
		}
		
                if(ae.getSource() == stop)
                {
                    clear();
		}
		
                if(ae.getSource() == start)
                {
                    initial();
		}
	}
        
        public void initial()
        {   
                radio.setFrequency(Double.parseDouble(tobs.getText()));
                r.setOBS(Integer.parseInt(tobs.getText()));
            
                update();
        }
        
        public void left()
        {
                r.setOBS(Integer.parseInt(tobs.getText())-1);
 
                update();
        }
        
        public void right()
        {           
                r.setOBS(Integer.parseInt(tobs.getText())+1);
 
                update();
        }
        
        public void clear()
        {
                tfreq.setText("");
                tid.setText("");
                tobs.setText("");
                tradial.setText("");
                ttofrom.setText("");
                tbad.setText("");
        }
        
        public void update()
        {
                tid.setText(radio.getMorseCode());
                tobs.setText(Integer.toString(r.getOBS()));
                tradial.setText(Integer.toString(r.intercepted));
                ttofrom.setText(r.isGoingTo());
                tbad.setText(r.isSignalGood(radio.badSigQual()));

                System.out.println(r.intercepted + ", "
                + r.getCDI() + ", "
                + r.isGoingTo() + ", "
                + r.isSignalGood(radio.badSigQual()));
            
        }
	

	public static void main(String [] args)  
	{
		Interface inter = new Interface();    	
    
                
	}

}