/*
 * QUestion: 
 * Given an array and a threshold value find the o/p 
    eg) i/p {5,8,10,13,6,2};threshold = 3;
    o/p count = 17
 */

package ArrayProblems;

public class Threshold 
{
    public static void main(String[] args) 
    {
        int[] arr = {5,8,10,13,6,2};

        int threshold = 3;

        findThresholdCount(arr, threshold);
    }


    public static void thresVal(int[] arr, int threshold)
    {
        int count = 0;
        for(int i : arr)
        {
            while(i>0)
            {
                i = i - threshold;
                count++; //When the number is decreased the count increases
            }
        }
        System.out.println(count);
    }

    //PREFERABLE METHOD
    static void findThresholdCount(int[] arr, int threshold)
    {
        int count = 0;
        for(int i : arr){
            while(i>threshold){ //Checking only for threshold
                i = i-threshold;
                count++;
            }
            count++;//when the number is less than threshold, the count must be incremented
        }
        System.out.println(count);
    }
}
