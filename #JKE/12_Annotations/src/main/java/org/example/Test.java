package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Definiere eine Annotation (kein Interface !) namens Test
// diese Annotation ist zur Laufzeit vorhanden und per Reflection 
// abfragbar
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
