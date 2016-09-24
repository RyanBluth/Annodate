# Annodate
A Java Object Validator

Annodate aims to be a simple object validator throught the use of annotations.

```java 
// Example usage
public class Example{

  @MaxLength(10)
  @NotNull
  String username;

  @MinLength(10)  
  @NotNull
  String password;

  @NotNull  
  String name;
}

public static void main(String[] args) {
  Example ex = new Example();
  ex.setUserName( "user" );
  ex.setPassword( "12345678910" );
  List<AnnodateError) errors = Annodate.validate( ex );
  // errors will have the validation errors for name and for username
}
