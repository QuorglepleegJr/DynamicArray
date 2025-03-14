package dynamicarray;

public interface DynamicCollection<T> {

    /**
     * adds a new element to the collection
     *
     * @param data: the new element to add
     */
    void add(T data);

    /**
     * deletes an element from the collection at the given index
     *
     * @return the deleted element of the collection
     * @param index: index of the element to delete
     */
    T delete(int index);

    /**
     * gets an element from the collection at the given index
     *
     * @return the requested element of the collection at the given index
     * @param index: index of the element to get
     */
    T get(int index);

    /**
     * updates a collection element at the given index
     *
     * @param index: index of the element to update
     * @param value: value to set
     */
    void set(int index, T value);

    /**
     * gets the last element of the collection
     *
     * @return the last element of the collection
     *
     */
    T getLast();

    /**
     * gets a random element from the collection (w/uniform distribution, e.g.,
     * Random.nextInt)
     *
     * @return a random element of the collection
     *
     */
    T getRandom();

    /**
     *
     * @return a number of elements in the collection
     *
     */
    int size();

    /**
     * checks to see if the dynamic array is empty
     *
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     *
     * @return elements of the collection as a Java array of Objects
     *
     */
    Object[] toJavaArray();

    /**
     *
     * @return a copy of the underlying array (for testing purposes)
     *
     */
    Object[] getUnderlyingArrayCopy();
}
