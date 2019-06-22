import static java.lang.Math.abs;

/** create a comparator implementing CharacterComparator. */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if (abs(x - y) == 1) {
            return true;
        }
        return false;
    }
}