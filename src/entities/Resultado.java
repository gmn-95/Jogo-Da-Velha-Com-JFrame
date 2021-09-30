package entities;

import javax.swing.*;

public class Resultado {

    private int result;
    private int p1Venceu;
    private int p2Venceu;

    public Resultado() {
    }

    public boolean resultado( JButton[] bt, int cont, Escolha escolha){

        ImageIcon icon = new ImageIcon("/home/gustavo/Repositorios/jogoDaVelha-Com-Jframe/src/img/imgJogo1.png");


        if(bt[0].getText().equals("X") && bt[3].getText().equals("X") && bt[6].getText().equals("X")
                || bt[1].getText().equals("X") && bt[4].getText().equals("X") && bt[7].getText().equals("X")
                || bt[2].getText().equals("X") && bt[5].getText().equals("X") && bt[8].getText().equals("X")
                || bt[0].getText().equals("X") && bt[1].getText().equals("X") && bt[2].getText().equals("X")
                || bt[3].getText().equals("X") && bt[4].getText().equals("X") && bt[5].getText().equals("X")
                || bt[6].getText().equals("X") && bt[7].getText().equals("X") && bt[8].getText().equals("X")
                || bt[0].getText().equals("X") && bt[4].getText().equals("X") && bt[8].getText().equals("X")
                || bt[6].getText().equals("X") && bt[4].getText().equals("X") && bt[2].getText().equals("X")) {

            if(escolha.getPlayer1() == "X"){
                JOptionPane.showMessageDialog(null, "    PLAYER 1, VENCEU!", "RESULTADO", JOptionPane.INFORMATION_MESSAGE, icon);
                p1Venceu++;

            }
            else {
                JOptionPane.showMessageDialog(null, "    PLAYER 2, VENCEU!", "RESULTADO", JOptionPane.INFORMATION_MESSAGE, icon);
                p2Venceu++;
            }

            result = 1;
            return true;

        }
        else if(bt[0].getText().equals("O") && bt[3].getText().equals("O") && bt[6].getText().equals("O")
                || bt[1].getText().equals("O") && bt[4].getText().equals("O") && bt[7].getText().equals("O")
                || bt[2].getText().equals("O") && bt[5].getText().equals("O") && bt[8].getText().equals("O")
                || bt[0].getText().equals("O") && bt[1].getText().equals("O") && bt[2].getText().equals("O")
                || bt[3].getText().equals("O") && bt[4].getText().equals("O") && bt[5].getText().equals("O")
                || bt[6].getText().equals("O") && bt[7].getText().equals("O") && bt[8].getText().equals("O")
                || bt[0].getText().equals("O") && bt[4].getText().equals("O") && bt[8].getText().equals("O")
                || bt[0].getText().equals("O") && bt[4].getText().equals("O") && bt[8].getText().equals("O")
                || bt[6].getText().equals("O") && bt[4].getText().equals("O") && bt[2].getText().equals("O")) {

            if(escolha.getPlayer1() == "O"){
                JOptionPane.showMessageDialog(null, "    PLAYER 1, VENCEU!", "RESULTADO", JOptionPane.INFORMATION_MESSAGE, icon);
                p1Venceu++;
            }
            else {
                JOptionPane.showMessageDialog(null, "    PLAYER 2, VENCEU!", "RESULTADO", JOptionPane.INFORMATION_MESSAGE, icon);
                p2Venceu++;
            }

            result = 2;
            return true;

        }
        else if(cont == 9){
            JOptionPane.showMessageDialog(null, "           EMPATE!", "RESULTADO", JOptionPane.INFORMATION_MESSAGE, icon);
            result = 3;
            return true;
        }

        return false;
    }

    public int getResult() {
        return result;
    }

    public int getP1Venceu() {
        return p1Venceu;
    }

    public void setP1Venceu(int p1Venceu) {
        this.p1Venceu = p1Venceu;
    }

    public int getP2Venceu() {
        return p2Venceu;
    }

    public void setP2Venceu(int p2Venceu) {
        this.p2Venceu = p2Venceu;
    }
}
