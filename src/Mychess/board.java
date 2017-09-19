/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mychess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Shagor Hasan
 */
public class board extends javax.swing.JFrame implements ActionListener, MouseListener, KeyListener {

    /**
     * Creates new form board
     */
    Image image;
    int x;
    boolean recover = false;
    int playeronecounter = 0;
    int playertwocounter = 0;
    game ob;
    boolean start = false;
    boolean checkmate = false;
    boolean playerone = false;
    boolean playertwo = false;
    int y;
    boolean invalid = false;
    Timer t1 = new Timer(5, this);
    Image db;
    Color c;
    int RecoveredPlayer = 0;
    Color c3;
    time_update ob1;
    Image ig[] = new Image[30];
    Graphics dbg;
    Color c1;
    Image ib;
    boolean show = true;
    chess[][] grid = new chess[12][12];
    Color c2;
    Color c4;
    int wpawny;
    boolean check = false;
    boolean playeronewin = false;
    boolean playertwowin;
    boolean timeout = false;
    boolean draw = false;
    boolean whitecountdown = false;
    boolean blackcountdown = false;
    int blackcount;
    int whitecount;

    public board() {
        initComponents();
        c2 = new Color(64, 0, 0);
        c1 = new Color(255, 154, 53);
        c = new Color(74, 37, 0);
        new player(this).edit();
        new myimage(this).edit();
        this.setVisible(true);
        addMouseListener(this);
        addKeyListener(this);
        c4 = new Color(0, 0, 0);
        c3 = new Color(0, 128, 128);
        this.setSize(1200, 700);
        ob1 = new time_update(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob = new game(this);
        t1.start();
    }

    @Override
    public void paint(Graphics g) {
        db = createImage(getWidth(), getHeight());
        dbg = db.getGraphics();
        paintComponent(dbg);
        g.drawImage(db, 10, 20, this);
    }
    public void paintComponent(Graphics g) {
        g.setColor(c3);
        g.fillRect(0, 0, 1200, 1000);
        g.setColor(c4);
        if (!show) {
            g.drawString("0", 720, 100);
            g.drawString(ob1.x + "", 730, 100);
            g.drawString(":", 740, 100);
            g.drawString(ob1.y + "", 750, 100);
            g.drawString(ob1.z + "", 760, 100);
        }
        g.setColor(c2);
        g.fillRect(0, 0, 662, 900);
        y = 20;
        for (int j = 1; j <= 4; j++) {
            x = 10;
            for (int i = 1; i <= 4; i++) {
                g.setColor(c);
                g.fillRect(x, y, 80, 80);
                x = x + 80;
                g.setColor(c1);
                g.fillRect(x, y, 80, 80);
                x = x + 80;
            }
            y = y + 80;
            x = 10;
            for (int i = 1; i <= 4; i++) {
                g.setColor(c1);
                g.fillRect(x, y, 80, 80);
                x = x + 80;
                g.setColor(c);
                g.fillRect(x, y, 80, 80);
                x = x + 80;
            }
            y = y + 80;
        }
        if (recover) {
            x = 1100;
            y = 20;
            for (int i = 1; i <= 4; i++) {
                g.setColor(c);
                g.fillRect(x, y, 100, 80);
                y = y + 80;
                g.setColor(c1);
                g.fillRect(x, y, 100, 80);
                y = y + 80;
            }
            for (int i = 1; i <= 4; i++) {
                g.drawImage(grid[i][9].image, grid[i][9].x1 + 15, grid[i][9].y1 - 22, this);
            }
        }
        if (show) {
            g.drawImage(ig[18], 700, 200, this);
        }
        if (playerone) {
            g.drawImage(ig[15], 700, 300, this);
        }
        if (playertwo) {
            g.drawImage(ig[19], 700, 300, this);
        }
        if (invalid) {
            g.drawImage(ig[16], 700, 400, this);
        }
        if (check) {
            g.drawImage(ig[20], 700, 500, this);
        }
        if (checkmate) {
            this.playerone = false;
            this.playertwo = false;
            g.drawImage(ig[21], 700, 500, this);
        }
        if (timeout) {
            this.playerone = false;
            this.playertwo = false;
            g.drawImage(ig[24], 650, 500, this);
        }
        if (draw) {
            this.playerone = false;
            this.playertwo = false;
            g.drawImage(ig[29], 650, 300, this);
        }
        if (this.playeronewin) {
            g.drawImage(ig[22], 700, 300, this);
        }
        if (this.playertwowin) {
            g.drawImage(ig[23], 700, 300, this);
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                g.drawImage(grid[i][j].image, grid[i][j].x1 + 15, grid[i][j].y1 - 22, this);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent me) {
        if (start) {
            invalid = false;
            if (playerone) {
                if (playeronecounter == 0) {
                    ob.move(0, me.getX(), me.getY());
                } else if (playeronecounter == 1) {
                    ob.move(1, me.getX(), me.getY());
                }

            } else if (playertwo) {
                if (playertwocounter == 0) {
                    ob.move(0, me.getX(), me.getY());
                } else if (playertwocounter == 1) {
                    ob.move(1, me.getX(), me.getY());
                }
            }
        } else if (recover) {
            if (me.getX() >= 1100 && me.getX() <= 1180) {
                if (me.getY() >= 40 && me.getY() <= 119) {
                    if (this.grid[1][9].player != 0) {
                        this.RecoveredPlayer = this.grid[1][9].player;
                        ob.ob2.rg = grid[1][9].image;
                    }
                } else if (me.getY() >= 121 && me.getY() <= 199) {
                    if (this.grid[2][9].player != 0) {
                        this.RecoveredPlayer = this.grid[2][9].player;
                        ob.ob2.rg = grid[2][9].image;
                    }
                } else if (me.getY() >= 201 && me.getY() <= 279) {
                    if (this.grid[3][9].player != 0) {
                        this.RecoveredPlayer = this.grid[3][9].player;
                        ob.ob2.rg = grid[3][9].image;
                    }
                } else if (me.getY() >= 281 && me.getY() <= 360) {
                    if (this.grid[4][9].player != 0) {
                        this.RecoveredPlayer = this.grid[4][9].player;
                        ob.ob2.rg = grid[4][9].image;
                    }
                }
            }
            playeronecounter = 0;
            playertwocounter = 0;
            ob.ob2.setplayer();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseClicked(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseExited(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //    new board().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            if (show) {
                start = true;
                playerone = true;
                ob1.t1.start();
                show = false;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
