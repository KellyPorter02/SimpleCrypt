

public class ROT13 extends ROTNShift {

    private String lowerCaseEncryptString;
    private String upperCaseEncryptString;
    private int shift;

    ROT13(Character cs, Character cf) {

        this.upperCaseEncryptString = rotate(Character.toUpperCase(cs), Character.toUpperCase(cf));
        this.lowerCaseEncryptString = rotate(Character.toLowerCase(cs), Character.toLowerCase(cf));
    }

    ROT13() {

    }


}

/*
public String encrypt(String word) {
          char[] inputWordCharArr = word.toLowerCase().toCharArray();
          String alpha = "abcdefghijklmnopqrstuvwxyz";
          char[] alphaCharArr = alpha.toCharArray();

          for (int i = 0; i < inputWordCharArr.length; i++) {
              int letterIndexInAlphaString = alpha.indexOf(inputWordCharArr[i]);
              inputWordCharArr[i] = alphaCharArr[(letterIndexInAlphaString + 3) % 26];
          }

          String encryptedWord = String.copyValueOf(inputWordCharArr);
          return encryptedWord;
      }
 */
