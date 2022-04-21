
public class ArrayList<T> {
    public int size = 0;
    public Object[] arrayList;
    public final int INITIAL_SIZE = 10;

    public ArrayList() {

        arrayList = new Object[INITIAL_SIZE];
    }

    public boolean add(T element) {
        if (arrayList.length == size) {
            Object[] newArrayList = new Object[arrayList.length * 2];
            for (int i = 0; i < arrayList.length; i++) {
                newArrayList[i] = arrayList[i];
            }
            arrayList = newArrayList;
        }
        arrayList[size++] = element;
        return true;
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(); // throw an error also write test cases for error
        }
        T removedElement = (T) arrayList[index];
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[size - 1] = null;
        size--;
        return (removedElement);
    }

    public boolean contains(T element) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

}