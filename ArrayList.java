package project;

import java.util.Arrays;

public class ArrayList implements IntList{
    private int[] array;

    public ArrayList() {
        this.array = new int[0];
    }

    @Override
    public void add(int element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
    }

    @Override
    public void add(int index, int element) {

        int[] newArr = new int[array.length + 1];

        System.arraycopy(array, 0, newArr, 0, index);
        newArr[index] = element;
        System.arraycopy(array, index, newArr, index + 1, array.length - index);
        array = newArr;
    }

    @Override
    public void clear() {
        this.array = new int[]{};
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return (array.length == 0);
    }

    @Override
    public int remove(int index) {
        if (index >= 0 && index < array.length) {
            int result = array[index];
            for (int i = index + 1; i < array.length; i++) {
                array[i - 1] = array[i];
            }
            array = Arrays.copyOf(array, array.length - 1);
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public boolean removeByValue(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int set(int index, int element) {
        int previousElem = array[index];
        array[index] = (array[index] + element) - array[index];
        return previousElem;
    }


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new ArrayList();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(array[i]);
        }
        return list;
    }


    public int[] toArray() {
        return array;
    }
}
