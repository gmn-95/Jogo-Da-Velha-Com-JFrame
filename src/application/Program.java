/*
* Autor: Gustavo Macedo
* Última atualização: 30/09/2021
* */

package application;

import entities.Escolha;
import entities.UI;

public class Program {
    public static void main(String[] args) {

        Escolha escolha = new Escolha();
        escolha.selecionarXouO();
        new UI(escolha);

    }
}
