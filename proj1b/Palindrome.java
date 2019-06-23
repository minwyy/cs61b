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

    /** (helper) return true if the Deque word is palindrome. */
    private boolean isPalindromeHelper(Deque dequeWord) {
        if (dequeWord.size() <= 1) {
            return true;
        }
        if (dequeWord.removeFirst() != dequeWord.removeLast()) {
            return false;
        } else {
            return isPalindromeHelper(dequeWord);
        }
    }

    /** Return true if a given word is a palindrome. */
    public boolean isPalindrome(String word) {
        Deque test = wordToDeque(word);
        return isPalindromeHelper(test);
    }

    /** (helper) return true if the Deque word is palindrome off by 1. */
    private boolean isPalindromeHelper(Deque dequeWord, CharacterComparator cc) {
        if (dequeWord.size() <= 1) {
            return true;
        }
        if (cc.equalChars((char) dequeWord.removeFirst(), (char) dequeWord.removeLast())) {
            return isPalindromeHelper(dequeWord, cc);
        } else {
            return false;
        }
    }

    /** Return true if a given word is a palindrome off by 1. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque test = wordToDeque(word);
        return isPalindromeHelper(test, cc);
    }

}
