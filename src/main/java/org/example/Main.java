package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Palindrom Sayıları Bulma
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

    // Mükemmel Sayıları Bulma
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

    // Sayıları Kelimelere Dökme
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        int reversedNumber = reverse(number);
        int digitCountOriginal = getDigitCount(number);
        int digitCountReversed = getDigitCount(reversedNumber);

        StringBuilder words = new StringBuilder();

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;

            switch (lastDigit) {
                case 0 -> words.append("Zero ");
                case 1 -> words.append("One ");
                case 2 -> words.append("Two ");
                case 3 -> words.append("Three ");
                case 4 -> words.append("Four ");
                case 5 -> words.append("Five ");
                case 6 -> words.append("Six ");
                case 7 -> words.append("Seven ");
                case 8 -> words.append("Eight ");
                case 9 -> words.append("Nine ");
            }

            reversedNumber /= 10;
        }

        // Eksik sıfırları ekle
        for (int i = 0; i < digitCountOriginal - digitCountReversed; i++) {
            words.append("Zero ");
        }

        return words.toString().trim();
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
