/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

/**
 *
 * @author kthla
 */
public class Snail implements ISnail
{
    
    private final String[] possibleColors = {"Kék", "Piros", "Zöld"};
    private String color="";
    private boolean hasSpeedBoost;
    private int pace;
    private int range;
    
    public Snail(String color, int pace)
    {
        this.color = color;
        this.hasSpeedBoost = false;
        this.pace = pace;
        this.range = 0;
    }
    
    
    @Override
    public boolean getHasSpeedBoost() 
    {
        return this.hasSpeedBoost;
    }

    @Override
    public void setHasSpeedBoost(boolean value) {
       this.hasSpeedBoost = value;
    }

    @Override
    public int getRange() {
       return this.range;
    }

    @Override
    public void setRange(int value) {
        this.range += value;
    }

    @Override
    public int getPace() {
        return this.pace;
    }

    @Override
    public void setPace(int value) {
        this.pace = value;
    }

    @Override
    public String getColor() {
        return this.color;
    }
    
    @Override
    public String toString()
    {
        return "\n" 
                + this.color + " színű a csiga " 
                + "\nKezdeti sebessége: " + this.pace 
                + "\nKapott sebességbónuszt?" + (this.hasSpeedBoost?"Igen" : "Nem") 
                + "\nMegtett táv: " + this.range;
    }
    
}
