package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinQueue<V> implements PriorityQueue<Integer, V> {

  //AbstractArrayHeap pQueue;
  ReverseIntegerComparator comparator = new ReverseIntegerComparator();
  public AbstractArrayHeap<Integer, V> pQueue = new StudentArrayHeap<Integer, V>(comparator);

  @Override
  public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
    // TODO Auto-generated method stub
    //PriorityQueue<Integer, V> newMaxQueue = new MaxQueue<V>();
    pQueue = pQueue.add(priority, value);
    return this;
  }

  @Override
  public V dequeue() {
    // TODO Auto-generated method stub
    //When dequeuing, the element with the highest priority is dequeued first.
    return (V)pQueue.remove();
  }

  @Override
  public V peek() {
    if (pQueue.isEmpty()) {
      throw new NoSuchElementException("Cannot peek at an empty ArrayHeap.");
    }
    return ((Entry<Integer, V>) pQueue.heap.get(0)).getValue();
  }

  @Override
  public Iterator<Entry<Integer, V>> iterator() {
    // TODO Auto-generated method stub
    return pQueue.asList().iterator();
  }

  @Override
  public Comparator<Integer> getComparator() {
    // TODO Auto-generated method stub
    return pQueue.getComparator();
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return pQueue.size();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return pQueue.isEmpty();
  }
}


