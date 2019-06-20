public class Palindrome {
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
}
