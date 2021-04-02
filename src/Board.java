import Monsters.DrunkenKnight;
import Monsters.SofisticatedSam;
import Monsters.SandTurtle;
import Monsters.DogEatingBug;
import Monsters.RecklessCanibal;
import Monsters.MagicCat;
import Monsters.Monsters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements MouseListener {

    private int sideTileCount = 12;
    private Monsters[][]figures;
    private Monsters selected;

    public Board (){

        this.figures = new Monsters[sideTileCount][sideTileCount];

        figures[1][0] = (new DrunkenKnight(1, 0, Color.ORANGE, 5, 5, 5, 5));
        figures[2][0] = (new SofisticatedSam(2, 0, Color.ORANGE, 10, 5, 4, 1));
        figures[3][0] = (new SandTurtle(3, 0, Color.ORANGE, 5, 10, 1, 4));
        figures[4][0] = (new MagicCat(4, 0, Color.ORANGE, 8, 5, 10, 1));
        figures[5][0] = (new RecklessCanibal(5, 0, Color.ORANGE, 4, 6, 8, 10));
        figures[6][0] = (new DogEatingBug(6, 0, Color.ORANGE, 10, 2, 8, 5));

        this.setSize(850, 610);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int row = this.getBoardDimentionBasedOnCoordinates(mouseEvent.getY());
        int col = this.getBoardDimentionBasedOnCoordinates(mouseEvent.getX());

        // check if piece is already selected
        if(this.selected != null) {

            Monsters m = this.selected;

            if(m.isMoveValid(row, col)) {

                movePiece(row, col, m);
                this.selected = null;
                this.repaint();
                return;
            }
        }

        // check if piece is available
        if(this.hasBoardPiece(row, col)) {
            this.selected = this.getBoardPiece(row, col);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void renderGameTile(Graphics g, int row, int col) {

        Color tileColor = Color.BLACK;
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    private Monsters getBoardPiece(int row, int col) {
        return this.figures[row][col];
    }

    private boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    private void renderMonster(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {

            Monsters m = this.getBoardPiece(row, col);
            m.render(g);
        }
    }

    public void movePiece(int row, int col, Monsters m) {

        int initialRow = m.getRow();
        int initialCol = m.getCol();

        m.move(row, col);

        this.figures[m.getRow()][m.getCol()] = this.selected;
        this.figures[initialRow][initialCol] = null;

        this.selected = null;
    }

    public void hand(){

    }

    public void paint(Graphics g) {

        //super.paint(g);

        for (int row = 0; row < sideTileCount; row++) {
            for (int col = 0; col < sideTileCount; col++) {

                this.renderGameTile(g, row, col);
                this.renderMonster(g, row, col);
            }
        }
    }

    private int getBoardDimentionBasedOnCoordinates(int coordinates) {
        return coordinates / Tile.TILE_SIZE;
    }

}
