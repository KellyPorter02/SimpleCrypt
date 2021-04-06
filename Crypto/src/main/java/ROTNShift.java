

public class ROTNShift {
    public static String upperCaseAlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String lowerCaseAlphaString = "abcdefghijklmnopqrstuvwxyz";
    public static String specialCharacters = "', :.?!;";
    private String upperCaseEncryptString;
    private String lowerCaseEncryptString;


    public ROTNShift() {}

     public ROTNShift(Character cs, Character cf) {

        upperCaseEncryptString = rotate(Character.toUpperCase(cs), Character.toUpperCase(cf));
        lowerCaseEncryptString = rotate(Character.toLowerCase(cs), Character.toLowerCase(cf));
    }

    public static String rotate(String inputString, Character c) {
        int indexOfInitialLetter = inputString.indexOf(c);
        String rotatedString = "";
        for (int i = 0; i < inputString.length(); i++) {
            rotatedString += inputString.charAt((i + indexOfInitialLetter) % inputString.length());
        }
        return rotatedString;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        return encrypt(text);
    }

    public String encrypt(String text) {
        String encryptedText = "";
        for (int i = 0; i < text.length(); i++) {
            if (specialCharacters.contains(text.subSequence(i, i + 1))) {
                int indexOfSpcCharacter = specialCharacters.indexOf(text.charAt(i));
                encryptedText += specialCharacters.charAt(indexOfSpcCharacter);
            } else if (isUpperCase(text.charAt(i))) {
                int indexOfUpperCaseEncryptString = upperCaseEncryptString.indexOf(text.charAt(i));
                encryptedText += upperCaseAlphaString.charAt(indexOfUpperCaseEncryptString);
            } else if (!isUpperCase(text.charAt(i))) {
                int indexOfLowerCaseEncryptString = lowerCaseEncryptString.indexOf(text.charAt(i));
                encryptedText += lowerCaseAlphaString.charAt(indexOfLowerCaseEncryptString);
            } else {
                encryptedText = "Something is wrong with the encrypt method";
            }
        }
        return encryptedText;
    }

    public String decrypt(String text) {
        String decryptedText = "";
        for (int i = 0; i < text.length(); i++) {
            if (specialCharacters.contains(text.subSequence(i, i + 1))) {
                int indexOfSpcCharacter = specialCharacters.indexOf(text.charAt(i));
                decryptedText += specialCharacters.charAt(indexOfSpcCharacter);
            } else if (isUpperCase(text.charAt(i))) {
                int indexOfUpperCaseEncryptString = upperCaseAlphaString.indexOf(text.charAt(i));
                decryptedText += upperCaseEncryptString.charAt(indexOfUpperCaseEncryptString);
            } else if (!isUpperCase(text.charAt(i))) {
                int indexOfLowerCaseEncryptString = lowerCaseAlphaString.indexOf(text.charAt(i));
                decryptedText += lowerCaseEncryptString.charAt(indexOfLowerCaseEncryptString);
            } else {
                decryptedText = "Something is wrong with the encrypt method";
            }
        }
        return decryptedText;
    }

    public String rotate(Character startChar, Character finishChar) {
        int shift = 0;
        if (isUpperCase(startChar)) {
            shift = upperCaseAlphaString.indexOf(startChar) - upperCaseAlphaString.indexOf(finishChar);
            String shiftedUpperAlphaString = "";
            for (int i = 0; i < upperCaseAlphaString.length(); i++) {
                shiftedUpperAlphaString += upperCaseAlphaString.charAt((i - shift) % upperCaseAlphaString.length());
            }
            return shiftedUpperAlphaString;
        } else if (!isUpperCase(startChar)) {
            shift = lowerCaseAlphaString.indexOf(startChar) - lowerCaseAlphaString.indexOf(finishChar);
            String shiftedLowerAlphaString = "";
            for (int i = 0; i < lowerCaseAlphaString.length(); i++) {
                shiftedLowerAlphaString += lowerCaseAlphaString.charAt((i - shift) % lowerCaseAlphaString.length());
            }
            return shiftedLowerAlphaString;
        } else {
            return "Something went wrong in the overloaded rotate method";
        }
    }

    public boolean isUpperCase(Character charToTest) {
        if (upperCaseAlphaString.indexOf(charToTest) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
