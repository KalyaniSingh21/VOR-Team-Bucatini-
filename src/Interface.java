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
                + global.dir + ", "
                + global.qual);
            
        }
	

	public static void main(String [] args)  
	{
		Interface inter = new Interface();    	
    
                
	}

}

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
		g.drawOval(100, 100, 300, 300); 
	
                for(int x = 150; x <= 350; x+= 20){
			if(x == 250){
				g.drawLine(x, 250- 10, x, 250 + 10); //make the center line longer
			}
			else{
				g.drawLine(x, 250 - 5, x, 250 + 5);
			}
		}
		
                g.drawLine(90,250,110,250);
		g.drawLine(250,90,250,110);
		g.drawLine(250,390,250,410);
		g.drawLine(390,250,410,250);
		/*
		if(global.dir.equals("TO")){
			g.drawString("TO", 280, 170);
			
			g.drawString("Signal: GOOD", 250, 450);
		}
		if(global.dir.equals("FROM")){
			g.drawString("FR", 280, 260);
			
			g.drawString("Signal: GOOD", 250, 450);
		}
		
		g.drawString("Station ID: " + global.ID, 100, 450);
		*/
		g.drawLine(250 + (int)(10 * global.needle), 250 + 50, 250 + (int)(10 * global.needle), 250-50);
		
		
	}
	
}

class global
{
        public static String ID = "";
	public static int obs = 0;
        public static int inte = 0;
	public static int needle = 0;
	public static String dir = "";
	public static String qual = "";	
}