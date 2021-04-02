import Monsters.DrunkenKnight;
import Monsters.SofisticatedSam;
import Monsters.SandTurtle;
import Monsters.DogEatingBug;
import Monsters.RecklessCanibal;
import Monsters.MagicCat;
import Monsters.Monsters;

import java.awt.*;
import java.util.Random;

public class Deck {
    int DrunkenKnightCounter = 3;
    int SofisticatedSam = 3;
    int SandTurtle = 3;
    int MagicCat = 3;
    int RecklessCanibal = 3;
    int DogEatingBug = 3;
    int DeckSize = 18;
    Random rand = new Random();
    Monsters[] Deck = new Monsters[DeckSize];

    public Deck() {
        this.Deck[0] = (new DrunkenKnight(0, 0, Color.ORANGE, 5, 5, 5, 5));
        this.Deck[1] = (new DrunkenKnight(0, 0, Color.ORANGE, 5, 5, 5, 5));
        this.Deck[2] = (new DrunkenKnight(0, 0, Color.ORANGE, 5, 5, 5, 5));
        this.Deck[3] = (new SofisticatedSam(0, 0, Color.ORANGE, 10, 5, 4, 1));
        this.Deck[4] = (new SofisticatedSam(0, 0, Color.ORANGE, 10, 5, 4, 1));
        this.Deck[5] = (new SofisticatedSam(0, 0, Color.ORANGE, 10, 5, 4, 1));
        this.Deck[6] = (new SandTurtle(0, 0, Color.ORANGE, 5, 10, 1, 4));
        this.Deck[7] = (new SandTurtle(0, 0, Color.ORANGE, 5, 10, 1, 4));
        this.Deck[8] = (new SandTurtle(0, 0, Color.ORANGE, 5, 10, 1, 4));
        this.Deck[9] = (new MagicCat(0, 0, Color.ORANGE, 8, 5, 10, 1));
        this.Deck[10] = (new MagicCat(0, 0, Color.ORANGE, 8, 5, 10, 1));
        this.Deck[11] = (new MagicCat(0, 0, Color.ORANGE, 8, 5, 10, 1));
        this.Deck[12] = (new RecklessCanibal(0, 0, Color.ORANGE, 4, 6, 8, 10));
        this.Deck[13] = (new RecklessCanibal(0, 0, Color.ORANGE, 4, 6, 8, 10));
        this.Deck[14] = (new RecklessCanibal(0, 0, Color.ORANGE, 4, 6, 8, 10));
        this.Deck[15] = (new DogEatingBug(0, 0, Color.ORANGE, 10, 2, 8, 5));
        this.Deck[16] = (new DogEatingBug(0, 0, Color.ORANGE, 10, 2, 8, 5));
        this.Deck[17] = (new DogEatingBug(0, 0, Color.ORANGE, 10, 2, 8, 5));
    }

    public Monsters draw() {
        int draw = rand.nextInt(DeckSize);

        for (int i = 0; i < Deck.length; i++) {
            if (draw == i)
                return Deck[draw];
        }
        return null;
    }
    public void render (Graphics g){
        g.drawRect(300, 650, 50, 50);
    }
}
