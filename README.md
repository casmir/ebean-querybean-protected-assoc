Ebean-querybean generator (>=14.6.0 onwards)

Issue introduced after fixing: https://github.com/ebean-orm/ebean/issues/3455
IllegalAccessError is thrown when using @EmbeddedId with a class located in another package.

```java
package org.example.content.model;

import org.example.common.embedded.EmbeddableId;

@Entity
@Table(name="product_history")
public class ContentWithEmbeddedId extends Model {

    @EmbeddedId
    private EmbeddableId embeddableId;
}
```
```java
package org.example.common.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class EmbeddableId {

    @Column(length = 19)
    private Long id;

    @Column(length = 50)
    private String other;
}
```

Usage:

run:  Main in `org.example.Main`

```
java.lang.IllegalAccessError: class org.example.content.model.query.QContentWithEmbeddedId tried to access protected method 'void org.example.common.embedded.query.QEmbeddableId$Assoc.<init>(java.lang.String, java.lang.Object)' (org.example.content.model.query.QContentWithEmbeddedId and org.example.common.embedded.query.QEmbeddableId$Assoc are in unnamed module of loader 'app')
	at org.example.content.model.query.QContentWithEmbeddedId.<init>(QContentWithEmbeddedId.java:3)
	at org.example.content.model.query.QContentWithEmbeddedId.<clinit>(QContentWithEmbeddedId.java:16)
```


Caused within: querybean-generator/src/main/java/io/ebean/querybean/generator/SimpleQueryBeanWriter.java 
```java
writeAssocBeanConstructor("protected Assoc");
```