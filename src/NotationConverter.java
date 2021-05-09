import java.util.Locale;

/**
 * 09.05.2021
 * wrote by Alexey Gumen
 */
public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        InvalidValueException invalid = new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M]");
        int result = 0;
        char prev = 0;
        if (romanNotation == null || romanNotation.length()==0) throw invalid;                   //null check
        romanNotation = romanNotation.toUpperCase(Locale.ROOT);     //unify chars
        for (int i = romanNotation.length()-1; i >= 0 ; i--) {      //looking for chars backwards
            switch (romanNotation.charAt(i)){
                case 'I': result+=(prev=='X'|| prev=='V')?-1:1; break;
                case 'V': result+=5; break;
                case 'X': result+=(prev=='L' || prev=='C')?-10:10; break;
                case 'L': result+=50; break;
                case 'C': result+=(prev=='D' || prev=='M')?-100:100; break;
                case 'D': result+=500; break;
                case 'M': result+=1000; break;
                default: throw invalid;
            }
            prev = romanNotation.charAt(i);
        }
        return result;
    }
}



