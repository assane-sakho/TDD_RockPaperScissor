package fr.p10.miage.rps.test;

import fr.p10.miage.rps.model.Player;
import  fr.p10.miage.rps.model.RPSEnum;
import fr.p10.miage.rps.model.Result;
import fr.p10.miage.rps.model.RockPaperScissors;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static fr.p10.miage.rps.model.RPSEnum.*;

public class RockPaperScissorsTest {
    private RockPaperScissors rps;
    private Player p1;
    private Player p2;

    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();
        p1 = new Player("player1");
        p2 = new Player("player2");
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
        p1 = null;
        p2 = null;
    }

    @Parameters ({ "paper", "rock" })
    @Test
    void testWinPlay ( String p1 , String p2)
    {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters ({ "paper", "paper" })
    @Test
    void testTiePlay(String p1, String p2)
    {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Test ( dataProvider = "winData")
    void testLostPlay(RPSEnum p1, RPSEnum p2)
    {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @DataProvider(name = "winData")
    Object[][] createWinData()
    {
        return new Object[][] {
            { SCISSORS, ROCK},
            { PAPER, SCISSORS},
            { ROCK, PAPER},
        };
    }

    @Test
    void testPlay()
    {
        assertEquals(rps.play(p1, p2), rps.play(p2, p1));
    }
}