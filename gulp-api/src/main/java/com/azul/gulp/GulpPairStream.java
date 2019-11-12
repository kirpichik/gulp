package com.azul.gulp;

import java.util.Map;

public interface GulpPairStream<F, S>
  extends GulpStreamExtension<GulpPairStream<F, S>, Pair<F, S>>
{
  GulpPairStream<F, S> filter(PairPredicate<? super F, ? super S> predicate);
  
  GulpPairStream<F, S> filterFirst(Predicate<? super F> firstPredicate);
  
  GulpPairStream<F, S> filterSecond(Predicate<? super S> secondPredicate);
  
  <R> GulpStream<R> map(
          PairThrowingFunction<? super F, ? super S, ? extends R> mapFn);
  
  Map<F, S> toMap();
  
  void forEach(PairProcessor<? super F, ? super S> pairProcessor);
}
