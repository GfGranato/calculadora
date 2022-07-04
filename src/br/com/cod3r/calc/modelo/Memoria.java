package br.com.cod3r.calc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memoria {

    private enum TipoComando {
            ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
    }

    private static Memoria memoria = new Memoria();

    private final List<MemoriaObservador> observadores = new ArrayList<>();
    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";

    private Memoria() {

    }

    public static Memoria getInstance() {
        return memoria;
    }

    public void adicionarObserdaor(MemoriaObservador observador) {
        observadores.add(observador);
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void processarComando(String texto) {
        TipoComando tipoComando = detectarComando(texto);

        if(tipoComando == null) return;
        else if( tipoComando == TipoComando.ZERAR) {
            textoAtual ="";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        }else if( tipoComando == TipoComando.NUMERO || TipoComando.VIRGULA == tipoComando) {
            textoAtual = substituir ? texto : textoAtual +texto;
            substituir = false;
        } else {
            
        }

        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
    }

    private TipoComando detectarComando(String texto) {

        if(textoAtual.isEmpty() && texto.equals("0")){
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        }catch (NumberFormatException e){
            if ("AC".equals(texto)) {
                return TipoComando.ZERAR;
            } else if ("/".equals(texto)) {
                return TipoComando.DIV;
            } else if ("*".equals(texto)) {
                return TipoComando.MULT;
            } else if ("+".equals(texto)) {
                return TipoComando.SOMA;
            } else if ("-".equals(texto)) {
                return TipoComando.SUB;
            } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            } else if (",".equals(texto) && !textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            }
        }

        return null;
    }
}
