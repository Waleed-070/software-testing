import org.example.PalindromeCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class test {
    @Test
    public void testSingleCharPalindrome() {
        String str = "a";
        assertTrue(PalindromeCheck.isPalindrome(str));
    }



    @Test
    public void testEmptyPalindrome() {
        String str = "";
        assertTrue(PalindromeCheck.isPalindrome(str));
    }

    @Test
    public void testNonPalindrome() {
        String str = "apple";
        assertFalse(PalindromeCheck.isPalindrome(str));
    }

    @Test
    public void testCaseSensitivePalindrome() {
        String str = "Madam";
        assertTrue(PalindromeCheck.isPalindrome(str));
    }

}
