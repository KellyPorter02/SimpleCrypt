

public class ROTCaesar extends ROTNShift  {


    private String lowerCaseEncryptString;
    private String upperCaseEncryptString;

    public ROTCaesar() {}


    public ROTCaesar(Character cs, Character cf) {
        super(cs, cf);
        this.upperCaseEncryptString = rotate(Character.toUpperCase(cs), Character.toUpperCase(cf));
        this.lowerCaseEncryptString = rotate(Character.toLowerCase(cs), Character.toLowerCase(cf));
    }


}
