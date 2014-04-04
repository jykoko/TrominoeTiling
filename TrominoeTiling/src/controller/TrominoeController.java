package controller;

import javax.swing.JOptionPane;
import model.Board;
import model.TrominoeModel;
import view.TrominoeView;

public class TrominoeController 
{
   private TrominoeModel myModel;
   private TrominoeView myView;
   
   public TrominoeController()
   {
	   String input = JOptionPane.showInputDialog(null, "How many squares would you like in the grid? (N x N)");
       int boardSize = Integer.parseInt(input);
       
       Board board = new Board(boardSize);
       
       String defSquareX = JOptionPane.showInputDialog(null, "Enter an x value:");
       int x = Integer.parseInt(defSquareX);
       String defSquareY = JOptionPane.showInputDialog(null, "Enter an y value:");
       int y = Integer.parseInt(defSquareY);
       
       myModel = new TrominoeModel(boardSize, x, y);
 	   myView = new TrominoeView(this);
 	   System.out.println("GUI started, program is running.");
   }
   
   public void tileBoard()
   {
	   myModel.tile();
 	   myModel.print();
 	   displayBoardToInterface();
   }
   
   public void displayBoardToInterface()
   {
	   myView.displayBoard(myModel.getgrid());
   }
   
   public void resetBoardSize()
   {
	   myView.killCurrentWindow();
	   new TrominoeController();
   }
   
   public int getBoardSize()
   {
	   return myModel.getgrid().length;
   }
}