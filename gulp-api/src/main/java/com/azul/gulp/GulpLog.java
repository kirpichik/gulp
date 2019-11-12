package com.azul.gulp;

public interface GulpLog {
  GulpLog prefetch();
  
  <T> Result<T> get(final Class<T> analysis);
  
  @SuppressWarnings("rawtypes")
  Result process(final GenericProcessor processor);
  
  @SuppressWarnings("rawtypes")
  Result process(final LogProcessor processor);
  
  @SuppressWarnings("rawtypes")
  Result process(final LogProcessor.Provider processor);
  
  <R> Result<R> analyze(final PackagedAnalyzer<R> analyzer);
  
  <R> Result<R> analyze(final GenericAnalyzer<R> analyzer);
  
  @Deprecated
  <R> R analyzeAndGet(final GenericAnalyzer<R> analyzer);
  
  default <T> void forEach(
          final Class<? extends T> dataClass,
          final Processor<? super T> processor)
  {
    this.select(dataClass).forEach(processor);
  }
  
  <T> GulpLogStream<T> select(final Class<? extends T> dataClass);
  
  <F, S> GulpPairStream<F, S> join(
          final Class<? extends F> firstDataClass,
          final Class<? extends S> secondDataClass,
          final Predicate<? super Pair<? super F, ? super S>> predicateFn);
  
  <F, S> GulpPairStream<F, S> join(
          final Class<? extends F> firstDataClass,
          final Class<? extends S> secondDataClass,
          final PairPredicate<? super F, ? super S> predicateFn);
  
  <F, S, K> GulpPairStream<F, S> join(
          final Class<? extends F> firstDataClass,
          final ThrowingFunction<? super F, ? extends K> firstKeyFn,
          final Class<? extends S> secondDataClass,
          final ThrowingFunction<? super S, ? extends K> secondKeyFn);

  <F, S> GulpPairStream<F, S> join(
          final Class<? extends F> firstDataClass,
          final Class<? extends S> secondDataClass);
  
  <T> GulpLog normalize(
          final Class<T> type,
          final Normalizer<T> normalizer);
  
  <T, V> GulpLog enrich(
          final Class<T> inputType,
          final Class<V> enrichmentType,
          final Enricher<? super T, ? extends V> enricher);
  
  GulpLog preprocess(GenericProcessor preprocessor);
}
