## Reflection API

- Used to know the capabilities of classes and methods during runtime.
- Reflection API gices access to metadata, which data about classes and objects within JVM.

### `java.lang.Class`

- Not present inside the `java.lang.reflect` package, but is an essential package to understand.
- This is the backbone of reflection. Find and load any class.
- Whenever a class gets loaded by JVM, during that time, a `Class<class>` object gets generated for the class.
- Three ways to instantiate a `Class<class>` object:
  1. `Class::forName`: Takes in a `String` which is the fully qualified class name.
     - `Class.forName("java.lang.String")` will create a `Class<String>` object.
