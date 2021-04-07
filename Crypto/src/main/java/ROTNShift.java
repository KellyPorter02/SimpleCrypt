

public class ROTNShift {
    public final String upperCaseAlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final String lowerCaseAlphaString = "abcdefghijklmnopqrstuvwxyz";
    public final String specialCharacters = "', :.?!;";
    private String upperCaseEncryptString;
    private String lowerCaseEncryptString;
    private int shift;


    // could make a map for the shift, keys could be ints

    public ROTNShift() { this.shift = 6;}

     public ROTNShift(Character cs, Character cf) {
        this.shift = calculateShift(cs, cf);
        this.upperCaseEncryptString = shiftString(upperCaseAlphaString);
        this.lowerCaseEncryptString = shiftString(lowerCaseAlphaString);
    }

    public static String rotate(String inputString, Character c) {
        int indexOfInitialLetter = inputString.indexOf(c);
        String rotatedString = "";
        for (int i = 0; i < inputString.length(); i++) {
            rotatedString += inputString.charAt((i + indexOfInitialLetter) % inputString.length());
        }
        return rotatedString;
    }

    public String crypt(String text) throws UnsupportedOperationException {  // ask instructors what the intent of this is?
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
                decryptedText = "Something is wrong with the decrypt method";
            }
        }
        return decryptedText;
    }


    public boolean isUpperCase(Character charToTest) {
        if (upperCaseAlphaString.indexOf(charToTest) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public String shiftString(String inputString) {
        String shiftedString = "";
        for (int i = 0; i < inputString.length(); i++) {
            shiftedString += inputString.charAt((i + shift + inputString.length()) % inputString.length());
        }
        return shiftedString;
    }

    public int calculateShift(Character cs, Character cf) {
        this.shift = (26 - (lowerCaseAlphaString.indexOf(Character.toLowerCase(cs)) - lowerCaseAlphaString.indexOf(Character.toLowerCase(cf)))) % lowerCaseAlphaString.length();
        return shift;
    }

}
