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
public class game2 {

    //define king 1
    //define queen 2
    //define bishop 3
    //define knight 4;
    //define rook 5
    //define pawn 6
    int rx;
    int ry;
    Image rg;
    int cutplayer;
    String cutcolour;
    boolean flag = false;
    boolean flag1 = false;
    boolean recover = false;
    board ob;
    game ob1;
    check ob2;
    int white[] = new int[10];
    int black[] = new int[10];
    checkmate ob3;
    boolean rec = false;
    int tempplayer;
    String tempcol;
    Image tempig;
    int whitecounter;
    int blackcounter;
    int wpawnfx[] = {-1, -1, -1, -2};
    int wpawnfy[] = {1, -1, 0, 0};
    int bpawnfx[] = {1, 1, 1, 2};
    int bpawnfy[] = {1, -1, 0, 0};
    int knightfx[] = {-1, 1, -1, 1, -2, -2, 2, 2};
    int knightfy[] = {2, 2, -2, -2, 1, -1, 1, -1};
    int kingfx[] = {0, 0, -1, 1, -1, -1, 1, 1};
    int kingfy[] = {1, -1, 0, 0, 1, -1, 1, -1};
    int rookfx[] = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int rookfy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    int bishopfx[] = {-1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
    int bishopfy[] = {1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    int queenfx[] = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
    int queenfy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    
    game2(board ob5, game ob6) {
        ob = ob5;
        ob1 = ob6;
        ob2 = new check(ob, ob1, this);
        ob3 = new checkmate(ob2, this, ob);
    }
    public void edit() {
        cutplayer = 0;
        int tx = 0, ty = 0;
        flag = true;
        if (ob1.player == 6) {
            for (int j = 0; j < 4; j++) {
                switch (ob1.col) {
                    case "white":
                        tx = ob1.dx + wpawnfx[j];
                        ty = ob1.dy + wpawnfy[j];
                        break;
                    case "black":
                        tx = ob1.dx + bpawnfx[j];
                        ty = ob1.dy + bpawnfy[j];
                        break;
                }
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (j == 3) {
                            if (ob1.col.equals("white")) {
                                if (!(ob.wpawny >= 520 && ob.wpawny <= 600)) {
                                    break;
                                }
                            } else {
                                if (!(ob.wpawny >= 120 && ob.wpawny <= 200)) {
                                    break;
                                }
                            }
                        }
                        if (j <= 1 && ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                            set(tx, ty);
                            flag = false;
                            break;
                        } else if (j > 1 && ob.grid[tx][ty].player == 0) {
                            set(tx, ty);
                            flag = false;
                            break;
                        }
                    }
                    if (j == 2 && ob.grid[tx][ty].player != 0) {
                        break;
                    }
                }
            }
        } else if (ob1.player == 4) {
            for (int j = 0; j < 8; j++) {
                tx = ob1.dx + knightfx[j];
                ty = ob1.dy + knightfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                        }
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 1) {
            for (int j = 0; j < 8; j++) {
                tx = ob1.dx + kingfx[j];
                ty = ob1.dy + kingfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                        }
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 5) {
            for (int j = 0; j < 28; j++) {
                tx = ob1.dx + rookfx[j];
                ty = ob1.dy + rookfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        }
                    }
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                        }
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 3) {
            for (int j = 0; j < 28; j++) {
                tx = ob1.dx + bishopfx[j];
                ty = ob1.dy + bishopfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        }
                    }
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                        }
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 2) {
            for (int j = 0; j < 56; j++) {
                tx = ob1.dx + queenfx[j];
                ty = ob1.dy + queenfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        } else if (j < 34) {
                            j = 34;
                        } else if (j < 41) {
                            j = 41;
                        } else if (j < 48) {
                            j = 48;
                        } else if (j < 55) {
                            j = 55;
                        }
                    }
                    if ((ob1.x >= ob.grid[tx][ty].x1 && ob1.x <= ob.grid[tx][ty].x2) && (ob1.y >= ob.grid[tx][ty].y1 && ob1.y <= ob.grid[tx][ty].y2)) {
                        if (ob.grid[tx][ty].player != 0) {
                            this.cutplayer = ob.grid[tx][ty].player;
                            this.cutcolour = ob.grid[tx][ty].col;
                        }
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            flag1 = false;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (!ob.grid[i][j].col.equals(ob1.col)) {
                        flag1 = ob2.cm(i, j, ob.grid[i][j].col, ob.grid[i][j].player, false);
                    }
                    if (flag1) {
                        ob.grid[ob1.dx][ob1.dy].col = ob1.col;
                        ob.grid[ob1.dx][ob1.dy].player = ob1.player;
                        ob.grid[ob1.dx][ob1.dy].image = ob1.ig;
                        ob.grid[tx][ty].col = this.tempcol;
                        ob.grid[tx][ty].player = this.tempplayer;
                        ob.grid[tx][ty].image = this.tempig;
                        flag = true;
                        break;
                    }
                }
                if (flag1) {
                    break;
                }
            }
        }
        flag1 = false;
        if (flag) {
            ob.invalid = true;
            rec = false;
        } else {
            if (this.cutplayer != 0) {
                if ("white".equals(this.cutcolour)) {
                    white[this.cutplayer]++;
                    whitecounter++;
                } else {
                    blackcounter++;
                    black[this.cutplayer]++;
                }
            }
            if (ob.playerone) {
                if (ob.whitecountdown) {
                    ob.whitecount++;
                }
            }
            if (ob.playertwo) {
                if (ob.blackcountdown) {
                    ob.blackcount++;
                }
            }
            if (ob.whitecount == 17) {
                ob.draw = true;
                ob.start = false;
            }
            if (ob.blackcount == 17) {
                ob.draw = true;
                ob.start = false;
            }
            if (whitecounter == 15) {
                whitecounter = 0;
                ob.whitecountdown = true;
            }
            if (blackcounter == 15) {
                blackcounter = 0;
                ob.blackcountdown = true;
            }
            if (rec) {
                recover();
            } else {
                setcheck();
            }
        }
    }
    public void setcheck() {
        flag1 = false;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (ob.grid[i][j].col.equals(ob1.col)) {
                    flag1 = ob2.cm(i, j, ob1.col, ob.grid[i][j].player, true);
                    if (flag1) {
                        break;
                    }
                }

            }
            if (flag1) {
                break;
            }
        }
        if (flag1) {
            flag1 = false;
            boolean b = false;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (ob.grid[i][j].player == 1 && !ob.grid[i][j].col.equals(ob1.col)) {
                        b = ob3.edit(i, j, ob.grid[i][j].col);
                        flag1 = true;
                        break;
                    }
                }
                if (flag1) {
                    break;
                }
            }
            if (b) {
                ob.checkmate = true;
                if (ob.playerone) {
                    ob.playeronewin = true;
                } else if (ob.playertwo) {
                    ob.playertwowin = true;
                }
            } else {
                ob.check = true;
            }
        }
        if (ob.playerone) {
            ob.playerone = false;
            ob.playertwo = true;
        } else if (ob.playertwo) {
            ob.playerone = true;
            ob.playertwo = false;
        }
        ob.ob1.t1.stop();
        ob.ob1.x = 1;
        ob.ob1.y = 5;
        ob.ob1.z = 9;
        ob.ob1.t1.start();
        if (ob.checkmate) {
            ob.ob1.t1.stop();
        }
    }
    public void set(int x, int y) {
        this.tempcol = ob.grid[x][y].col;
        this.tempplayer = ob.grid[x][y].player;
        this.tempig = ob.grid[x][y].image;
        ob.grid[x][y].col = ob1.col;
        ob.grid[x][y].player = ob1.player;
        ob.grid[x][y].image = ob1.ig;
        ob.grid[ob1.dx][ob1.dy].col = "nil";
        ob.grid[ob1.dx][ob1.dy].player = 0;
        ob.grid[ob1.dx][ob1.dy].image = ob.ig[13];
        if (ob1.player == 6) {
            rx = x;
            ry = y;
            if (ob1.col.equals("white")) {
                if (x == 1) {
                    for (int i = 2; i <= 5; i++) {
                        if (white[i] != 0) {
                            rec = true;
                            break;
                        }
                    }
                }
            } else if (ob1.col.equals("black")) {
                if (x == 8) {
                    for (int i = 2; i <= 5; i++) {
                        if (black[i] != 0) {
                            rec = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void recover() {
        int add = 1;
        ob.recover = true;
        ob.start = false;
        if (ob.playerone) {
            if (white[2] != 0) {
                ob.grid[add][9].player = 2;
                ob.grid[add][9].col = "white";
                ob.grid[add][9].image = ob.ig[10];
                add++;
            }
            if (white[3] != 0) {
                ob.grid[add][9].player = 3;
                ob.grid[add][9].col = "white";
                ob.grid[add][9].image = ob.ig[9];
                add++;
            }
            if (white[4] != 0) {
                ob.grid[add][9].player = 4;
                ob.grid[add][9].col = "white";
                ob.grid[add][9].image = ob.ig[8];
                add++;
            }
            if (white[5] != 0) {
                ob.grid[add][9].player = 5;
                ob.grid[add][9].col = "white";
                ob.grid[add][9].image = ob.ig[7];
                add++;
            }
        } else if (ob.playertwo) {
            if (black[2] != 0) {
                ob.grid[add][9].player = 2;
                ob.grid[add][9].col = "black";
                ob.grid[add][9].image = ob.ig[4];
                add++;
            }
            if (black[3] != 0) {
                ob.grid[add][9].player = 3;
                ob.grid[add][9].col = "black";
                ob.grid[add][9].image = ob.ig[3];
                add++;
            }
            if (black[4] != 0) {
                ob.grid[add][9].player = 4;
                ob.grid[add][9].col = "black";
                ob.grid[add][9].image = ob.ig[2];
                add++;
            }
            if (black[5] != 0) {
                ob.grid[add][9].player = 5;
                ob.grid[add][9].col = "black";
                ob.grid[add][9].image = ob.ig[1];
                add++;
            }
        }
    }
    public void setplayer() {
        if (ob.RecoveredPlayer != 0) {
            ob.grid[rx][ry].player = ob.RecoveredPlayer;
            ob.grid[rx][ry].image = rg;
            rec = false;
            ob.start = true;
            ob.recover = false;
            for (int i = 1; i <= 4; i++) {
                ob.grid[i][9].player = 0;
                ob.grid[i][9].image = ob.ig[27];
            }
            if (ob.playerone) {
                white[ob.RecoveredPlayer]--;
            } else {
                black[ob.RecoveredPlayer]--;
            }
            ob.RecoveredPlayer = 0;
            this.setcheck();
        }
    }
}
