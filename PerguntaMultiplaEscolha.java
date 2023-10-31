package quizpoo;

public class PerguntaMultiplaEscolha extends Pergunta {
    private String[] opcoes;
    private int respostaCorreta; // Alterado para um índice de alternativa correta

    public PerguntaMultiplaEscolha(String enunciado, String[] opcoes, int respostaCorreta) {
        super(enunciado);
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }
    public boolean verificarResposta(String resposta) {
        int escolha = resposta.charAt(0) - 'A';

        // Compara a escolha com a resposta correta
        return escolha == respostaCorreta;
    }
}
