/*
 *
    Displays a window that displays the add new menu screen

    @author   Zihao Zhang
    @author   Hyun Bum Cho
    @version  CS56, Winter 2018
*/

package edu.ucsb.cs56.projects.utilities.restaurant_list;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class MenuPanel {
    JFrame frame;
    MainPanel gui;
    Food food;
    JPanel menuScreen, titlePanel, buttonPanel;
    JLabel menuLabel, pageTitle;
    JButton backToRestaurant;
    JFrame newframe;

    public MenuPanel(JFrame frame, MainPanel gui, Food food, String cuisineChoice) {
        this.gui = gui;
        this.food = food;
        //this.frame = frame;
        
        newframe = new JFrame();
        newframe.setSize(600,400);
        newframe.setVisible(true);

        menuScreen = new JPanel();
        menuScreen.setLayout(new BoxLayout(menuScreen, BoxLayout.Y_AXIS));
        
        String[] restaurantInfo = food.showAllInfo(cuisineChoice);

        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        menuLabel = new JLabel(restaurantInfo[6]);
        
        pageTitle = new JLabel("Menu");
        backToRestaurant = new JButton("Back");
        backToRestaurant.addActionListener(new BackOfMenuButtonListener());

        titlePanel.add(pageTitle);
        buttonPanel.add(backToRestaurant);
        
        menuScreen.add(titlePanel);
        menuScreen.add(menuLabel);
        if(restaurantInfo[5].equals("")){
            JLabel menuEmptyLabel = new JLabel("This restaurant does not have a menu online.");
            menuScreen.add(menuEmptyLabel);
        }
        menuScreen.add(buttonPanel);
        
        newframe.getContentPane().add(menuScreen);
    }

    public JLabel getTitle() {
        return pageTitle;
    }

    public JPanel getPanel() {
        return menuScreen;
    }
    
    class BackOfMenuButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
   	     newframe.dispatchEvent(new WindowEvent(newframe, WindowEvent.WINDOW_CLOSING));
      }
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
