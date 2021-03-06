/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author
 */
public class BlackjackGame implements Game {

    Player player;
    Dealer dealer;
    Scanner input = new Scanner(System.in);
        
    private String GetInput() {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("-->");

        try {
            s = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(BlackjackGame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public void DisplayMenu() {
        System.out.println("Welcome to the game of Blackjack!");
        System.out.println("play (p) - Play Blackjack");
        System.out.println("help (h) - Help");
        System.out.println("exit (e) - Exit");
    }
    
    public void GetGameSettings() {
        System.out.print("Enter Number of Decks (1 - 8) ");
        String decks = GetInput();
        System.out.println("Interactive (i) or Auto (a) Game Play ");
    }
    
    public void GetPlayerSettings() {
        String name = "";
        
        while(name.equals("")){
          System.out.println("Player Name ");
          name = input.nextLine();
        }
              
        System.out.println("Player Buyin ");
        
        // This part will break if its not a double/int
        double balance = input.nextDouble();
        player = new Player(name, balance);
        System.out.println(player.toString());
        
        
        
    }
    
    private boolean HandleMenuOption(String option) {
        boolean exit = false;
        
        switch (option) {
            case "play":
            case "p":
                GetGameSettings();
                GetPlayerSettings();
                break;
            case "help":
            case "h":
                DisplayHelp();
                break;
            case "exit":
            case "e":
                exit = true;
                break;
            default:
                System.out.println("Invalid Option\n");
                break;
        }
        
        return exit;
    }
    
    @Override
    public void DisplayHelp() {
        System.out.println("*******************************************");
        System.out.println("OBJECT OF THE GAME");
        System.out.println("Each participant attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.");
        System.out.println("*******************************************\n");
    }

    @Override
    public void Run() {
        boolean exit = false;

        while (!exit) {
            DisplayMenu();
            String option = GetInput();
            exit = HandleMenuOption(option);
        }
    }
}
