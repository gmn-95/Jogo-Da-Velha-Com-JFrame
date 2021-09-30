package entities;

import javax.swing.*;

public class Escolha {

    private String player1;
    private String player2;

    public Escolha(){
    }

    public void selecionarXouO() {
        boolean error = true;

        while (error){
            String[] possibleValues = {"X", "O"};
            this.player1 = (String) JOptionPane.showInputDialog(null,
                    "Escolha X ou O", "PLAYER 1, ESCOLHA",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    possibleValues, possibleValues[0]);
            if(player1 == null){
                error = true;
            }
            else{
                if(player1 == "X"){
                    this.player1 = "X";
                    this.player2 = "O";
                }
                else {
                    this.player1 = "O";
                    this.player2 = "X";
                }
                error = false;
            }
        }
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

}
