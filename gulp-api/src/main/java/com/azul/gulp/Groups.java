package com.azul.gulp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface Groups<K, E> extends Iterable<Group<K, E>> {
  Group<K, E> get(K key);
  
  default Groups<K, E> sorted() {
    Groups<K, E> wrappedGroup = this;
    
    List<Group<K, E>> groups = new ArrayList<>();
    
    for ( Group<K, E> curGroup: this ) {
      groups.add(curGroup);
    }
    
    Comparator<Group<K, E>> keyComparator = (lhs, rhs) -> {
      K lhsKey = lhs.key();
      K rhsKey = rhs.key();
      
      if ( lhsKey instanceof Comparable ) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        Comparable<K> lhsComp = (Comparable)lhsKey;
        return lhsComp.compareTo(rhsKey);
      } else {
        // order is left unchanged -- lhs is always smaller than rhs
        return -1;
      }
    };
    
    groups.sort(keyComparator);
    
    List<Group<K, E>> sortedGroups = Collections.unmodifiableList(groups);
    
    return new Groups<K, E>() {
      @Override
      public Iterator<Group<K, E>> iterator() {
        return sortedGroups.iterator();
      }

      @Override
      public Group<K, E> get(K key) {
        return wrappedGroup.get(key);
      }
      
      @Override
      public Groups<K, E> sorted() {
        return this;
      }
    };
  }
}
