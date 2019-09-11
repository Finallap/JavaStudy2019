public class BubbleSort {
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;

        for (int k = 1; k< list.length && needNextPass; k++){
            for (int i = 0 ; i<list.length - k; i++){
                needNextPass = false;
                if(list[i]>list[i+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String [] args){
        int[] list = {51,23,55,63,85,45,36,54,25,63,22,52,36,45,78,23,56,45,85,75,96,35,12};
        bubbleSort(list);
        for (int i = 0; i<list.length; i++){
            System.out.print(list[i]+"\t");
        }
    }
}
