public class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        
        String longPstring = "";
        String long2Pstr = "";
        String pString = "";
        StringBuffer pStr =  new StringBuffer(s);
        if (s.length() == 1 ){
            return s;
        } else if (pStr.toString().equals(pStr.reverse().toString())){
            return pStr.toString();    
        } else if (s.length() == 3){
            pStr =  new StringBuffer();
            if (s.charAt(0) == s.charAt(1)){
                pStr.append(s.charAt(0));
                pStr.append(s.charAt(1));
                return pStr.toString(); 
            }
            if (s.charAt(1) == s.charAt(2)){
                pStr.append(s.charAt(1));
                pStr.append(s.charAt(2));
                return pStr.toString(); 
            }
            pStr =  new StringBuffer(s);
        }
        int longest = 0;
        for (int i = 1; i > longest/2 && longest/2 < ((s.length()-1-i));i++ ) {
            
            pString = findifLeterIsCenterofPalindrome(s, i);
            if (pString.length() > longPstring.length()) {
                longPstring = pString;
                longest = longPstring.length();
            }
        }
        if (s.length() > 3){
            longest = 0;
            for (int i=2; i > longest/2 && longest/2 < ((s.length()-1-i)); i++){
                pString = findTwoLetterPalindrome(s, i);
                if (pString.length() > longPstring.length()) {
                    longPstring = pString;
                    longest = longPstring.length();
                }
            }
        } 
        return longPstring;
        
    }
    public String findifLeterIsCenterofPalindrome(String s, int center){
        int i = center + 1;
        int j = center - 1;
        int p = 0;
        StringBuffer pStr =  new StringBuffer();
        if (i < s.length() && s.charAt(i) == s.charAt(j)){
            pStr.append(s.charAt(i));
            pStr.append(s.charAt(center));
            pStr.append(s.charAt(j));
            i++;
            j--;
        } else {
            return pStr.toString();
        }
        while (i < s.length() && j >= 0){
            if (s.charAt(i) == s.charAt(j)){
                
                // insert j
                pStr.append(s.charAt(j));
                pStr = pStr.reverse();
                pStr.append(s.charAt(i));
                i++;
                j--;
            } else {
                break;
            }
        }
        return pStr.toString();
    }
    public String findTwoLetterPalindrome(String s, int center){
       int i = center + 1;
        int j = center - 2;
        int p = 0; 
        StringBuffer pStr =  new StringBuffer();
        
        if ((s.charAt(center) == s.charAt(center-1)) && (i < s.length() && s.charAt(i) == s.charAt(j))){
            pStr.append(s.charAt(j));
            pStr.append(s.charAt(center-1));
            pStr.append(s.charAt(center));
            pStr.append(s.charAt(i));
            i++;
            j--;
        } else {
            return pStr.toString();
        }

        while (i < s.length() && j >= 0){
            if (s.charAt(i) == s.charAt(j)){
                // insert j
                pStr.append(s.charAt(j));
                pStr = pStr.reverse();
                pStr.append(s.charAt(i));
                i++;
                j--;
            } else {
                break;
            }
        }
        return pStr.toString();
    }
}
