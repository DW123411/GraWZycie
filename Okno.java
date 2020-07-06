import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.Box;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class Okno extends JFrame implements ActionListener, MouseListener, MouseMotionListener
{
    Panel s = new Panel();
    JPanel dolny = new JPanel();
    String sciezkaDoPliku;
    String sciezkaDoPlikuTxt;
    JButton start = new JButton("Start");
    Timer timer;
    public Okno(){
        super("Gra w życie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable (false);
        //setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        setLayout(new BorderLayout(2,2));
        add(s,BorderLayout.CENTER);
        dolny.add(start);
        add(dolny,BorderLayout.PAGE_END);
        ustawNasluchZdarzen();        
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                s.sprawdzOtoczenieMacierz();
                s.zmienStanMacierz();
                s.czyscWszystko();
                s.rysujMacierz();
                repaint();
            }
        });
        dopasujSieDoZawartosci();
        setVisible(true);
    }
    private void ustawNasluchZdarzen(){
        start.addActionListener(this);
        s.addMouseListener(this);
        s.addMouseMotionListener(this);
    }
    private void dopasujSieDoZawartosci(){
        pack();
        setLocationRelativeTo(null);           
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String label = e.getActionCommand();
        Object src = e.getSource();
        if(label.equals("Start"))
        {
            timer.start();
            start.setText("Stop");
        }else if(label.equals("Stop")){
            timer.stop();
            start.setText("Start");
        }
    }
    @Override
    public void mousePressed(MouseEvent e){   
        
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if(SwingUtilities.isLeftMouseButton(e))
            s.zaznacz(e.getX(),e.getY());
    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override
    public void mouseExited(MouseEvent e){  

    }   
    @Override
    public void mouseReleased(MouseEvent e){

    }
    @Override
    public void mouseDragged(MouseEvent e){

    }
    @Override
    public void mouseMoved(MouseEvent e){

    }
}
