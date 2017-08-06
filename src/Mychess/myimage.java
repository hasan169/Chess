/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mychess;

import javax.swing.ImageIcon;

/**
 *
 * @author Shagor Hasan
 */
public class myimage {

    board ob;

    myimage(board ob1) {

        ob = ob1;
    }
    ImageIcon i;

    public void edit() {
        i = new ImageIcon(myimage.class.getResource("/picture/nouka.png"));
        ob.ig[1] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/ghora.png"));
        ob.ig[2] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/hati.png"));
        ob.ig[3] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/montri.png"));
        ob.ig[4] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/raja.png"));
        ob.ig[5] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/shonno.png"));
        ob.ig[6] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/nouka2.png"));
        ob.ig[7] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/ghora2.png"));
        ob.ig[8] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/hati2.png"));
        ob.ig[9] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/montri2.png"));
        ob.ig[10] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/raja2.png"));
        ob.ig[11] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/shonno2.png"));
        ob.ig[12] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/playerone.gif"));
        ob.ig[15] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/invalid.gif"));
        ob.ig[16] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/start.gif"));
        ob.ig[18] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/playertwo.gif"));
        ob.ig[19] = i.getImage();

        i = new ImageIcon(myimage.class.getResource("/picture/check.gif"));
        ob.ig[20] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/checkmate.gif"));
        ob.ig[21] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/playeronewin.png"));
        ob.ig[22] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/playertwowin.png"));
        ob.ig[23] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/timeout.png"));
        ob.ig[24] = i.getImage();
        i = new ImageIcon(myimage.class.getResource("/picture/draw.png"));
        ob.ig[29] = i.getImage();

        ob.grid[1][1].image = ob.ig[1];

        ob.grid[1][2].image = ob.ig[2];

        ob.grid[1][3].image = ob.ig[3];

        ob.grid[1][4].image = ob.ig[4];

        ob.grid[1][5].image = ob.ig[5];

        ob.grid[1][6].image = ob.ig[3];

        ob.grid[1][7].image = ob.ig[2];

        ob.grid[1][8].image = ob.ig[1];

        for (int j = 1; j <= 8; j++) {

            ob.grid[2][j].image = ob.ig[6];
        }

        ob.grid[8][1].image = ob.ig[7];

        ob.grid[8][2].image = ob.ig[8];

        ob.grid[8][3].image = ob.ig[9];

        ob.grid[8][4].image = ob.ig[10];

        ob.grid[8][5].image = ob.ig[11];

        ob.grid[8][6].image = ob.ig[9];

        ob.grid[8][7].image = ob.ig[8];

        ob.grid[8][8].image = ob.ig[7];

        for (int j = 1; j <= 8; j++) {

            ob.grid[7][j].image = ob.ig[12];
        }
    }
}
