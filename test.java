
import org.junit.jupiter.api.Test;

public class PalindromeCheckTest {

    @Test
    public void testIsPalindrome_madam() {
        String str = "madam";
        boolean expectedResult = true;
        boolean actualResult = PalindromeCheck.isPalindrome(str);

        org.junit.jupiter.api.Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsPalindrome_racecar() {
        String str = "apple";
        boolean expectedResult = false;
        boolean actualResult = PalindromeCheck.isPalindrome(str);

        org.junit.jupiter.api.Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsPalindrome_notPalindrome() {
        String str = "";
        boolean expectedResult = true;
        boolean actualResult = PalindromeCheck.isPalindrome(str);

        org.junit.jupiter.api.Assertions.assertEquals(expectedResult, actualResult);
    }
}