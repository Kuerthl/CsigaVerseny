/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csigaverseny;
import java.util.Scanner;
/**
 *
 * @author kthla
 */
public class CsigaVerseny {

    static final int ROUNDS = 5;
    static final int PAUSE_SEC = 3;
    static Scanner scan = new Scanner(System.in);
    static IGame nGame = new Game();
    
    
    public static void main(String[] args) throws InterruptedException
    {       
        WriteOut();
        System.out.println("\nMelyik csigára szeretne fogadni?");
        System.out.println("Csiga száma: ");
        int index = scan.nextInt();
        nGame.Bet(nGame.getSnails()[index-1]);
        
        for(int i=0; i<ROUNDS; i++)
        {
            nGame.GameOn();
            System.out.println("\nAz " + (i+1) + ". kör állása a következő: ");
            WriteRounds();
            
            Thread.sleep(PAUSE_SEC*1000);
        }
        nGame.getWinnerSnail();
 
    }
    
    static void WriteOut()
    {
        for(int i=0; i<nGame.getSnails().length; i++)
        {
            System.out.println("\n" + (i+1) + ". csiga: " + nGame.getSnails()[i]);
        }
    }
    
    static void WriteRounds()
    {
        for(int i=0; i<nGame.getSnails().length; i++)
        {
            System.out.println("\nAz " + (i+1) + ". helyezett: " + nGame.getSnails()[i]);
        }
    }
    
}
