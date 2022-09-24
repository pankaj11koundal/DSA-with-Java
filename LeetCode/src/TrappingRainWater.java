
public class TrappingRainWater {

    static int trap(int[] height) {
        int size = height.length;
        int []maxL = new int[size];
        int []maxR = new int[size];

        maxL[0] = height[0];
        maxR[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++)
            maxL[i] = Math.max(maxL[i - 1], height[i]);

        for (int i = size - 2; i > -1; i--)
            maxR[i] = Math.max(maxR[i+1], height[i]);

        int []water = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            water[i] = Math.min(maxL[i], maxR[i]) - height[i];
            sum += water[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        int []height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


        System.out.println("The trapped rain water is " + trap(height));
    }
}
