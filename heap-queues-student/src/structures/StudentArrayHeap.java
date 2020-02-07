package structures;

import java.util.Comparator;

import comparators.StringLengthComparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

  public static void main(String[] args) {
    StudentArrayHeap<String, Integer> ah = new StudentArrayHeap<String, Integer>(new StringLengthComparator());
    ah.add(".", 1);
    ah.add("..", 2);
    //System.out.println(ah.getParentOf(ah.heap.indexOf(ah.heap.get(1))));
    ah.add("...", 3);
    ah.add(".....", 4);

    //ah.remove();
    System.out.println(ah.heap);
    //    System.out.println(ah.peek());
  }

  protected StudentArrayHeap(Comparator<P> comparator) {
    super(comparator);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected int getLeftChildOf(int index) {
    // TODO Auto-generated method stub
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return (2 * index + 1);
  }

  @Override
  protected int getRightChildOf(int index) {
    // TODO Auto-generated method stub
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return (2 * index + 2);
  }

  @Override
  protected int getParentOf(int index) {
    if (index < 1) {
      throw new IndexOutOfBoundsException();
    }
    return ((index - 1) / 2);
  }

  @Override
  protected void bubbleUp(int index) {//keep swapping until the element is in a spot that satisfies heap requirements
    Entry<P,V> elem = heap.get(index);
    int parent = (index - 1) / 2;
    while ((index > 0) && comparator.compare(elem.getPriority(), heap.get(parent).getPriority())> 0) {
      heap.set(index, heap.get(parent));
      index = parent;
      parent =  (parent-1)/2;
    }
    heap.set(index, elem);
  }

  @Override
  protected void bubbleDown(int index) {
        Entry<P, V> elem = heap.get(index);
        while(true) {
          if (getLeftChildOf(heap.indexOf(elem)) < heap.size() && 
              comparator.compare(elem.getPriority(), heap.get(getLeftChildOf(heap.indexOf(elem))).getPriority()) < 0) {
            swap(heap.indexOf(elem), getLeftChildOf(heap.indexOf(elem)));
          } else if (getRightChildOf(heap.indexOf(elem)) < heap.size() &&
              comparator.compare(elem.getPriority(), heap.get(getRightChildOf(heap.indexOf(elem))).getPriority()) < 0) {
            swap(heap.indexOf(elem), getRightChildOf(heap.indexOf(elem)));
          } else {
            break;
          }
        }
//    int largerChild;
//    Entry<P,V> elem = heap.get(index);
//    while (index < heap.size()/2) { // has at least 1 child
//      int left = 2*index+1, right = 2*index+2;
//      if (right < heap.size() && // right child exists
//          comparator.compare(heap.get(getLeftChildOf(heap.indexOf(elem))).getPriority(), heap.get(getRightChildOf(heap.indexOf(elem))).getPriority()) < 0) {
//          //heap[left].compareTo(heap[right]) < 0)
//        largerChild = right;
//      }else {
//        largerChild = left;
//      }
//      if (comparator.compare(heap.get(getLeftChildOf(heap.indexOf(elem))).getPriority(), heap.get(getRightChildOf(heap.indexOf(elem))).getPriority()) >= 0) {
//        break;
//      }
//      heap.set(index, heap.get(largerChild));
//      //heap[index] = heap[largerChild];
//      index = largerChild;
//    }
//    heap.set(index, elem);
//    //heap[index] = elem;
  }
}

