public class Palindrome {
    /** Convert word into Deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque a = new ArrayDeque();
        if (word == null) {
            return null;
        }
        for (int i = 0; i < word.length(); i++) {
            a.addLast(word.charAt(i));
        }
        return a;
    }

    /** (helper) return true if the word is palindrome from i to word.length - i. */
    private boolean isPalindromehelper(Deque dequeWord) {
        if (dequeWord.size() <= 1) {
            return true;
        }
        if (dequeWord.removeFirst() != dequeWord.removeLast()) {
            return false;
        } else {
            return isPalindromehelper(dequeWord);
        }
    }

    /** Return true if a given word is a palindrome. */
    public boolean isPalindrome(String word) {
        Deque test = wordToDeque(word);
        return isPalindromehelper(test);
    }
}
