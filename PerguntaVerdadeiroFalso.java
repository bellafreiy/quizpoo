package quizpoo;
public class PerguntaVerdadeiroFalso extends Pergunta {
    public PerguntaVerdadeiroFalso(String enunciado) {
        super(enunciado);
    }
    private boolean respostaCorreta;

    public void perguntaVerdadeiroFalso(String enunciado, boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    public boolean verificarResposta(String resposta) {
        boolean escolha = Boolean.parseBoolean(resposta);
        return escolha == respostaCorreta;
    }
}
