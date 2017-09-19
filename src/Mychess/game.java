/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mychess;

import java.awt.Image;

/**
 *
 * @author Shagor Hasan
 */
public class game {

    board ob;
    int player;
    String col;
    Image ig;
    int dx;
    int dy;
    int x;
    int y;
    boolean flag = false;
    game2 ob2;
    game(board ob1) {
        ob2 = new game2(ob1, this);
        ob = ob1;
    }
    public void move(int counter, int x1, int y1) {
        if (counter == 1) {
            flag = false;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if ((x1 >= ob.grid[i][j].x1 && x1 <= ob.grid[i][j].x2) && (y1 >= ob.grid[i][j].y1 && y1 <= ob.grid[i][j].y2)) {
                        if (ob.grid[i][j].col.equals(col)) {
                            counter = 0;
                            flag = true;
                            break;
                        } else {
                            flag = true;
                            this.x = x1;
                            this.y = y1;
                            ob2.edit();
                            if (ob.playerone) {
                                ob.playeronecounter = 0;

                            } else if (ob.playertwo) {
                                ob.playertwocounter = 0;
                            }
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        if (counter == 0) {
            flag = false;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if ((x1 >= ob.grid[i][j].x1 && x1 <= ob.grid[i][j].x2) && (y1 >= ob.grid[i][j].y1 && y1 <= ob.grid[i][j].y2)) {
                        if (ob.grid[i][j].player == 0) {
                            flag = true;
                            break;
                        } else {
                            if (ob.playerone == true) {
                                if (ob.grid[i][j].col.equals("black")) {
                                    flag = true;
                                    ob.invalid = true;
                                    break;
                                }
                            } else if (ob.playertwo == true) {
                                if (ob.grid[i][j].col.equals("white")) {
                                    flag = true;
                                    ob.invalid = true;
                                    break;
                                }
                            }
                            ob.check = false;
                            if (ob.playerone) {
                                ob.playeronecounter = 1;
                            } else if (ob.playertwo) {
                                ob.playertwocounter = 1;
                            }
                            ob.wpawny = y1;
                            player = ob.grid[i][j].player;
                            col = ob.grid[i][j].col;
                            ig = ob.grid[i][j].image;
                            dx = i;
                            dy = j;
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}
