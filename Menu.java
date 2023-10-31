package quizpoo;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    public void exibirMenu() {
        System.out.println("        MENU ");
        System.out.println("| 1- JOGAR            |");
        System.out.println("| 2- CRIAR PERGUNTA   |");
        System.out.println("| 3- EDITAR PERGUNTA  |");
        System.out.println("| 4- EXCLUIR PERGUNTA |");
        System.out.println("| 5- HISTÓRICO        |");
        System.out.println("| 6- SAIR             |");
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Pergunta> perguntas = new ArrayList<>();
        HistóricoDeJogadas histórico = new HistóricoDeJogadas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogar(perguntas, histórico);
                    break;
                case 2:
                    criarPergunta(perguntas, scanner, null);
                    break;
                case 3:
                    editarPergunta(perguntas, scanner);
                    break;
                case 4:
                    excluirPergunta(perguntas, scanner);
                    break;
                case 5:
                    histórico.exibirHistórico();
                    break;
                case 6:
                    System.out.println("Saindo do jogo.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private static void jogar(List<Pergunta> perguntas, HistóricoDeJogadas histórico) {
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponíveis para jogar.");
            return;
        }

        int pontos = 0;
        Random random = new Random();

        for (Pergunta pergunta : perguntas) {
            System.out.println("Pergunta: " + pergunta.getEnunciado());
            Temporizador temporizador = new Temporizador(10); // 10 segundos
            temporizador.iniciarTemporizador();
            
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();

            if (!temporizador.tempoEsgotado() && pergunta.verificarResposta(resposta)) {
                pontos++;
                System.out.println("Resposta correta!");
            } else {
                System.out.println("Resposta incorreta ou tempo esgotado.");
            }
        }

        histórico.adicionarJogada("Jogada realizada", pontos);
        System.out.println("Você fez " + pontos + " pontos nesta jogada.");
    }

    private static void criarPergunta(List<Pergunta> perguntas, Scanner scanner, String enunciadoVerdadeiroFalso) {
        System.out.println("ESCOLHA O TIPO DE QUESTÃO QUE DESEJA CRIAR:");
        System.out.println("| 1- PERGUNTA ABERTA           |");
        System.out.println("| 2- PERGUNTA FECHADA          |");
        System.out.println("| 3- PERGUNTA TRUE OR FALSE    |");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        switch (tipo) {
            case 1:
                System.out.println("Digite o enunciado da pergunta:");
                String enunciado = scanner.nextLine();
                
                PerguntaAberta perguntaAberta = new PerguntaAberta(enunciado, enunciado);
                perguntas.add(perguntaAberta);
                
                System.out.println("Escolha a resposta correta:");
                String respostaCorretaA = scanner.nextLine();
                System.out.println("Resposta Adicionada!");

                break;
            case 2:
                System.out.println("Digite o enunciado da pergunta de múltipla escolha:");
                String enunciadoMultiplaEscolha = scanner.nextLine();
            
                System.out.println("Digite o número de alternativas (de 2 a 5):");
                int numAlternativas = scanner.nextInt();
                scanner.nextLine(); // Limpar a quebra de linha
            
                if (numAlternativas < 2 || numAlternativas > 5) {
                    System.out.println("Número de alternativas inválido. Deve ser de 2 a 5.");
                } else {
                    String[] alternativas = new String[numAlternativas];
                    int respostaCorreta = 0; // Índice da resposta correta (0 para A, 1 para B, etc.)
        
                    for (int i = 0; i < numAlternativas; i++) {
                        char letra = (char) ('A' + i);
                        System.out.print(letra + ") ");
                        alternativas[i] = scanner.nextLine();
                    }
        
                    System.out.println("Digite a letra da alternativa correta (A, B, C, D ou E):");
                    char letraRespostaCorreta = scanner.nextLine().charAt(0);
                
                    respostaCorreta = letraRespostaCorreta - 'A';
        
                    PerguntaMultiplaEscolha perguntaMultiplaEscolha = new PerguntaMultiplaEscolha(enunciadoMultiplaEscolha, alternativas, respostaCorreta);
                    perguntas.add(perguntaMultiplaEscolha);
                    System.out.println("Pergunta de múltipla escolha criada com sucesso.");
                }
                break;
            case 3:
                System.out.println("Digite o enunciado da pergunta verdadeiro ou falso:");
                String enunciadoVerdadeiroOuFalso = scanner.nextLine();
        
                System.out.println("Escolha a resposta correta (True ou False):");
                String respostaCorretaStr = scanner.nextLine();
        
                boolean respostaCorreta;
                if (respostaCorretaStr.equalsIgnoreCase("True")) {
                    respostaCorreta = true;
                } else if (respostaCorretaStr.equalsIgnoreCase("False")) {
                    respostaCorreta = false;
                } else {
                    System.out.println("Resposta incorreta. Deve ser 'True' ou 'False'.");
                    break;
            }
        
                PerguntaVerdadeiroFalso perguntaVerdadeiroOuFalso = new PerguntaVerdadeiroFalso(enunciadoVerdadeiroFalso, respostaCorreta);
                Pergunta perguntaVerdadeiroFalso;
                System.out.println("Pergunta verdadeiro ou falso criada com sucesso.");
                break;
        
            default:
                System.out.println("Tipo de pergunta inválido.");
        }
    }

    private static void editarPergunta(List<Pergunta> perguntas, Scanner scanner) {
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponíveis para editar.");
            return;
        }

        System.out.println("Escolha a pergunta que deseja editar:");

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println((i + 1) + "- " + perguntas.get(i).getEnunciado());
        }

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        if (escolha > 0 && escolha <= perguntas.size()) {
            System.out.println("Digite o novo enunciado da pergunta:");
            String novoEnunciado = scanner.nextLine();
            perguntas.get(escolha - 1).setEnunciado(novoEnunciado);
            System.out.println("Pergunta editada com sucesso.");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void excluirPergunta(List<Pergunta> perguntas, Scanner scanner) {
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponíveis para excluir.");
            return;
        }

        System.out.println("Escolha a pergunta que deseja excluir:");

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println((i + 1) + "- " + perguntas.get(i).getEnunciado());
        }

        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= perguntas.size()) {
            perguntas.remove(escolha - 1);
            System.out.println("Pergunta excluída com sucesso.");
        } else {
            System.out.println("Escolha inválida.");
        }
    }
}
