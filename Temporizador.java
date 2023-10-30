package quizpoo;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {
    private int tempoLimite;
    private boolean tempoEsgotado;

    public Temporizador(int tempoLimite) {
        this.tempoLimite = tempoLimite;
        tempoEsgotado = false;
    }

    public void iniciarTemporizador() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tempoEsgotado = true;
                System.out.println("Tempo esgotado! Sua resposta não foi registrada.");
                timer.cancel();
            }
        }, tempoLimite * 1000); // Converte segundos para milissegundos
    }

    public boolean tempoEsgotado() {
        return tempoEsgotado;
    }
}
