package pgdp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lockpicker {

    private Mysterybox mbox;

    public Lockpicker(Mysterybox box) {
        this.mbox = box;
    }

    // ---------------------- Teil 1 Methoden ----------------------

    public String decryptInteger(int ix) {
        int result = Math.abs(ix * ix * mbox.getIntHint()) % 26;
        return HelperBook.intToAlphabetCharacter(result);
    }

    public String decryptFloat(float fx) {
        // TODO: Implementiere diese Methode
        double result = Math.abs(Math.cos((fx + mbox.getIntHint()) * mbox.getFloatHint()));
        long roundedResult = Math.round(result * 1000.0) % 1000;
        return String.valueOf(roundedResult);
    }

    public String decryptNumericalString(String sx) {
        String result = "";
        for (int i = 0; i < 8; i = i + 2) {
            result += HelperBook.intToAlphabetCharacter(Integer.parseInt(sx.substring(i, i + 2)) % 26);
        }
        return result;

    }

    // ---------------------- Teil 2 Methoden ----------------------

    public Float decryptModular(int a, int b) {
        // TODO: Implementiere diese Methode
        float firstResult = a * mbox.getFloatHint();
        float secondResult = b / mbox.getFloatHint();
        return firstResult % secondResult;
    }

    public String decryptMinimal(float x, float y) {
        // TODO: Implementiere diese Methode
        float max = Math.max(x, y);
        float min = Math.min(x, y);


        String result = "";
        double firstResult = Math.sqrt(max);
        float secondResult = min * mbox.getFloatHint();
        String roundedFirstResult = String.valueOf(Math.round(firstResult * 10000.0));
        String roundedSecondResult = String.valueOf(Math.round(secondResult * 10000.0));
        return (roundedFirstResult).substring(roundedFirstResult.length()-4) +
               (roundedSecondResult).substring(roundedSecondResult.length()-4);

    }

    public int decryptBytepolar(int i, byte b) {
        int dividend = i * b;
        int divisor = ((i % b) << 1) + 1;
        return dividend / divisor;
    }

    // ---------------------- Teil 3 Methoden ----------------------

    public boolean solve() {

        String s1 = decryptInteger(decryptBytepolar(mbox.getPolarVal1(), getMbox().getPolarVal2()));
        String s2 = decryptFloat(decryptModular(mbox.getModularVal1(), mbox.getModularVal2()));
        String s3 = decryptNumericalString(decryptMinimal(mbox.getMinimalVal1(), mbox.getMinimalVal2()));
        return mbox.checkSolution(s1 + "_" + s2 + "_" + s3);
    }

    // ====================== Helper/Getter/Setter ======================


    public Mysterybox getMbox() {
        return mbox;
    }

    public void setMbox(Mysterybox mbox) {
        this.mbox = mbox;
    }

    public static void main(String[] args) {

    }
}
