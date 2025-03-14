package dynamicarray;

import java.util.Arrays;
import java.util.Random;

public class DynamicArray<T> implements DynamicCollection<T> {

    private T[] array;
    private int count = 0;

    private static Random randomGenerator = new Random();

    /**
     * constructor, initialises to 8 null elements
     */
    @SuppressWarnings("unchecked")
    // Safe to suppress this warning, as the only conversion here is from guarenteed null values
    // Source for this: VSCode's built in suggestions
    public DynamicArray(){
        array = (T[]) new Object[8];
    }

    /**
     * returns if the given index is valid for the current state
     * 
     * @return if the given index is valid
     * @param index: the index to check
     */
    private boolean isValidIndex(int index){
        return index >= 0 && index < count;
    }

    /**
     * adds a new element to the array
     *
     * @param data: the new element to add
     */
    public void add(T data){

        if (count == array.length){
            array = Arrays.copyOf(array, 2 * array.length);
        }

        array[count++] = data;
    }

    /**
     * deletes an element from the array at the given index
     *
     * @return the deleted element of the array
     * @param index: index of the element to delete
     */
    public T delete(int index){

        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException(
                String.format("Attempting to delete index %d of array of length %d", index, count)
            );
        }

        T deletedElement = array[index];

        count--;

        for (int i = index; i < count; i++){
            array[i] = array[i+1];
        }

        return deletedElement;
    }

    /**
     * gets an element from the array at the given index
     *
     * @return the requested element of the array at the given index
     * @param index: index of the element to get
     */
    public T get(int index){

        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException(
                String.format("Attempting to get index %d of array of length %d", index, count)
            );
        }

        return array[index];
    }

    /**
     * updates a array element at the given index
     *
     * @param index: index of the element to update
     * @param value: value to set
     */
    public void set(int index, T value){

        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException(
                String.format("Attempting to set index %d of array of length %d", index, count)
            );
        }

        array[index] = value;

        return;
    }

    /**
     * gets the last element of the array
     *
     * @return the last element of the array
     *
     */
    public T getLast(){

        return get(count-1);
    }

    /**
     * gets a random element from the array (w/uniform distribution, e.g.,
     * Random.nextInt)
     *
     * @return a random element of the array
     *
     */
    public T getRandom(){

        return get(randomGenerator.nextInt(count));
    }

    /**
     * gets the number of elements in the array
     * 
     * @return a number of elements in the array
     *
     */
    public int size(){
        return count;
    }

    /**
     * checks to see if the dynamic array is empty
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     *
     * @return elements of the array as a Java array of Objects
     *
     */
    public Object[] toJavaArray(){
        return (Object[])Arrays.copyOf(array, count);
    }

    /**
     *
     * @return a copy of the underlying array (for testing purposes)
     *
     */
    public Object[] getUnderlyingArrayCopy(){
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String toString(){
        // return Arrays.toString(toJavaArray());
        // Assuming this isn't the intended

        StringBuilder outString = new StringBuilder("[");

        for (int i = 0; i < count; i++){
            outString.append(get(i).toString());
            if (i != count - 1){
                outString.append(", ");
            }
        }

        outString.append("]");

        return outString.toString();
    }

}
