/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package csigaverseny;

/**
 *
 * @author kthla
 */
public interface ISnail 
{
    public String getColor();
    
    public boolean getHasSpeedBoost();
    public void setHasSpeedBoost(boolean value);
    
    public int getRange();
    public void setRange(int value);
    
    public int getPace();
    public void setPace(int value);
}
