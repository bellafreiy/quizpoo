package quizpoo;
public class Pergunta {
    private String enunciado;

    public Pergunta(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean verificarResposta(String resposta) {
        return false;
    }

    public void setEnunciado(String novoEnunciado) {
    }
}
