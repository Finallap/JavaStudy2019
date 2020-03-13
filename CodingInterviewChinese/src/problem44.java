/**
 * @description: problem44:数字序列中的某一位数字
 * @date: 2020/3/13 11:19
 * @author: Finallap
 * @version: 1.0
 */
public class problem44 {
    public static int getNumAtIndex(int index) {
        //先计算是在几位数中(place)
        int currentPlaceNumCount = 9;
        int currentIndex = 0;
        int place = 1;
        while ((currentIndex + currentPlaceNumCount * place) <= index) {
            currentIndex += currentPlaceNumCount * place;
            place++;
            currentPlaceNumCount *= 10;
        }

        //计算在place数中的第几位
        int indexFromRight = index - currentIndex - 1;
        int countNumFromRight = indexFromRight / place;

        //计算该数字
        int resultNum = (int) (Math.pow(10, place - 1) + countNumFromRight);

        //计算在该数字中第几位
        int remainIndex = indexFromRight % place;

        //计算返回结果
        return Integer.parseInt(Integer.toString(resultNum).substring(remainIndex, remainIndex + 1));
    }

    public static void main(String[] args) {
        System.out.println(getNumAtIndex(1001));
    }
}
