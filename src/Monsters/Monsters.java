package Monsters;

import java.awt.*;

public abstract class Monsters {

    protected int figureSize = 50;
    protected int row;
    protected int col;
    protected Color color;
    protected int Attack;
    protected int Deffense;
    protected int Magic;
    protected int Speed;
    protected String id;

    public Monsters(int row, int col, Color color, int attack, int deffense, int magic, int speed, String id) {

        this.row      = row;
        this.col      = col;
        this.color    = color;
        this.Attack   = attack;
        this.Deffense = deffense;
        this.Magic    = magic;
        this.Speed    = speed;
        this.id       = id;
    }


    public Monsters(int row, int col, int attack, int deffense, int magic, int speed) {
        this(row, col, Color.BLACK, attack, deffense, magic, speed, "P");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getAttack() {
        return Attack;
    }

    public int getDeffense() {
        return Deffense;
    }

    public int getMagic() {
        return Magic;
    }

    public int getSpeed() {
        return Speed;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g) {

        int x = this.col * figureSize;
        int y = this.row * figureSize;

        g.setColor(this.color);
        g.fillRect(x, y, figureSize, figureSize);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }

    public abstract boolean isMoveValid(int moveRow, int moveCol);

    public abstract boolean isAttackValid(int attackRow, int attackCol);

}
