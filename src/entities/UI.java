/*
* parei -> na parte quando coloco para jogar um novo jogo, está dando bug
* */


package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

    private JButton[] bt = new JButton[9];
    private JButton zerar = new JButton("<html><align=center>ZERAR JOGO </html>");

    private boolean xo = false;
    private boolean[] click = new boolean[9];
    private int rodarSoUmaVez = 0;
    private int rodadaPlayer1;
    private int rodadaPlayer2;
    private Escolha escolha;


    private JLabel vez = new JLabel();
    private JLabel p1 = new JLabel("Player1 -  0  ");
    private JLabel p2 = new JLabel("  X  0  - Player2");

    private Resultado resultado = new Resultado();

    public UI(Escolha escolha){
        this.escolha = escolha;
        vez.setText("Player 1 começa");
        criaJanela();

    }

    private void criaJanela(){

        setVisible(true);                                  //deixa janela visivel
        this.getContentPane().setBackground(Color.orange); // muda a cor de fundo da janela
        setTitle("JOGO DA VELHA");                         //adiciona titulo à janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);           // fechar a janela, quando apertar no X
        setLayout(null);                                   // definir layout da janela
        setBounds(400, 100, 480, 500);    // tamanho e posição da janela 700 x 500

        adicionaVezDoJogadorNaTela();
        adicionaPlacarNaTela();
        resetJogo();
        criaBotoes();

    }

    private void resetJogo(){
        zerar.addActionListener(new ActionListener() { //adicionar ação ao botão
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setP1Venceu(0);
                resultado.setP2Venceu(0);
                atualizaPlacar();
                limpar();
            }
        });

        add(zerar);
        zerar.setBounds(380, 230, 80, 40);
        zerar.setFont(new Font("Arial", Font.BOLD, 12));

    }

    private void adicionaVezDoJogadorNaTela(){
        add(vez);
        vez.setBounds(110, 130, 300, 600);  // tamanho e posição da informaçao
        vez.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void adicionaPlacarNaTela(){
        add(p1);
        add(p2);

        p1.setFont(new Font("Arial", Font.BOLD, 20));
        p1.setBounds(50, -50, 300, 200);
        p2.setFont(new Font("Arial", Font.BOLD, 20));
        p2.setBounds(180, -50, 300, 200);
    }

    private void criaBotoes(){
        int cont = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 100, 95, 95);
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
                cont++;
            }
        }
        adicionaXouOnoBotao();
    }

    private void atualizaPlacar(){
        p1.setText("Player1 -  " + resultado.getP1Venceu());
        p2.setText("  X  " + resultado.getP2Venceu() +"  - Player2");
    }

    private void adicionaXouOnoBotao(){

        for(int i = 0; i < 9; i++){
            click[i] = false;
        }

        for(int i = 0; i < 9; i++){
            int finalI = i;
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!click[finalI]){
                        click[finalI] = true;
                        mudar(bt[finalI]);
                    }
                }
            });
        }
    }

    private void definirFiguraDosJogadores(){
        if(rodarSoUmaVez == 0){
            if(!escolha.getPlayer1().equals("O")){
                xo = true;
                rodarSoUmaVez++;
                rodadaPlayer1 = 1;
                rodadaPlayer2 = 0;

            }
            else {
                xo = false;
                rodarSoUmaVez++;
                rodadaPlayer1 = 0;
                rodadaPlayer2 = 1;
            }
        }
    }


    private void mudar(JButton btn){

        definirFiguraDosJogadores();

        if(xo){
            if(rodadaPlayer1 == 1){
                vez.setText("Vez do Player 2");
            }
            else if(rodadaPlayer2 == 1){
                vez.setText("Vez do Player 1");
            }

            btn.setText("X");
            xo = false;
        }
        else {
            if(rodadaPlayer1 == 0){
                vez.setText("Vez do Player 2");
            }
            else if(rodadaPlayer2 == 0){
                vez.setText("Vez do Player 1");
            }

            btn.setText("O");
            xo = true;
        }

        int cont = 0;
        for(int i = 0; i < 9; i++){
            if(click[i]){
                cont++;
            }
        }

        if(resultado.resultado(bt, cont, escolha)){
            limpar();
            atualizaPlacar();
        }
    }

    // Limpa a tela
    public void limpar(){

        // quem ganhar, começa a proxima rodada
        if(resultado.getResult() == 1){
            if(!xo && rodadaPlayer1 == 1){
                xo = true;
                vez.setText("Player 1 começa");
            }
            else if(!xo && rodadaPlayer2 == 0){
                xo = true;
                vez.setText("Player 2 começa");
            }
            else if(!xo && rodadaPlayer1 == 0){
                xo = true;
                vez.setText("Player 2 começa");
            }
            else if(!xo && rodadaPlayer2 == 1){
                xo = true;
                vez.setText("Player 1 começa");
            }

        }
        else if(resultado.getResult() == 2){
            if(xo && rodadaPlayer1 == 0 ){
                xo = false;
                vez.setText("Jogador 1 joga");
            }
            else if(xo && rodadaPlayer2 == 1){
                xo = false;
                vez.setText("Jogador 2 joga");
            }
            else if(xo && rodadaPlayer1 == 1){
                xo = false;
                vez.setText("Jogador 2 joga");
            }
            else if(xo && rodadaPlayer2 == 0){
                xo = false;
                vez.setText("Jogador 1 joga");
            }
        }

        for(int i = 0; i < 9; i++){
            bt[i].setText(" ");
            click[i] = false;

        }
    }

    public JButton[] getBt() {
        return bt;
    }

    public boolean isXo() {
        return xo;
    }

    public boolean[] getClick() {
        return click;
    }

}
