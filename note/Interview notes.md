# Interview notes

## Need to consolidate

### Java I/O operation (file)

+ **Stream**: byte based pipe
+ **Reader/Writer**: specifically for reading char streams
    + `FileReader fr = new FileReader("../../x.txt")`
    + `FileWriter fw = new FileWriter("path", boolean append)`
+ **Buffered**: store a chunk of the file into buffer, make reading faster
    + `BufferedReader br =  new BufferedReader(new FileReader(file))  `
    + `BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))`

+ `flush()`, flush everything in the buffer to the destination, if use `FileWriter`, flush has no affect, since `FileWriter` write to the file directly.

### Java http request

[code](https://leetcode.com/playground/bjooYEWN)

```java
URL url = new URL(s);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
// set up request properties
connection.setRequestMethod("GET");
connection.setConnectTimeout(5000);
connection.setReadTimeout(5000);
BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
```



1. Multi threading

### exceptions

[code](https://leetcode.com/playground/3JvefKEY)

+ `try/catch/finally`

```java
try{
	// your code
}catch(Exception e1){
	// catch exception
}catch(Exception e2){
    // catch another exception
}finally{
    // no matter what, finally will run, even though
    // there is a return statememnt
}
```

+ `throws/throw`

`Throws` is a keyword is used in a method signature and declares which exceptions can be thrown from a method.  Questions is we can use `try/catch` block to handle those exceptions, why do we need `throws`. What if we have several methods that could throw same exceptions, then we need to use `try/catch` in each methods, which is tedious.

then we can declare what exceptions could be thrown for each methods by using `throws` keyword, and handle it when we call those functions. <u>Please note that `throws` checked exception **must** be handle when we call the methods</u>, java does not verify unchecked Exception

```java
public void function1 ()throws ArithmeticException, NullPointerException{
    
}

public void function2 ()throws ArithmeticException, NullPointerException{
    
}

public void function3 ()throws NullPointerException{
    
}

public static void main(){
    try{
        function1();
        function2();
    }catch{
        
    }
    // below code is valid, java does not verify unchecked exceptions
    try{
        function3();
    }catch(ArithmeticException e){
        ....
    }
}
```

### Multi-Threading

ReentrantLock



## Interview Track



| Company  | Round             | Note                                                         |
| -------- | ----------------- | ------------------------------------------------------------ |
| Mixpanel | Round1,1-28, Fail | Asked Java IO API, questions: read last 10 lines of large file |
|          |                   |                                                              |
|          |                   |                                                              |

