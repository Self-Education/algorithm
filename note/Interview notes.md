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

[youtuber](https://www.youtube.com/channel/UCiz26UeGvcTy4_M3Zhgk7FQ)

ReentrantLock

https://aaronice.gitbook.io/system-design/distributed-systems/producer-and-consumer

#### Producer - Consumer

```java
// "static void main" must be defined in a public class.
class Producer implements Runnable{
    private final int id;
    private BlockingQueue<Integer> sharedQueue;
    public Producer(int id, BlockingQueue<Integer> sharedQueue){
        this.id = id;
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(100);
                System.out.println("Produced " + i);
                sharedQueue.put(i);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private final int id;
    private BlockingQueue<Integer> sharedQueue;
    private Random rand = new Random();
    public Consumer(int id, BlockingQueue<Integer> sharedQueue){
        this.id = id;
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(500);
                int r = rand.nextInt(10);
                if(r == 1){
                    System.out.println("Consumer " + id + " Consumed " + sharedQueue.take() + "queue size is " + sharedQueue.size());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(5);
        Thread p1 = new Thread(new Producer(0, sharedQueue));
        Thread c1 = new Thread(new Consumer(1, sharedQueue));
        Thread c2 = new Thread(new Consumer(2, sharedQueue));
        Thread c3 = new Thread(new Consumer(3, sharedQueue));
        
        p1.start();
        c1.start();
        c2.start();
        c3.start();
        
        try{
            p1.join();
            c1.join();
            c2.join();
            c3.join();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```



## Interview Track

4: no idea

5: have idea, finish 60% implementation

6: have concept, finish 80% implementation or get a brute force solution

7: get a working solution, but small bug or did not finish the follow up

8: get a working solution, no bug and answered follow up

| Company  | Round        | Note                                                         |
| -------- | ------------ | ------------------------------------------------------------ |
| Mixpanel | Round1,1-28  | 6, Asked Java IO API, questions: read last 10 lines of large file |
|          | round-2 1-11 | 8, work experience                                           |
|          | round-3 1-11 | 5, flatten nested list, without precomputation               |
|          | round-4 2-14 | 7, poker                                                     |
|          | round-5 2-14 | 7, directory BFS, follow up: content is large                |

