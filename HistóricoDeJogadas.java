package quizpoo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistóricoDeJogadas {
    private List<Jogada> jogadas;

    public HistóricoDeJogadas() {
        jogadas = new ArrayList<>();
    }

    public void adicionarJogada(String pergunta, int pontos) {
        Jogada jogada = new Jogada(pergunta, pontos);
        jogadas.add(jogada);
    }

    public void exibirHistórico() {
        // Ordena a lista de jogadas com base nos pontos (do maior para o menor)
        Collections.sort(jogadas, Collections.reverseOrder());

        System.out.println("Histórico de Jogadas (Ranking):");
        int posição = 1;
        for (Jogada jogada : jogadas) {
            System.out.println(posição + ". Pergunta: " + jogada.getPergunta() + " - Pontos: " + jogada.getPontos());
            posição++;
        }
    }

    private class Jogada implements Comparable<Jogada> {
        private String pergunta;
        private int pontos;

        public Jogada(String pergunta, int pontos) {
            this.pergunta = pergunta;
            this.pontos = pontos;
        }

        public String getPergunta() {
            return pergunta;
        }

        public int getPontos() {
            return pontos;
        }

        @Override
        public int compareTo(Jogada o) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        }
    }
}

