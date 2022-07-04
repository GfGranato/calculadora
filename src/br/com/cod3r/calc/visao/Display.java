package br.com.cod3r.calc.visao;

import br.com.cod3r.calc.modelo.Memoria;
import br.com.cod3r.calc.modelo.MemoriaObservador;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {

    private final JLabel label;
    public Display() {
        Memoria.getInstance().adicionarObserdaor(this);

        setBackground(new Color(46, 49, 50));
        label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier",Font.PLAIN,30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
        add(label);
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
