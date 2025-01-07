package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static boolean isPalindrome(int number) {
        int originalNumber = Math.abs(number); // Negatif sayılar için mutlak değer
        int reversedNumber = 0;
        int temp = originalNumber;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            temp /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false; // Sayı 0'dan küçükse
        }

        int sumOfDivisors = 0;

        for (int i = 1; i <= number / 2; i++) { // Kendisi hariç bölenler
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        return sumOfDivisors == number;
    }
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int reversedNumber = reverse(number);
        int digitCountOriginal = getDigitCount(number);
        int digitCountReversed = getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;

            switch (lastDigit) {
                case 0 -> System.out.print("Zero ");
                case 1 -> System.out.print("One ");
                case 2 -> System.out.print("Two ");
                case 3 -> System.out.print("Three ");
                case 4 -> System.out.print("Four ");
                case 5 -> System.out.print("Five ");
                case 6 -> System.out.print("Six ");
                case 7 -> System.out.print("Seven ");
                case 8 -> System.out.print("Eight ");
                case 9 -> System.out.print("Nine ");
            }

            reversedNumber /= 10;
        }

        // Eksik sıfırları yazdır
        for (int i = 0; i < digitCountOriginal - digitCountReversed; i++) {
            System.out.print("Zero ");
        }

        System.out.println(); // Yeni satır
    }

    // Yardımcı metod: Sayıyı ters çevir
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    // Yardımcı metod: Basamak sayısını bul
    public static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }
        if (number < 0) {
            number = Math.abs(number);
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

}
