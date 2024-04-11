package org.wz.exercises.other;

import java.util.ArrayList;
import java.util.Random;

public class RVOS {

    public static void main(String[] args) {
        // 示例数据矩阵M
        double[][] M = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };

        // 生成的样本个数k
        int k = 2;

        double[][] oversampledData = randomValueBasedOversampling(M, k);

        // 打印生成的样本
        for (double[] row : oversampledData) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static double[][] randomValueBasedOversampling(double[][] M, int k) {
        int rows = M.length;
        int cols = M[0].length;

        // 新增样本集M'
        ArrayList<double[]> MPrime = new ArrayList<>();

        Random random = new Random();

        // 当k不等于0时
        while (k-- > 0) {
            double[] newSample = new double[cols];

            // 对于j=1,2,…n (n表示M有n列)
            for (int j = 0; j < cols; j++) {
                // 随机选择一个特征值v
                int randIndex = random.nextInt(rows);
                double v = M[randIndex][j];

                // 把v保存到当前新样本的相应位置
                newSample[j] = v;
            }

            // 把生成的新样本保存到新增样本集M'
            MPrime.add(newSample);
        }

        // 返回M'
        return MPrime.toArray(new double[MPrime.size()][]);
    }
}

