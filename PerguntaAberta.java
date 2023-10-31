package quizpoo;
public class PerguntaAberta extends Pergunta {
    private String respostaCorretaA;

    public PerguntaAberta(String enunciado, String respostaCorretaA) {
        super(enunciado);
        this.respostaCorretaA = respostaCorretaA;
    }
    public boolean verificarResposta(String respostaCorretaA) {
        return respostaCorretaA.equalsIgnoreCase(respostaCorretaA);
    }
}

