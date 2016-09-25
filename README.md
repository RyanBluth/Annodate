# Annodate
A Java Object Validator

Annodate aims to be a simple object validator throught the use of annotations.

### Current Annotations 

| Annotation    | Validation                                                                                                                                |
|---------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| @NotNull      | Validates that the value is not null                                                                                                      |
| @MaxLength    | Validates that the object does not have a length greater than the value provided. Collections, Strings and Arrays are supported           |
| @MinLength    | Validates that the object does not have a length less than the value provided. Collections, Strings and Arrays are supported              |
| @Email        | Validates that the string representation of the object is a valid email address                                                           |
| @MatchRegex   | Validates that the string representation of the object matches the provided regex value                                                   |
| @OneOf        | Validates that the string representation of the object matches one of the provided values|
| @MatchPattern | Validates that the string representation of the object matches the provided pattern. |

###MatchPattern Tokens 
| Character | Matches                |
|-----------|------------------------|
| #         | Numeric                |
| a         | Lowercase Letter       |
| A         | Uppercase Letter       |
| @         | Anycase Letter         |
| $         | Any Character          |
| Other     | Exactly That Character |

### Basic Example

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
  
  @MatchPattern("(###) ###-####")
  String phone = "(222) 123-1234";
}

public static void main(String[] args) {
  Example ex = new Example();
  ex.setUserName( "user" );
  ex.setPassword( "12345678910" );
  List<AnnodateError> errors = Annodate.validate( ex );
  // errors will have the validation errors for name and for username
}
