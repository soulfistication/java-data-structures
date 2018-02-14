/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Ivan Almada
 */

public class Set implements Setable {
    
    private Object[] data;
    
    /*
     * Default Constructor
     */
    
    public Set() {
        this(20);
    }
    
    /*
     * Constructor with one parameter
     */
    
    public Set(int size) {
        data = new Object[size <= 0? 20 : size];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
    
    /*
     * Copy Constructor
     */
    public Set(Set set) {
        data = new Object[set.data.length];
        
        for (int i = 0; i < set.data.length; i++) {
            data[i] = set.data[i];
        }
    }
    
    // Setable Interface
    
    /*
     * Check if the set is empty or not.
     * @return boolean true if the set doesn't have any elements and false 
     * otherwise
     */
    
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Returns the number of elements in the Set.
     * @return int - number of elements in the Set.
     */
    
    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                size++;
            }
        }
        return size;
    }
    
    /*
     * Removes all the elements in the Set.
     */
    
    @Override
    public void empty() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
    
    /**
     * Check if the element is in the set.
     * @param element - the element to check
     * @return boolean - returns true if the element is in the Set
     * false otherwise.
     */
    
    @Override
    public boolean contains(Object element) {
        if (!isEmpty()) {
            for (int i = 0; i < data.length; i++) {
                if (element.equals(data[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Deletes the specified element from the Set.
     * @param element - the element to be deleted.
     */
    
    public void delete(Object element) {
        if (!isEmpty()) {
            for (int i = 0; i < data.length; i++) {
                if (element.equals(data[i])) {
                    data[i] = null;
                    return;
                }
            }
        }
    }
    
    /**
     * Adds an element to the set if and only if it isn't already in the set.
     * @param element - the element to be added.
     * @throws IllegalArgumentException - if the Set is full.
     */
    
    public void add(Object element) {
        if (!contains(element)) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    data[i] = element;
                    return;
                }
            }
            throw new IllegalArgumentException("Cannot add the element: " 
                    + element + "because the set is full.");
        }
    }
    
    /**
     * Method that return an iterator over the Set.
     * @return Iterator - iterator over the set.
     */
    
    public Iterator iterator() {
        return new SetIterator();
    }
    
    private class SetIterator implements Iterator {
        private int position;
        
        public SetIterator() {
            position = 0;
        }
        
        public boolean hasNext() {
            while (position < data.length && data[position] == null) {
                position++;
            }
            return (position < data.length);
        }
        
        public Object next() throws NoSuchElementException {
            if (hasNext()) {
                return data[position++];
            }
            throw new NoSuchElementException("No more elements in the set.");
        }
        
        public void remove() throws UnsupportedOperationException,
                IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Print all the elements in the Set
     * @param set - Set to print 
     */
    public void print(Setable set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
    
    /**
     * Method that returns the union of both calling set and parameter set.
     * @param c Set
     * @return union Set
     */
    
    public Set union(Setable c) {
        Set unionSet = new Set(this);
        Iterator it = unionSet.iterator();
        while (it.hasNext()) {
            unionSet.add(it.next());
        }
        return unionSet;
    }
    
    /**
     * Method that returns the intersection of both sets.
     * @param set - set that intersects the calling set.
     * @return Set - intersection set.
     */
    
    public Set intersection(Setable set) {
        Set intersectionSet = new Set(this);
        
        Iterator it = iterator();
        
        while (it.hasNext()) {
            Object element = it.next();
            if (!set.contains(element)) {
                intersectionSet.delete(element);
            }
        }
        
        return intersectionSet;
    }
    
    /**
     * Method that returns the difference of two sets.
     * @param c - provided set to make the difference.
     * @return Set - difference between the calling set and the parameter set.
     */
    
    public Set difference(Setable c) {
        Set differenceSet = new Set(this);
        Iterator it = iterator();
        
        while (it.hasNext()) {
            Object element = it.next();
            if (c.contains(element)) {
                differenceSet.delete(element);
            }
        }
        
        return differenceSet;
    }
    
    /**
     * Method to determine if the calling set is subset of the set provided as
     * parameter.
     * @param c The provided set.
     * @return boolean -- true if the set calling the method is a subset of the
     * set provided as parameter.
     */
    public boolean isSubset(Setable c) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
