import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator ob1 = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("bubble"));
    }

    @Test
    public void testisPalindromeOB1() {
        assertTrue(palindrome.isPalindrome("a", ob1));
        assertTrue(palindrome.isPalindrome("", ob1));
        assertTrue(palindrome.isPalindrome("flake", ob1));
        assertFalse(palindrome.isPalindrome("cat", ob1));
    }
}