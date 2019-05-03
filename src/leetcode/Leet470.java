package leetcode;

import java.util.Random;

public class Leet470 {
    public int rand10() {
        int res;
        do {
            res = (7 * (rand7() - 1) + rand7());
        } while (res > 40);
        return res % 10 + 1;
    }


    public int rand7() {
      return new Random().nextInt(7);
    }

    //rand10生成rand5
    //可能会有人想: 为什么不直接rand10/2就完事了?
    //rand10:   {1,2,3,4,5,6,7,8,9,10}
    //rand10/2: {0,1,1,2,2,3,3,4,4,5}
    //rand5:    {1,2,3,4,5}
    //rand10/2生成的范围是[0~5]且非均匀分布
    public int rand5(){
        int res;
        do{
            res = rand10();
        }while (res>5);
        return res;
    }





}
