package br.com.cod3r.calc.visao;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Teclado extends JPanel {

    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99,99,99);
    private final Color COR_LARANJA = new Color(242, 163, 60);

    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints =  new GridBagConstraints();

        setLayout(layout);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridwidth = 3;
        adicionarBotao("AC", COR_CINZA_ESCURO, constraints ,0, 0);
        constraints.gridwidth = 1;
        adicionarBotao("+/-", COR_CINZA_ESCURO, constraints ,1, 0);
        adicionarBotao("%", COR_CINZA_ESCURO, constraints ,2, 0);
        adicionarBotao("/", COR_LARANJA, constraints ,3, 0);

        adicionarBotao("7", COR_CINZA_CLARO, constraints ,0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, constraints ,1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, constraints ,2, 1);
        adicionarBotao("*", COR_LARANJA, constraints ,3, 1);

        adicionarBotao("4", COR_CINZA_CLARO, constraints ,0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, constraints ,1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, constraints ,2, 2);
        adicionarBotao("-", COR_LARANJA, constraints ,3, 2);

        adicionarBotao("1", COR_CINZA_CLARO, constraints ,0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, constraints ,1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, constraints ,2, 3);
        adicionarBotao("+", COR_LARANJA, constraints ,3, 3);

        constraints.gridwidth = 2;
        adicionarBotao("0", COR_CINZA_CLARO, constraints ,0, 4);
        constraints.gridwidth = 1;
        adicionarBotao(",", COR_CINZA_CLARO, constraints ,2, 4);
        adicionarBotao("=", COR_LARANJA, constraints ,3, 4);

    }

    private void adicionarBotao(String text, Color cor, GridBagConstraints constraint, int x, int y) {

        constraint.gridx = x;
        constraint.gridy = y;
        Botao botao = new Botao(text, cor);
        add(botao, constraint);
        System.out.println("here2");
    }
}
