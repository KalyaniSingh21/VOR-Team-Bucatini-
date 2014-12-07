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
	
        JLabel lfreq = new JLabel("Frequency*");
        JTextField tfreq = new JTextField();
        
        JLabel lobs = new JLabel("OBS*");
        JTextField tobs = new JTextField();
        
        JLabel lid = new JLabel("ID");
        JLabel tid = new JLabel("");
                
        JLabel lradial = new JLabel("Radial");
        JLabel tradial = new JLabel("");
        
        JLabel ltofrom = new JLabel("To/From");
        JLabel ttofrom = new JLabel("");
        
        JLabel lbad = new JLabel("Good/Bad");
        JLabel tbad = new JLabel("");
                
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JButton left = new JButton("OBS-");
	JButton right = new JButton("OBS+");
        
	public Interface() 
	{
                super("VOR"); 
		
       		cnt.setLayout(new BorderLayout());
                cnt.setBackground(white);
		setSize(500,700);
                setVisible(true);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                panel.setLayout(null);
		panel.setBackground(white);
		panel.setEnabled(true);
		panel.setVisible(true);
                 
                cnt.add(new meter(),BorderLayout.PAGE_START);
                
                cnt.add(panel);
                panel.setBounds(0,500,500,200);
		
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
		lobs.setBounds(250,20,75,25);
		tobs.setBounds(350,20,75,25);
                lid.setBounds(50,50,75,25);
		tid.setBounds(150,50,75,25);
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
        
        public void initial() //Initializes all the values at start
        {   
                radio.setFrequency(Double.parseDouble(tfreq.getText()));
                r.setOBS(Integer.parseInt(tobs.getText()));
                update();
        }
        
        public void left() //Decreases OBS value by 1
        {
                r.setOBS(Integer.parseInt(tobs.getText())-1);
                update();
        }
        
        public void right() //Increases OBS value by 1
        {           
                r.setOBS(Integer.parseInt(tobs.getText())+1);
                update();
        }
        
        public void clear() //To clear all the fields
        {
                global.needle = 0;
                
                cnt.repaint();
                
                tfreq.setText("");
                tid.setText("");
                tobs.setText("");
                tradial.setText("");
                ttofrom.setText("");
                tbad.setText("");
        }
        
        public void update() //updates the variables from global and sets the JLabel values
        {
                global.ID = radio.getMorseCode();
                global.obs = r.getOBS();
                global.inte = r.intercepted;
                global.needle = r.getCDI();
                global.dir = r.isGoingTo();
                global.qual = r.isSignalGood(radio.badSigQual());
                               
                cnt.repaint();
                 
                tid.setText(global.ID);
                tobs.setText(Integer.toString(global.obs));
                tradial.setText(Integer.toString(global.inte));
                ttofrom.setText(global.dir);
                tbad.setText(global.qual);

                System.out.println(global.ID + ", "
                + global.obs + ", "
                + global.inte + ", "
                + global.needle + ", "
                + global.dir + ", "
                + global.qual);   
        }

	public static void main(String [] args)  
	{
		Interface inter = new Interface();    	
	}
}

//To draw meter
class meter extends JPanel
{
	public meter()
        {
		setBorder(BorderFactory.createLineBorder(Color.blue));
	}

        public Dimension getPreferredSize() 
        {
            return new Dimension(500,500);
        }
		
        public void paintComponent(Graphics g)
        {
		super.paintComponent(g);
		g.drawOval(100, 100, 300, 300); //To draw the circle
	
                for(int x = 150; x <= 350; x+= 20) //Draws lines of the scale
                {
			if(x == 250)
                        {
				g.drawLine(x, 250- 10, x, 250 + 10); //make the center line longer
			}
			else
                        {
				g.drawLine(x, 250 - 5, x, 250 + 5);
			}
		}
		
                //Lines on the oval
                g.drawLine(90,250,110,250);
		g.drawLine(250,90,250,110);
		g.drawLine(250,390,250,410);
		g.drawLine(390,250,410,250);
                
                //To draw the deflection needle
                g.drawLine(250 + (int)(10 * global.needle), 250 + 50, 250 + (int)(10 * global.needle), 250-50);
	}	
}

//Global variables to store values
class global
{
        public static String ID = "";
	public static int obs = 0;
        public static int inte = 0;
	public static int needle = 0;
	public static String dir = "";
	public static String qual = "";	
}