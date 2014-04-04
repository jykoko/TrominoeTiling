package controller;

import javax.swing.JOptionPane;
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
       
       String defSquareX = JOptionPane.showInputDialog(null, "Enter an x value:");
       int defX = Integer.parseInt(defSquareX);
       String defSquareY = JOptionPane.showInputDialog(null, "Enter an y value:");
       int defY = Integer.parseInt(defSquareY);
       myModel = new TrominoeModel(boardSize, defX, defY);
       
 	   myView = new TrominoeView(this);
 	   System.out.println("GUI started, program is running.");
   }
   
   public void tileBoard()
   {
	   myModel.tile();
 	   myModel.getBoard().printBoard();
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
   
   public int[][] getBoard()
   {
	   return myModel.getgrid();
   }
   
   public int getBoardSize()
   {
	   return myModel.getgrid().length;
   }
}