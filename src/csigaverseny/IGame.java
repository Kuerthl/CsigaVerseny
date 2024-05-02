/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package csigaverseny;

/**
 *
 * @author kthla
 */
public interface IGame {
    public void Bet(ISnail snail);
    public ISnail[] getSnails();
    public void GameOn();
    public void getWinnerSnail();
}
