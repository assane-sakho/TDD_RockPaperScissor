package fr.p10.miage.rps.model;

import static fr.p10.miage.rps.model.Result.*;

public class RockPaperScissors {

    public Result play(RPSEnum p1, RPSEnum p2)
    {
        Result r = switch (p1) {
            case PAPER -> switch (p2) {
                case ROCK -> WIN;
                case PAPER -> TIE;
                case SCISSORS -> LOST;
            };
            case ROCK -> switch (p2) {
                case ROCK -> TIE;
                case SCISSORS -> WIN;
                case PAPER -> LOST;
            };
            case SCISSORS -> switch (p2) {
                case PAPER -> WIN;
                case SCISSORS -> TIE;
                case ROCK -> LOST;
            };
        };
        return r;
    }

    public Result play(Player p1, Player p2) {
        Result r;

        p1.resetMoves();
        p2.resetMoves();

        RPSEnum p1Move;
        RPSEnum p2Move;

        int minPlayerMoves = Math.min(p1.getNbMoves(), p2.getNbMoves());

        for (int i = 0; i < minPlayerMoves; i++) {
            p1Move = p1.getNextMove();
            p2Move = p2.getNextMove();

            switch (play(p1Move, p2Move)) {
                case WIN:
                    p1.setScore(p1.getScore() + 1);
                    break;
                case LOST:
                    p2.setScore(p2.getScore() + 1);
                    break;
                case TIE:
                    p1.setScore(p1.getScore() + 1);
                    p2.setScore(p2.getScore() + 1);
                    break;
            }
        }

        int scoreP1 = p1.getScore();
        int scoreP2 = p2.getScore();

        String outputMessage;

        if (scoreP1 > scoreP2 ) {
            r = Result.WIN;
            outputMessage = p1.getName()  + " a gagné la partie avec un score de : " + scoreP1 + " points ("+  p2.getName() + " perd avec un score de " +  scoreP2 + " points)";
        }
        else if (scoreP1 == scoreP2 ){
            r = TIE;
            outputMessage =  p1.getName()  + " et " +  p2.getName() + " on fait égalité avec un score de : " + scoreP1;
        }else {
            r = Result.LOST;
            outputMessage = p1.getName()  + " a perdu la partie avec un score de : " + scoreP1  + " points ("+  p2.getName() + " gagne avec un score de " +  scoreP2 + " points)";
        }
        System.out.println("\n" + outputMessage);// Noncompliant
        return r;
    }
}
