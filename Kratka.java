import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class Kratka
{
    int x, y, srodekX, srodekY;
    Color s, sw, w, nw, n, ne, e, se;
    boolean stan;
    public Kratka(int x, int y){
        this.x = x;
        this.y = y;
        srodekX = this.x + 7;
        srodekY = this.y + 7;
        stan = false;
    }
    public void sprawdzOtoczenie(BufferedImage plotno){
        int tmpX = srodekX, tmpY = srodekY;
        tmpY += 15;
        if(tmpY>482){
            tmpY = 8;
        }
        s = new Color(plotno.getRGB(tmpX,tmpY));
        tmpY = srodekY;
        tmpY += 15;
        tmpX -= 15;
        if(tmpY>482){
            tmpY = 8;
        }
        if(tmpX<0){
            tmpX = 474;
        }
        sw = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpY = srodekY;
        tmpX -= 15;
        if(tmpX<0){
            tmpX = 474;
        }
        w = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpX -= 15;
        tmpY -= 15;
        if(tmpX<0){
            tmpX = 474;
        }
        if(tmpY<0){
            tmpY = 474;
        }
        nw = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpY = srodekY;
        tmpY -= 15;
        if(tmpY<0){
            tmpY = 474;
        }
        n = new Color(plotno.getRGB(tmpX,tmpY));
        tmpY = srodekY;
        tmpX += 15;
        tmpY -= 15;
        if(tmpX>482){
            tmpX = 8;
        }
        if(tmpY<0){
            tmpY = 474;
        }
        ne = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpY = srodekY;
        tmpX += 15;
        if(tmpX>482){
            tmpX = 8;
        }
        e = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpX += 15;
        tmpY += 15;
        if(tmpX>482){
            tmpX = 8;
        }
        if(tmpY>482){
            tmpY = 8;
        }
        se = new Color(plotno.getRGB(tmpX,tmpY));
        tmpX = srodekX;
        tmpY = srodekY;
    }
    public void zmienStan(){
        int i = 0;
        int j = 0;
        if(stan==false){
            if(s.equals(Color.BLACK)){
                i++;
            }
            if(sw.equals(Color.BLACK)){
                i++;
            }
            if(w.equals(Color.BLACK)){
                i++;
            }
            if(nw.equals(Color.BLACK)){
                i++;
            }
            if(n.equals(Color.BLACK)){
                i++;
            }
            if(ne.equals(Color.BLACK)){
                i++;
            }
            if(e.equals(Color.BLACK)){
                i++;
            }
            if(se.equals(Color.BLACK)){
                i++;
            }
            if(i==3){
                stan = true;
            }
        }else{
            if(s.equals(Color.BLACK)){
                j++;
            }
            if(sw.equals(Color.BLACK)){
                j++;
            }
            if(w.equals(Color.BLACK)){
                j++;
            }
            if(nw.equals(Color.BLACK)){
                j++;
            }
            if(n.equals(Color.BLACK)){
                j++;
            }
            if(ne.equals(Color.BLACK)){
                j++;
            }
            if(e.equals(Color.BLACK)){
                j++;
            }
            if(se.equals(Color.BLACK)){
                j++;
            }
            if(j==2 || j==3){
                stan = true;
            }else{
                stan = false;
            }
        }
    }
}
