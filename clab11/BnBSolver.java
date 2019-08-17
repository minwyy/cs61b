import java.util.ArrayList;
import java.util.List;

/**
 * BnBSolver for the Bears and Beds problem. Each Bear can only be compared to Bed objects and each Bed
 * can only be compared to Bear objects. There is a one-to-one mapping between Bears and Beds, i.e.
 * each Bear has a unique size and has exactly one corresponding Bed with the same size.
 * Given a list of Bears and a list of Beds, create lists of the same Bears and Beds where the ith Bear is the same
 * size as the ith Bed.
 */
public class BnBSolver {
    List<Bear> bear;
    List<Bed> bed;

    public BnBSolver(List<Bear> bears, List<Bed> beds) {
        List<Bear> bear = quickSortBears(bears, beds);
        List<Bed> bed = quickSortBeds(beds, bears);
    }

    /**
     * Returns List of Bears such that the ith Bear is the same size as the ith Bed of solvedBeds().
     */
    public List<Bear> solvedBears() {
        // TODO: Fix me.
        return this.bear;
    }

    /**
     * Returns List of Beds such that the ith Bear is the same size as the ith Bear of solvedBears().
     */
    public List<Bed> solvedBeds() {
        // TODO: Fix me.
        return bed;
    }

    /** return a new list hat contains the given list catenated together. */
    private static <Item extends Comparable> List<Item> catenate(List<Item> q1, List<Item> q2) {
        List<Item> catenated = new ArrayList<>();
        for (Item item : q1) {
            catenated.add(item);
        }
        for (Item item: q2) {
            catenated.add(item);
        }
        return catenated;
    }

    /** get random bed or bear. */
    private static <Item extends Comparable> Item getRandomB(List<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /** partition the given unsorted queue by pivoting on the given item for bears using bed*/
    private static <Item extends Comparable> void partitionBear(
            List<Item> unsorted, Bed pivot,
            List<Item> less, List<Item> equal, List<Item> greater) {
        for (Item s : unsorted) {
            if (s.compareTo(pivot) < 0) {
                less.add(s);
            } else if (s.compareTo(pivot) == 0) {
                equal.add(s);
            } else {
                greater.add(s);
            }
        }
    }

    /** quicksort list */
    public static <Bear extends Comparable> List<Bear> quickSortBears(
            List<Bear> items, List<Bed> beds) {
        List<Bear> less = new ArrayList<>();
        List<Bear> equal = new ArrayList<>();
        List<Bear> more = new ArrayList<>();
        Bed pivot = getRandomB(beds);
        partitionBear(items, pivot, less, equal, more);
        // recursion until size become 0
        while (less.size() > 1) {
            quickSortBears(less, beds);
        }
        items = catenate(less, equal);
        while (more.size() > 1) {
            quickSortBears(more,beds);
        }
        items = catenate(items, more);
        return items;
    }


    /** partition the given unsorted queue by pivoting on the given item for beds using bear*/
    private static <Item extends Comparable> void partitionBed(
            List<Item> unsorted, Bear pivot,
            List<Item> less, List<Item> equal, List<Item> greater) {
        for (Item s : unsorted) {
            if (s.compareTo(pivot) < 0) {
                less.add(s);
            } else if (s.compareTo(pivot) == 0) {
                equal.add(s);
            } else {
                greater.add(s);
            }
        }
    }

    /** quicksort list */
    public static <Bed extends Comparable> List<Bed> quickSortBeds(
            List<Bed> items, List<Bear> bears) {
        List<Bed> less = new ArrayList<>();
        List<Bed> equal = new ArrayList<>();
        List<Bed> more = new ArrayList<>();
        Bear pivot = (Bear) getRandomB(bears);
        partitionBed(items, pivot, less, equal, more);
        // recursion until size become 0
        while (less.size() > 1) {
            quickSortBeds(less, bears);
        }
        items = catenate(less, equal);
        while (more.size() > 1) {
            quickSortBeds(more,bears);
        }
        items = catenate(items, more);
        return items;
    }

}


