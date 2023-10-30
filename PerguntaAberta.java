package quizpoo;
public class PerguntaAberta extends Pergunta {
    private String respostaCorreta;

    public PerguntaAberta(String enunciado, String respostaCorreta) {
        super(enunciado);
        this.respostaCorreta = respostaCorreta;
    }
    public boolean verificarResposta(String resposta) {
        return resposta.equalsIgnoreCase(respostaCorreta);
    }
}

