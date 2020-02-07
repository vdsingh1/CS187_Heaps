package comparators;

import java.util.Comparator;

/**
 * An {@link IntegerComparator} compares integers in the natural way.
 *
 */
public class IntegerComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer arg0, Integer arg1) {
    //The MaxQueue is implemented such that higher integer values have the highest priority
    // TODO
    if(arg0 > arg1) {
      return 1;
    }else if(arg1 > arg0) {
      return -1;
    }else {
      return 0;
    }
  }
//  public int compare(String arg0, String arg1) {
//    if (arg0.length() < arg1.length()) {
//      return -1;
//    }
//    if (arg0.length() > arg1.length()) {
//      return 1;
//    }
//    return arg0.compareTo(arg1);
//  }
}
