package telran.list.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import telran.list.interfaces.Ilist;

public class MyArrayList<E> implements Ilist<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;

    public class MyIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) elements[currentIndex++];
        }
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
        if (initialCapacity > MAX_ARRAY_SIZE) {
            initialCapacity = MAX_ARRAY_SIZE;
        }
        elements = new Object[initialCapacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(); 
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() {
        if (size == MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2 + 1;
            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public void clear() {
        if (elements != null) {
            Arrays.fill(elements, null); 
        }
        size = 0; 
    }
    

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(int index, E element) {
       if(index < 0 || index > size) {
    	   throw new IndexOutOfBoundsException("Index out of range" + index);
       }
       if(size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
       for (int i = size; i > index; i--) {
		elements[i] = elements[i-1];
	}
       elements[index] = element;
       size++;
       return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E victim = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        elements[size] = null; // Убираем ссылку на удаленный элемент
        return victim;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E victim = (E) elements[index];
        elements[index] = element; // Исправлено: присваиваем элемент
        return victim;
    }
}
