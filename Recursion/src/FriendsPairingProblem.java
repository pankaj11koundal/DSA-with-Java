// There are n friends, we have to find all the pairings possible. Each person can be paired with only one person or
// does not pair with anyone.

import java.util.Scanner;

public class FriendsPairingProblem {
    static Scanner sc = new Scanner(System.in);

    static int pairFriends(int n)
    {
        if (n == 0 || n == 1 || n == 2)
            return n;

        return pairFriends(n - 1) + pairFriends(n - 2) * (n - 1);
    }


    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number of friends: ");
        n = sc.nextInt();

        System.out.println(pairFriends(n));
    }

}
