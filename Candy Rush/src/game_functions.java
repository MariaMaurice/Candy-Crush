/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria
 */
public abstract class game_functions {
    public abstract void removeCrushedCandy(Candy candy[][] , int row, int col);
    public abstract boolean bool_horizontal_check(int row,int col,Candy candy[][]);
    public abstract boolean bool_vertical_check(int row,int col,Candy candy[][]);
     public abstract void horizontal_check(int row,int col,Candy candy[][]);
     public abstract void vertical_check(int row,int col,Candy candy[][]);
     public abstract boolean win();
     public abstract void horizontal_4_check(int row,int col,Candy candy[][]);
     public abstract void vertical_4_check(int row,int col,Candy candy[][]);
     public abstract boolean bool_horizontal_4_check(int row,int col,Candy candy[][]);
     public abstract boolean bool_vertical_4_check(int row,int col,Candy candy[][]);
     public abstract void re_fill(Candy candy[][]);
     public abstract void special (int row , int col , Candy candy[][]);
      public abstract void effect (int row , int col , Candy candy[][] );
}

