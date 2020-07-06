import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.geom.*;
public class Panel extends JPanel
{
    BufferedImage plotno;
    Kratka macierz[][];
    public Panel(){
        super();   
        setLayout(new GridLayout(2,1));
        ustawRozmiar(new Dimension(482,482));
        czyscWszystko();
        macierz = new Kratka[30][30];
        int x = 1, y = 1;
        for(int i=0;i<=29;i++){
            for(int j=0;j<=29;j++){
                macierz[i][j] = new Kratka(x,y);
                x += 16;
                if(j==29){
                    x = 1;
                }
            }
            y += 16;
        }
        y = 1;
        rysujMacierz();
    }
    public void ustawRozmiar(Dimension r){
        plotno = new BufferedImage((int)r.getWidth(), (int)r.getHeight(), BufferedImage.TYPE_INT_RGB);
        setPreferredSize(r);     
        setMaximumSize(r);
    }
    public void czyscWszystko(){
        Graphics2D g = (Graphics2D) plotno.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, plotno.getWidth(), plotno.getHeight());
        repaint();
    }
    public void rysujKratke(Kratka k){
        Graphics2D g = (Graphics2D) plotno.getGraphics();
        g.setColor(Color.BLACK);
        Stroke stary = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.drawRect(k.x, k.y, 15, 15);
        if(k.stan==false){
            g.setColor(Color.WHITE);
            g.fillRect(k.x,k.y,15,15);
        }else{
            g.setColor(Color.BLACK);
            g.fillRect(k.x,k.y,15,15);
        }
        g.setStroke(stary);
        repaint();
    }
    public void rysujMacierz(){
        for(int i=0;i<=29;i++){
            for(int j=0;j<=29;j++){
                rysujKratke(macierz[i][j]);
            }
        }
        repaint();
    }
    public void zaznacz(int x, int y){
        int sX, sY;
        for(int i=0;i<=29;i++){
            for(int j=0;j<=29;j++){
                sX = macierz[i][j].srodekX;
                sY = macierz[i][j].srodekY;
                if(x>=sX-7 && x<=sX+7){
                    if(y>=sY-7 && y<=sY+7){
                        macierz[i][j].stan = !(macierz[i][j].stan);
                    }
                }
            }
        }
        rysujMacierz();
    }
    public void sprawdzOtoczenieMacierz(){
        for(int i=0;i<=29;i++){
            for(int j=0;j<=29;j++){
                ((Kratka)macierz[i][j]).sprawdzOtoczenie(plotno);
            }
        }
    }
    public void zmienStanMacierz(){
        for(int i=0;i<=29;i++){
            for(int j=0;j<=29;j++){
                ((Kratka)macierz[i][j]).zmienStan();
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; 
        g2d.drawImage(plotno, 0, 0, this);
    }    
}
