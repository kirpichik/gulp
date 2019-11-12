package com.azul.gulp.nexus;

import com.azul.gulp.ConfigurationException;
import com.azul.gulp.inject.InjectionContext;
import com.azul.gulp.reflect.AnnotationFinder;

public interface Nexus extends InjectionContext, AnnotationFinder {
  void require(final Class<?>... types)
    throws ConfigurationException;
  
  boolean request(final Class<?>... types)
    throws ConfigurationException;
  
  // normalize(type, ...) implies require(type)
  <T> void normalize(
          final Class<T> type,
          final NexusNormalizer<T> normalizer);
  
  // Calling handle(type, ...) implies require(type)
  <T> void handle(
          final Class<T> type,
          final NexusHandler<? super T> handler)
    throws ConfigurationException;
  
  // Calling optionalHandle(type, ...) implies request(type)
  <T> void handleOptional(
          final Class<T> type,
          final NexusHandler<? super T> handler)
    throws ConfigurationException;
  
  <T> void remove(
          final Class<T> type,
          final NexusHandler<? super T> handler);
  
  void handle(final FlexNexusHandler handler);
  
  void handleOptional(final FlexNexusHandler handler);
  
  void remove(final FlexNexusHandler handler);
  
  <T> void unhandle(
          final Class<T> type,
          final NexusUnhandler<? super T> unhandler)
    throws ConfigurationException;
  
  <T> void remove(
          final Class<T> type,
          final NexusUnhandler<? super T> unhandler);


  void produces(final Class<?>... types);
  
  // Calling getEmitter(type) implies produces(type)
  <T> NexusEmitter<T> getEmitter(final Class<T> type);
  
  <T> NexusHandledMarker<T> getMarker(final Class<T> type);
  
  void connect(final Object obj);
}
