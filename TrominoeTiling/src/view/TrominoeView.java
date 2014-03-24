package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import controller.TrominoeController;

public class TrominoeView extends JFrame 
{
   private JFrame myMainView;
   private Container myContainer;
   private TrominoeController myController;
   private JPanel myBoardPanel, myStatsPanel;
   private static final long serialVersionUID = 1L;

   public TrominoeView( TrominoeController controller )
   {
	  myController = controller;
	  displayInterface();
   }
   
   public void displayInterface()
   {
	   myMainView = new JFrame();
	   myMainView.setSize(800, 600);
	   myMainView.setTitle("Tiling With Trominoes");
	   myMainView.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   myMainView.setVisible(true);
	   myMainView.setResizable(false);
	   
	   myContainer = myMainView.getContentPane();
	   myContainer.setLayout(null);
	   
	   myBoardPanel = new JPanel();
	   myBoardPanel.setSize(250,250);
	   myBoardPanel.setVisible(true);
	   myBoardPanel.setBounds( 150,130,500,300 );
	   myBoardPanel.setBackground(Color.WHITE);
	   myBoardPanel.setLayout(new GridLayout(myController.getBoardSize(),
			                                 myController.getBoardSize(),
			                                 myController.getBoardSize(),
			                                 myController.getBoardSize() ));
	   myContainer.add(myBoardPanel);
	   
	   JButton[][] myBoardButtons = new JButton[myController.getBoardSize()]
			   								   [myController.getBoardSize()];
		 
	   for(int i = 0; i < myBoardButtons.length; i++)
	   {
		   for(int j = 0 ; j < myBoardButtons[i].length; j++)
		   {
			   myBoardButtons[i][j] = new JButton();
			   myBoardButtons[i][j].setText("");
			   myBoardButtons[i][j].setFont(new Font("Georgia", Font.BOLD, 20));
			   myBoardButtons[i][j].setSize(20, 20);
			   myBoardButtons[i][j].setEnabled(false);
			   myBoardPanel.add(myBoardButtons[i][j]);
			 }
		}
	   
	    myStatsPanel = new JPanel();
	    myStatsPanel.setSize(250,250);
	    myStatsPanel.setVisible(true);
	    myStatsPanel.setBounds( 600,20,180,100 );
	    myStatsPanel.setBackground(Color.WHITE);
	    myContainer.add(myStatsPanel);
	    
		TitledBorder title = BorderFactory.createTitledBorder("Stats");
        title.setTitleJustification(TitledBorder.CENTER);
        myStatsPanel.setBorder(title);
        
        JButton runButton = new JButton("Tile Board");
        JButton refreshButton = new JButton("Refresh Board");
        runButton.setBounds(250, 460, 160, 30);
        refreshButton.setBounds(420, 460, 160, 30);
        myContainer.add(runButton);
        myContainer.add(refreshButton);
        
		updateView();
   }
   
   public void updateView()
   {
	   myMainView.validate();
	   myMainView.repaint();
   }
   
   public void killCurrentWindow() 
   {
	  myMainView.dispose();
   }
}