package view;

import java.awt.Container;

import javax.swing.JFrame;

import controller.TrominoeController;

public class TrominoeView extends JFrame 
{
   private static final long serialVersionUID = 1L;
   private JFrame myMainView;
   private Container myContainer;
   private TrominoeController myController;

   public TrominoeView( TrominoeController controller )
   {
	  myController = controller;
	  displayInterface();
   }
   
   public void displayInterface()
   {
	   myMainView = new JFrame();
	   myMainView.setSize(600, 600);
	   myMainView.setTitle("Tiling With Trominoes");
	   myMainView.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   myContainer = myMainView.getContentPane();
   }
   
   public void killCurrentWindow() 
   {
	  myMainView.dispose();
   }
}