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

/**
 *
 * @author Ali
 */
public class BlackjackGame implements Game {

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
    
    private boolean HandleMenuOption(String option) {
        boolean exit = false;
        
        switch (option) {
            case "play":
            case "p":
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
                break;
        }
        
        return exit;
    }
    
    @Override
    public void DisplayHelp() {
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
