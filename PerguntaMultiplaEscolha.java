package quizpoo;
public class PerguntaMultiplaEscolha extends Pergunta {
    public PerguntaMultiplaEscolha(String enunciado) {
        super(enunciado);
    }
    private String[] opcoes;
    private int respostaCorreta;

    public void PerguntaFechada(String enunciado, String[] opcoes, int respostaCorreta) {

        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }
    public boolean verificarResposta(String resposta) {
        int escolha = Integer.parseInt(resposta);
        return escolha == respostaCorreta;
    }
}