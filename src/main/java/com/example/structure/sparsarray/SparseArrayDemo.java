package com.example.structure.sparsarray;

import java.io.*;

/**
 * @author Bruce Lee
 * @date 2021/6/3
 * @description 描述稀疏数组的构成和解析
 **/
public class SparseArrayDemo {

    public static void main(String[] args) {
        //声明一个原始的二位数组
        int[][] originArray = new int[8][9];
        //某些特殊的位置 赋予一些特殊的值
        originArray[3][4] = 100;
        originArray[6][2] = 99;
        //打*/*印一下数组
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[i].length; j++) {
                System.out.printf("%d\t", originArray[i][j]);
            }
            System.out.println();
        }

        /**
         * 将数组转换成稀疏数组
         */
        int[][] spars = change2Spars(originArray);
        System.out.println("构造完毕之后的数组");
        for (int i = 0; i < spars.length; i++) {
            for (int j = 0; j < spars[i].length; j++) {
                System.out.printf("%d\t", spars[i][j]);
            }
            System.out.println();
        }
        System.out.println("输出数组到文件开始");
        String path = "D:\\test.txt";
//        writeFile(spars, path);
        System.out.println("输出数组到文件结束");

        readFile(path);

        int[][] newArray = change2Origin(spars);
        System.out.println("new array");
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                System.out.printf("%d\t", newArray[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 读取文件到内存
     *
     * @param path
     */
    private static void readFile(String path) {
        InputStream ins = null;
        ObjectInputStream ois = null;
        try {
            ins = new FileInputStream(path);
            ois = new ObjectInputStream(ins);
            int[][] o = (int[][]) ois.readObject();
            System.out.println("读取到的文件");
            for (int i = 0; i < o.length; i++) {
                for (int j = 0; j < o[i].length; j++) {
                    System.out.printf("%d\t", o[i][j]);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //流关闭操作
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将稀疏数组写入到指定的文件中
     *
     * @param spars 稀疏数组
     * @param path  指定文件的路径
     */
    private static void writeFile(int[][] spars, String path) {
        OutputStream ous = null;
        ObjectOutputStream oos = null;
        try {
            ous = new FileOutputStream(path);
            oos = new ObjectOutputStream(ous);
            oos.writeObject(spars);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将普通数组转换成稀疏数组
     *
     * @param arr
     * @return
     */
    private static int[][] change2Spars(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
            System.out.println();
        }
        int[][] result = new int[count + 1][3];
        result[0][0] = arr.length;
        result[0][1] = arr[0].length;
        result[0][2] = count;
        int row = 1;
        //处理其余的行
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    result[row][0] = i;
                    result[row][1] = j;
                    result[row][2] = arr[i][j];
                    row++;
                }
            }
            System.out.println();
        }
        return result;
    }

    /**
     * 将稀疏数组转换成普通数组
     *
     * @param sparse
     * @return
     */
    private static int[][] change2Origin(int[][] sparse) {
        //创建数组的行和列
        int[][] newArray = new int[sparse[0][0]][sparse[0][1]];
        // i从1开始，sparse[0][2]表示有多少个数据，
        for (int i = 1; i <= sparse[0][2]; i++) {
            newArray[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        return newArray;
    }
}
