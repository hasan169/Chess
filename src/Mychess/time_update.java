/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mychess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Shagor Hasan
 */
public class time_update implements ActionListener {

    board ob;
    int x;
    int y;
    int z;
    Timer t1 = new Timer(1000, this);

    time_update(board ob1) {

        this.ob = ob1;
        x = 1;
        y = 5;
        z = 9;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ob.draw) {
            t1.stop();
        }
        z--;
        if (z < 0) {
            y--;
            z = 9;
        }
        if (y < 0) {
            y = 5;
            x--;
        }
        if (x < 0) {
            x = 1;
            ob.check = false;
            ob.timeout = true;
            t1.stop();
            if (ob.playerone) {
                ob.playertwowin = true;
            } else {

                ob.playeronewin = true;

            }

        }

    }
}
