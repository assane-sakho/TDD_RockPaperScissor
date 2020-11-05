package fr.p10.miage.rps.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Player {

    private final String name;
    private int score;
    private final List<RPSEnum> moves;
    int moveIndex;

    public Player(String name, List<RPSEnum> moves) {
        this.moves = moves;
        this.name = name;
        this.score = 0;
        this.moveIndex = 0;
    }

    public Player(String name) {
        this.name = name;
        this.moves = new ArrayList<>();
        this.score = 0;
        this.moveIndex = 0;


        Random rdm = new Random();
        int randomValue;

        for (int i = 0; i < 20; i++) {
            randomValue = rdm.nextInt(10) % 3;
            switch (randomValue) {
                case 0 -> moves.add(RPSEnum.PAPER);
                case 1 -> moves.add(RPSEnum.SCISSORS);
                default -> moves.add(RPSEnum.ROCK);
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public int getNbMoves() {
        return moves.size();
    }

    public RPSEnum getNextMove() {
        RPSEnum nextMove = moves.get(moveIndex);
        moveIndex++;
        return nextMove;
    }

    public void resetMoves() {
        this.moveIndex = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
