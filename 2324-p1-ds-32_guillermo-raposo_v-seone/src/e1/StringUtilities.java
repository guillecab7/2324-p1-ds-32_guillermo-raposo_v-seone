package e1;

public class StringUtilities {
    public static boolean isValidString(String string, String permitedChars, int lengthString) {
        int n = string.length();
        if (lengthString > n) {
            return false;
        }
        if (string.isEmpty()) {
            return false;
        }
        int m = permitedChars.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (string.charAt(i) != permitedChars.charAt(j) || !Character.isDigit(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    //si esta entre 0 y 9 (en ascii) es verdadero, entro segundo bucle si es igual a los permitidos es verdadero si no se cumple ninguna es falso y returnas falso

    public static String lowercaseFirst(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El String de entrada no debe ser nulo");
        }

        StringBuilder lowerCaseChars = new StringBuilder();
        StringBuilder upperCaseChars = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseChars.append(c);
            } else {
                upperCaseChars.append(c);
            }
        }

        return lowerCaseChars + upperCaseChars.toString();
    }

    public static boolean checkTextStats (String string, int min, int max) {
        if (string.isEmpty() || min <= 0 || max <= 0) {
            System.out.println("IllegalArgumentException");
            return false;
        }
        int wordsCounter = 0, lettersCounter = 0, posibleWord = 0, biggerWord = 0;
        float media;
        for (int i = 0; i < string.length(); i++) {
            posibleWord = posibleWord + 1;
            if (string.charAt(i) == 32) {
                wordsCounter = wordsCounter + 1;
                if (posibleWord > biggerWord) {
                    biggerWord = posibleWord;
                    posibleWord = 0;
                } else {
                    posibleWord = 0;
                }
            } else {
                lettersCounter = lettersCounter + 1;
            }
        }
        media = (float)lettersCounter / (float)wordsCounter;
        if (media < min || media > max) return false;
        return (biggerWord <= 2 * media);
    }
}
