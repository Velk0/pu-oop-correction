package Monsters;

import java.awt.*;

public class SofisticatedSam extends Monsters{

    public SofisticatedSam(int row, int col, Color color, int attack, int deffence, int magic, int speed) {
        super(row, col, color, attack, deffence, magic, speed, "SS");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoefficient = moveRow - this.row;
        int colCoefficient = moveCol - this.col;

        boolean isDynamicByRow          = rowCoefficient == 1;
        boolean isDynamicByCol          = colCoefficient == 1;

        return  isDynamicByRow ||
                isDynamicByCol;
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return this.isMoveValid(attackRow, attackCol);
    }

}
