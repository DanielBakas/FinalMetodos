/*
================================================================================
# Final Project
Module | `Factorial.java`

Authors\

May 12, 2022
================================================================================
*/

public class Factorial {
    public static int calculate(int n) {
        if (n <= 1)
            return 1;
        else
            return n * calculate(n - 1);
    }
}
