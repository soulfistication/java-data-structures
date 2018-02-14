/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.Iterator;

/**
 *
 * @author Ivan Almada
 */

public interface Setable {
    public void add(Object element);
    public void delete(Object element);
    public boolean contains(Object element);
    public boolean isEmpty();
    public int size();
    public void empty();
    public Setable union(Setable set);
    public Setable intersection(Setable set);
    public Setable difference(Setable set);
    public boolean isSubset(Setable set);
    
    // Extended interface
    public Iterator iterator();
    public void print(Setable set);
}
