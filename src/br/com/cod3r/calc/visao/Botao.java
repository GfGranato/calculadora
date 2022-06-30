package br.com.cod3r.calc.visao;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Botao extends JButton {

    public Botao(String text, Color cor) {
        setText(text);
        setOpaque(true);
        setBackground(cor);
        setFont(new Font("courie",Font.PLAIN, 25));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        System.out.println("here");
    }
}
