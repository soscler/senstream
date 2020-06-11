Generics in Java Event Driven Programming.

Why do you use (and not use) generics (in java) ? Example of event driven programming.

My question is more about conception choices than the actual implementation itself.
In your experience, which one of Event interface implementation would you prefer ? why ?
If you prefer another implementation, please add it in your answer.

```java
// The most important classes and interfaces to look at are the `*Events`.

public interface Metadata {
}

public class SensorMetadata extends Metadata {
}

public interface Data<T> {
    T value();
}

public class SensorData extends Data<Double> {
}

/** (1)
* With this, I'll lose specific information about the data and the metadata fields.
* One way to get those specific information back will imply casting
* Arguably, I don't like casting objects that I wrote the implementation myself.
*/
public interface Event { // Event
    Metadata metadata();
    Metadata from();
    Metadata to();
    Data<?> data();
}

/** (2)
* I have control of the data type that this event hold
*/
public interface Event<T extends Data<?>> { // Event<T>
    Metadata metadata();
    Metadata from();
    Metadata to();
    T data();
}

/** (3)
* I can have specific information about the event metadata and the data
*/
public interface Event<T, U extends Data<?>> { // Event<T, U>
    T metadata();
    Metadata from();
    Metadata to();
    U data();
}

/** (4)
* This last one is what I call a generic hell ;)
* But yeah, it gives all the control one may need.
*/
public interface Event<T, U extends Data<V>, V> { // Event<T, U, V>
    T metadata();
    Metadata from();
    Metadata to();
    U data();
}

public class SensorEvent implements Event {
}

public class SensorEvent implements Event<SensorData> {
}

public class SensorEvent implements Event<SensorMetadata, SensorData> {
}

public class GenericHellEvent implements Event<SensorMetadata, Double, SensorData> {
}
```

**Any implementation choice I choose will impact have a huge impact on the system.
I have other classes like Listener / Observer and Observable that all depend on the Event class**

P.S.: English is not my first language.
