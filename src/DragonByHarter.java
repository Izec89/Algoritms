
import java.util.Arrays;

/*


Author: Alexander Kolesnik
https://ru.wikipedia.org/wiki/Кривая_дракона

   n = 1(1, 1)                n = 2(2, 1)                     n = 3(2, 3)         ->  n = 4(3, 5)
  * * * * * *                * * * * * *                     * * * * * *              n = 5(7, 6)
  *                          *         *                     *         *              n = 6(?, ?)
  *                          *         *                     *         *               ........
  *                          *         *                     *         *              n = 100(?, ?)
  *                          *         * * * * * *           *         * * * * * *
                                                                                 *
                                                                                 *
                                                                                 *
                                                                       * * * * * *
                                                                       *
                                                                       *
                                                                       *
                                                                       * * * * * *



 https://ru.wikipedia.org/wiki/Числа_Якобсталя
 0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10 923, 21 845, 43 691, 87 381, 174 763, 349 525, …

   1.                      numberByYakobstalTouch
     n)  (x, y)
     1)  (1, 1)             1
     2)  (2, 1)                1
     3)  (2, 3)                3    (1 * 2 + 1)
     4)  (3, 5)             3
     5)  (7, 6)             7       (3 * 2 + 1)
     6)  (11, 7)               7
     7)  (12, 15)              15   (7 * 2 + 1)
     8)  (15, 23)           15
     9)  (31, 26)           31         .....
     10) (47, 31)              31
     11) (52, 63)              63
     12) (63, 95)           63
     13) (127, 106)         127
     14) (191, 127)            127
     15) (212, 255)            255
     16) (255, 383)         255

   2.                  0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, ...
     n)  (x, y)          x  y                     numberByYakobstalWidth(x > y)       numberByYakobstalHeight(x < y)
     1)  (1, 1)             1                               1
     2)  (2, 1)          2                        for x: 2        (1 + 1)-> 1*4+1
     3)  (2, 3)          2         (2 + 0)                                                  2
     4)  (3, 5)             5                                                        for y:    5  (2 + 3)->  3*4-1
     5)  (7, 6)             6      (5 + 1)                  6
     6)  (11, 7)         11                              11       (6 + 5)-> 5*4+1
     7)  (12, 15)        12        (11 + 1)                                                 12
     8)  (15, 23)           23                                                                 23 (12 + 11)->11*4-1
     9)  (31, 26)           26     (23 + 3)                 26
     10) (47, 31)        47                              47       (26 + 21)->21*4+1
     11) (52, 63)        52        (47 + 5)                                                 52
     12) (63, 95)           95                                                                 95 (52 + 43)->43*4-1
     13) (127, 106)         106    (95 + 11)                106
     14) (191, 127)      191                             191      (106 + 85)
     15) (212, 255)      212       (191 + 21)                                               212
     16) (255, 383)         383                                                                383(212 + 171) ...

 */

class DragonByHanter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSizeOfDragonByHanter(100)));
    }

    public static long[] countSizeOfDragonByHanter(int n) {

        long[] sizeOfFigure = new long[]{1, 1};

        if (n == 1) {
            return sizeOfFigure;
        }

        long numberByYakobstalWidth = 1;
        long numberByYakobstalHeight = 3;
        long numberByYakobstalTouch = 0;
        boolean left = true; // (x, y) left "true", if element on position x
        boolean width = true;// (x, y) width "true", if x > y


        for (int i = 2; i <= n; i++) {

            long[] temp = new long[2];
            temp[0] = sizeOfFigure[0];
            temp[1] = sizeOfFigure[1];

            if (i % 2 == 0) {
                if (width) {
                    width = false;
                    sizeOfFigure[0] = temp[1] + numberByYakobstalWidth;
                    sizeOfFigure[1] = temp[0];
                    numberByYakobstalWidth = numberByYakobstalWidth * 4 + 1;
                } else {
                    width = true;
                    sizeOfFigure[0] = temp[1];
                    sizeOfFigure[1] = temp[0] + numberByYakobstalHeight;
                    numberByYakobstalHeight = numberByYakobstalHeight * 4 - 1;
                }
            } else {
                if (left) {
                    left = false;
                    sizeOfFigure[0] = temp[0] + numberByYakobstalTouch;
                    sizeOfFigure[1] = temp[1] * 2 + 1;
                    if (numberByYakobstalTouch == 0) {
                        numberByYakobstalTouch++;
                    } else {
                        numberByYakobstalTouch = numberByYakobstalTouch * 2 + 1;
                    }
                } else {
                    left = true;
                    sizeOfFigure[0] = temp[0] * 2 + 1;
                    sizeOfFigure[1] = temp[1] + numberByYakobstalTouch;
                    if (numberByYakobstalTouch > 1) {
                        numberByYakobstalTouch = numberByYakobstalTouch * 2 - 1;
                    }
                }
            }
        }
        return sizeOfFigure;
    }
}