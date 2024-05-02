/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package csigaverseny;
import java.util.Random;
/**
 *
 * @author kthla
 */
public class Game implements IGame 
{
    private final int SNAIL_MAX_NUM = 3;
    private static Random rnd = new Random();   
    private ISnail[] snails;
    private ISnail betOnSnail;
    
    //konstruktor
    public Game()
    {
        this.snails = new ISnail[SNAIL_MAX_NUM];
        
        for(int i=0; i<SNAIL_MAX_NUM; i++)
        {
            this.snails[i] = new Snail(GenerateRandomColor(), Speed());
        }
        AddSpeedBoost();
    }

    @Override
    public void Bet(ISnail snail)
    {
        this.betOnSnail = snail;
    }

    @Override
    public ISnail[] getSnails() 
    {
        return this.snails;
    }

    @Override
    public void GameOn() 
    {
        for(ISnail x : snails)
        {
            //amennyiben kapott sebességgyorsítót, úgy 2x olyan gyors lesz, különben csak "normál" tempó marad
            x.setRange(x.getPace()*(x.getHasSpeedBoost()? 2 : 1));
            SortByPos();
            x.setHasSpeedBoost(false);
            x.setPace(Speed());
        }
        AddSpeedBoost();
    }

    @Override
    public void getWinnerSnail() 
    {
        int index = 0;
        
        for(int i=1; i<this.snails.length; i++)
        {
            if(this.snails[i].getRange() > this.snails[index].getRange())
            {
                index = i;
            }
        }
        
        boolean hasWin = (this.betOnSnail == this.snails[index]);
        
        System.out.println((hasWin ? "\nÖn nyert" : "\nSajnos nem nyert"));
    }

    private String GenerateRandomColor()
    {
        String color = Snail.possibleColors[rnd.nextInt(Snail.possibleColors.length)];
        boolean ok = false;
        
        //addig generálunk, amíg az adott szin ténylegesen nem szerepel
        while(!ok)
        {
            int i = 0;
            
            //tömbön belül vagyunk és nem null (létrehozás után nyilván az) és a szín nem található meg a tömbben
            while(i<this.snails.length && this.snails[i] != null && !this.snails[i].getColor().equals(color))
            {
                i++;
            }
            
            if(this.snails[i]==null)
            {
                ok = true;
            }
            else
            {
                color = Snail.possibleColors[rnd.nextInt(Snail.possibleColors.length)];
            }
        }
        return color;
        
    }
    
    //milyen sebessége legyen a csigának
    private int Speed()
    {
        final int RND_RANGE = 100000;
        int rNum = rnd.nextInt(RND_RANGE);
        
        //ugyanakkora eséllyel kaphatja meg minde a 4 féle sebességet (0...4)
        if(rNum < RND_RANGE * 0.25)
        {
            return 0;
        }
        else if(rNum >= RND_RANGE*0.25 && rNum < RND_RANGE*0.5)
        {
            return 1;
        }
        else if(rNum >= RND_RANGE*0.5 && rNum < RND_RANGE*0.75)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }
    
    //Kaphat bármelyik csiga sebesség boostot?
    private boolean HasBoost()
    {
        final int RND_RANGE = 100000;
        int rNum = rnd.nextInt(RND_RANGE);
        
        if(rNum < RND_RANGE *0.2)
        {
            return true;
        }
        
        return false;
      
    }
    
    private void AddSpeedBoost()
    {
        if(HasBoost())
        {
            int snailIdx = rnd.nextInt(this.snails.length);
            this.snails[snailIdx].setHasSpeedBoost(true);
        }
    }
    
    private void SortByPos()
    {
        for(int i=0; i<this.snails.length-1; i++)
        {
            for(int j=i+1; j<this.snails.length; j++)
            {
                if(this.snails[i].getRange() < this.snails[j].getRange())
                {
                    ISnail temp = this.snails[i];
                    this.snails[i] = this.snails[j];
                    this.snails[j] = temp;
                }
            }
        }
    }
}
