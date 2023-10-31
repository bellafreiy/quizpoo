package quizpoo;
public class PerguntaMultiplaEscolha extends Pergunta {
    public PerguntaMultiplaEscolha(String enunciado, String[] alternativas, int respostaCorreta2) {
        super(enunciado);
    }
    private String[] opcoes;
    private boolean respostaCorreta2;

    public void PerguntaFechada(String enunciado, String[] opcoes, int respostaCorreta) {

        this.opcoes = opcoes;
        this.respostaCorreta2 = respostaCorreta2;
    }
    public boolean verificarResposta(String resposta) {
        return respostaCorreta2;
    }
}