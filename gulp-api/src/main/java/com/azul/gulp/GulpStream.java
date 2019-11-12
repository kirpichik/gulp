package com.azul.gulp;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;



public interface GulpStream<T> /* TODO implements Stream */ {
  interface RangeFactory<C, R> {
    R make(C start, C end);
  }
  
  
  <U> GulpStream<U> map(ThrowingFunction<? super T, ? extends U> transform);
  
  <U> GulpStream<U> map(final Map<? super T, ? extends U> map);
  
  <U, V> GulpPairStream<U, V> map(
          final ThrowingFunction<? super T, ? extends U> firstMap,
          final ThrowingFunction<? super T, ? extends V> secondMap);
  
  <U> GulpStream<U> flatMap(ThrowingFunction<? super T, ? extends Iterable<? extends U>> transform);
  
  <U, V> GulpPairStream<U, V> flatMap(
          final ThrowingFunction<? super T, ? extends Iterable<? extends U>> firstMap,
          final ThrowingFunction<? super T, ? extends Iterable<? extends V>> secondMap);
  
  GulpStream<Boolean> predicateMap(Predicate<? super T> predicate);
  
  boolean contains(T element);
  
  boolean contains(Predicate<? super T> predicate);
  
  GulpStream<T> beforeInclusive(Predicate<? super T> predicate);
  
  GulpStream<T> beforeExclusive(Predicate<? super T> predicate);
  
  GulpStream<T> before(
          Predicate<? super T> predicate,
          boolean inclusive);
  
  GulpStream<T> afterInclusive(Predicate<? super T> predicate);
  
  GulpStream<T> afterExclusive(Predicate<? super T> predicate);
  
  GulpStream<T> after(
          Predicate<? super T> predicate,
          boolean inclusive);
  
  GulpStream<T> skip(int count);
  
  GulpStream<T> limit(int count);
  
  GulpStream<T> filter(Predicate<? super T> predicate);
  
  GulpStream<T> filter(Set<? super T> set);
  
  @SuppressWarnings("unchecked")
  GulpStream<T> filter(T... set);
  
  GulpStream<T> filterOut(Predicate<? super T> predicate);
  
  GulpStream<T> filterOut(Set<? super T> set);
  
  @SuppressWarnings("unchecked")
  GulpStream<T> filterOut(T... set);
  
  GulpStream<T> sort();
  
  GulpStream<T> sortDescending();
  
  <C extends Comparable<C>> GulpStream<T> sortBy(
          final ThrowingFunction<? super T, ? extends C> mapFn);
  
  <C extends Comparable<C>> GulpStream<T> sortByDescending(
          final ThrowingFunction<? super T, ? extends C> mapFn);
  
  GulpStream<T> sortUsing(final Comparator<? super T> comparator);

  GulpStream<T> unique();
  
  GulpStream<T> unique(final ThrowingFunction<? super T, ?> identityFn);
  
  // currently hard to implement - need to think about to this.
  // public abstract <K> GulpStream<T> lastUnique(final ThrowingFunction<? super T, K> identityFn);
  
  Result<Integer> count();
  
  // public abstract <K> Result<Counts<K>> countBy(final ThrowingFunction<? super T, ? extends K> keyFn);
  
  @SuppressWarnings("rawtypes")
  Result process(Processor<? super T> processor)
    throws StreamProcessingException;
  
  void forEachIndexed(IndexedProcessor<? super T> processor)
    throws StreamProcessingException;
  
  void forEach(Processor<? super T> processor)
    throws StreamProcessingException;
  
  // public abstract void forEachPacket(Processor<Packet<? super T>> processor);
 
  <R> Result<R> analyze(Analyzer<? super T, ? extends R> analyzer)
    throws StreamProcessingException;
  
  <R> R analyzeAndGet(Analyzer<? super T, ? extends R> analyzer)
    throws StreamProcessingException;
  
  <P, R> ParameterizedResult<P, R> analyze(ParameterizedAnalyzer<? super T, ? super P, ? extends R> analyzer)
    throws StreamProcessingException;
  
  boolean matchesOne(final Predicate<? super T> predicate);
  
  boolean matchesOne(final Set<? super T> set);
  
  Optional<T> first(Predicate<? super T> predicate);
  
  Optional<T> first(Set<? super T> set);
  
  Optional<T> first();
  
  Optional<T> last(Predicate<? super T> predicate);
  
  Optional<T> last(Set<? super T> predicate);
  
  Optional<T> last();
  
  <K> Groups<K, T> group(GroupingProcessor<K, T> groupingProcessor);
  
  <K> Groups<K, T> groupBy(ThrowingFunction<? super T, ? extends K> groupFn);
  
  Groups<Integer, T> groupEvery(int count);
  
  Groups<Integer, T> splitOn(final T value);
  
  Groups<Integer, T> splitOn(Predicate<? super T> predicateFn);
  
  Result<T> min();
  
  <V> Result<V> min(
          final ThrowingFunction<? super T, ? extends V> mapFn);
  
  Result<T> max();
  
  <V> Result<V> max(
          final ThrowingFunction<? super T, ? extends V> mapFn);
  
  Result<Range<T>> range();
  
  <V> Result<Range<V>> range(
          final ThrowingFunction<? super T, ? extends V> mapFn);
  
  <V> Result<Range<V>> range(
          final ThrowingFunction<? super T, ? extends V> lowerFn,
          final ThrowingFunction<? super T, ? extends V> upperFn);
  
  <R> Result<R> extractRange(RangeFactory<? super T, ? extends R> rangeFactory);
  
  void addTo(Collection<? super T> collection);
  
  Set<T> toSet(Predicate<? super T> predicate);
  
  Set<T> toSet();
  
  SortedSet<T> toSortedSet(Predicate<? super T> predicate);
  
  SortedSet<T> toSortedSet();
  
  List<T> toList(Predicate<? super T> predicate);
  
  List<T> toList();
  
  List<T> toList(int maxElements);
  
  <K> Map<K, T> toMap(ThrowingFunction<? super T, ? extends K> keyFn);
  
  <K, V> Map<K, V> toMap(
          ThrowingFunction<? super T, ? extends K> keyFn,
          ThrowingFunction<? super T, ? extends V> valueFn);
  
  <K extends Comparable<?>> SortedMap<K, T> toSortedMap(ThrowingFunction<? super T, ? extends K> keyFn);
  
  <K, V> SortedMap<K, V> toSortedMap(
          ThrowingFunction<? super T, ? extends K> keyFn,
          ThrowingFunction<? super T, ? extends V> valueFn);
  
  void print();
  
  void printTo(OutputStream out);
  
  void printTo(PrintStream out);
  
  void printTo(Writer writer);
  
  void print(ThrowingFunction<? super T, ? extends String> fn);
}
