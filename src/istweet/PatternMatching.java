import java.lang.String;

public class PatternMatching {
    //KMP Algorithm//
    public static int kmpMatch (String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        int fail[] = computeFail(pattern);
        int i = 0;
        int j = 0 ;

        while(i < n ){
            if (pattern.charAt(j) == text.charAt(i)){
                if (j == m -1){
                    return  i=m+1; // match
                    i++;
                    j++;'
                }else if (j > 0 ){
                    j = fail[j-1];
                }else i++;
            }
            return -1 // nomatch
        }// end of kmpMatch
    }
    //fungsi pembantu KMP Algorithm
    public static int[] computeFail(String pattern){
        int fail[] = new int[pattern.length()];
        fail[0]=0;
        int m = pattern.length();
        int j - 0;
        int i = 1;

        while ( i < m ){
            if (pattern.charAt(j) == pattern.charAt(i)){ // j+1 chars match
                fail[i]=j+1;
                i++;
                j++;
            }else if ( j > 0 ) //j follows matching prefix
                j = fail[j-1];
            else { //no match
                fail[i]=0;
                i++;
            }
        }
        return  fail;
    }// end of computeFail()
    public static int bmMatch (String text, String pattern){
        int last[] = buildLast(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = m-1;

        if(i>n-1) return -1;
        int j = m-1;
        do {
            if ( pattern.charAt(j)==text.charAt(i)){
                if ( j == 0) return i;
                else { //looking glass technique
                    i--;
                    j--;
                }
            }else{ //char jump technique
                int lo = last[text.charAt(i)];
                i = i +m-Math.min(j,l+lo);
                j=m-1;
            }
        }while(i <= n-1);
        return  -1 // no match
    }//end of bmMatch()
    public static int[] buildLast(String pattern){
        int last[] = new int[128];
        for (int i=0;i<128;i++) last[i]=-1; //init array
        for (int i=0;i<pattern.length();i++) last[pattern.charAt()]=i; //init array
        return last;
    }//end of buildLast()
}