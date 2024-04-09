package org.wz.exercises.header.first;

public class DestroyTheBattleshipStartGame {

    private int[] arr;

    private int count = 0;

    public DestroyTheBattleshipStartGame(int[] arr) {
        this.arr = arr;
    }

    public int[] saveBattleship(int[] battleship) {
        for (int index : battleship) {
            if (index < 0 || index >= arr.length) {
                throw new PositionOutOfBoundsException("战舰位置越界");
            }
            if (arr[index] == 1) {
                throw new PositionsDoOverlapException("战舰位置重叠");
            }
            arr[index] = 1;
        }
        return arr;

    }

    public String guess(int location) {
        count ++;
        if (arr[location] == 1) {
            arr[location] = 2;
            if (isDestroy()) {
                return "destroy";
            }
            return "hit";
        } else if (arr[location] == 0) {
            arr[location] = 2;
            return "miss";
        } else if (arr[location] == 2) {
            throw new LocationAlreadyHitException("位置已经被击中过了，请换一个位置吧");
        }
        return null;
    }

    private boolean isDestroy() {
        for (int i : arr) {
            if (i == 1) {
                return false;
            }
        }
        return true;
    }

    public int getCount() {
        return count;
    }
}
