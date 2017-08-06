/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mychess;

/**
 *
 * @author Shagor Hasan
 */
public class player {

    //define king 1
    //define queen 2
    //define bishop 3
    //define knight 4;
    //define rook 5
    //define pawn 6
    board ob;
    chess ref;
    int x1, x2;
    int y1, y2;

    player(board ob1) {

        ob = ob1;
    }

    public void edit() {

        ref = new chess();
        ref.col = "black";
        ref.player = 5;
        ref.x1 = 21;
        ref.x2 = 99;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][1] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 4;
        ref.x1 = 101;
        ref.x2 = 179;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][2] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 3;
        ref.x1 = 181;
        ref.x2 = 259;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][3] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 2;
        ref.x1 = 261;
        ref.x2 = 339;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][4] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 1;
        ref.x1 = 341;
        ref.x2 = 419;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][5] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 3;
        ref.x1 = 421;
        ref.x2 = 499;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][6] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 4;
        ref.x1 = 501;
        ref.x2 = 579;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][7] = ref;

        ref = new chess();
        ref.col = "black";
        ref.player = 5;
        ref.x1 = 581;
        ref.x2 = 659;
        ref.y1 = 40;
        ref.y2 = 119;
        ob.grid[1][8] = ref;
        x1 = 21;
        x2 = 99;
        y1 = 121;
        y2 = 199;
        for (int i = 1; i <= 8; i++) {

            ref = new chess();
            ref.x1 = x1;
            ref.x2 = x2;
            ref.y1 = y1;
            ref.y2 = y2;
            ref.player = 6;
            ref.col = "black";
            ob.grid[2][i] = ref;
            x1 = x1 + 80;
            x2 = x2 + 80;
        }
        y1 = 201;
        y2 = 279;
        for (int i = 3; i <= 6; i++) {
            x1 = 21;
            x2 = 99;

            for (int j = 1; j <= 8; j++) {

                ref = new chess();
                ref.x1 = x1;
                ref.x2 = x2;
                ref.y1 = y1;
                ref.y2 = y2;
                ref.player = 0;
                ref.col = "nil";
                ob.grid[i][j] = ref;
                x1 = x1 + 80;
                x2 = x2 + 80;

            }
            y1 = y1 + 80;
            y2 = y2 + 80;
        }
        x1 = 21;
        x2 = 99;
        y1 = 521;
        y2 = 599;
        for (int i = 1; i <= 8; i++) {
            ref = new chess();
            ref.x1 = x1;
            ref.x2 = x2;
            ref.y1 = y1;
            ref.y2 = y2;
            ref.player = 6;
            ref.col = "white";
            ob.grid[7][i] = ref;
            x1 = x1 + 80;
            x2 = x2 + 80;
        }

        ref = new chess();
        ref.col = "white";
        ref.player = 5;
        ref.x1 = 21;
        ref.x2 = 99;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][1] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 4;
        ref.x1 = 101;
        ref.x2 = 179;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][2] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 3;
        ref.x1 = 181;
        ref.x2 = 259;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][3] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 2;
        ref.x1 = 261;
        ref.x2 = 339;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][4] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 1;
        ref.x1 = 341;
        ref.x2 = 419;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][5] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 3;
        ref.x1 = 421;
        ref.x2 = 499;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][6] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 4;
        ref.x1 = 501;
        ref.x2 = 579;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][7] = ref;

        ref = new chess();
        ref.col = "white";
        ref.player = 5;
        ref.x1 = 581;
        ref.x2 = 659;
        ref.y1 = 601;
        ref.y2 = 679;
        ob.grid[8][8] = ref;
        ref = new chess();
        ref.x1 = 1100;
        ref.x2 = 1180;
        ref.y1 = 40;
        ref.y2 = 119;
        ref.player=0;
        ref.col="nil";
        ob.grid[1][9] = ref;
        ref = new chess();
        ref.x1 = 1100;
        ref.x2 = 1180;
        ref.y1 = 121;
        ref.y2 = 199;
        ref.player=0;
        ref.col="nil";
        ob.grid[2][9] = ref;
        ref = new chess();
        ref.x1 = 1100;
        ref.x2 = 1180;
        ref.y1 = 201;
        ref.y2 = 279;
        ref.player=0;
        ref.col="nil";
        ob.grid[3][9] = ref;
        ref = new chess();
        ref.x1 = 1100;
        ref.x2 = 1180;
        ref.y1 = 281;
        ref.y2 = 360;
        ref.player=0;
        ref.col="nil";
        ob.grid[4][9] = ref;
   
    }

}
