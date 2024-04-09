package header.first;

import org.junit.jupiter.api.Test;
import org.wz.exercises.header.first.DestroyTheBattleshipStartGame;
import org.wz.exercises.header.first.LocationAlreadyHitException;
import org.wz.exercises.header.first.PositionOutOfBoundsException;
import org.wz.exercises.header.first.PositionsDoOverlapException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 击毁战舰测试类
 *
 * @author wangzhi
 */
class DestroyTheBattleshipTest {

    // 主要测试的是击毁战舰，需求是什么呢？
    // 本需求来自 header first Java 实战一书：需求就是使用命令行，有一个数组，战舰放在数组中，玩家每次输入一个索引，如果集中返回 hit，
    // 战舰拥有长度，如果全部击中，返回 destroy，如果没有击中，返回 miss，最后返回总共猜测的次数
    // 如何使用面向对象，而不是面向过程的思维方式来思考呢？一边练习面向对象一边练习 TDD
    // 先拆分需求吧
    // 1. 首先需要一个游戏开始类，从而开始游戏
    // 2. 游戏类中要可以保存战舰，保存玩家的猜测次数，根据猜测次数订一个等级，当全部击毁的时候，返回等级
    // 3. 玩家输入猜测次数，从而返回 hit、destroy、miss 以及全部击毁的等级
    // 4. 异常情况，不能输入负数，不能输入超过数组长度的数，多次输入同一个数，不能重复击中

    // 保存
    @Test
    void testDestroyTheBattleshipSaveBattleshipTure() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        // 战舰就是数组，可以保存战舰
        int[] arr = destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        assertEquals(1, arr[3]);
    }

    // 保存多个
    @Test
    void save_many_battleship_and_positions_do_not_overlap() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        // 战舰就是数组，可以保存战舰
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        destroyTheBattleshipStartGame.saveBattleship(new int[] {10, 11, 12});
        destroyTheBattleshipStartGame.saveBattleship(new int[] {15, 16, 17, 18});
        int[] arr = destroyTheBattleshipStartGame.saveBattleship(new int[] {51, 52, 53});
        assertEquals(1, arr[53]);
    }

    // 保存多个位置重叠
    @Test
    void save_many_battleship_and_positions_do_overlap() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        // 战舰就是数组，可以保存战舰
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        assertThrowsExactly(PositionsDoOverlapException.class,
            () -> destroyTheBattleshipStartGame.saveBattleship(new int[] {5, 6, 7}));
    }

    // 保存战舰越过地图范围
    @Test
    void save_battleship_and_positions_out_of_index() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        assertThrowsExactly(PositionOutOfBoundsException.class,
            () -> destroyTheBattleshipStartGame.saveBattleship(new int[] {100, 101, 102}));
    }

    // 猜测方法
    @Test
    void guess_hit() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        String str = destroyTheBattleshipStartGame.guess(5);
        assertEquals("hit", str);
    }

    @Test
    void guess_miss() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        String str = destroyTheBattleshipStartGame.guess(1);
        assertEquals("miss", str);
    }

    @Test
    void guess_destroy() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        destroyTheBattleshipStartGame.guess(3);
        destroyTheBattleshipStartGame.guess(4);
        String str = destroyTheBattleshipStartGame.guess(5);
        assertEquals("destroy", str);
    }

    @Test
    void guess_location_do_overlap() {
        DestroyTheBattleshipStartGame destroyTheBattleshipStartGame = new DestroyTheBattleshipStartGame(new int[100]);
        destroyTheBattleshipStartGame.saveBattleship(new int[] {3, 4, 5});
        destroyTheBattleshipStartGame.guess(3);
        assertThrowsExactly(LocationAlreadyHitException.class, () -> destroyTheBattleshipStartGame.guess(3));
    }

}
