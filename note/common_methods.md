# String

1. check if char is digit

   + `Character.isDigit( c )`
   + `c >= '0' && c <= '9'`

2. conversion

   + char array to string: `String.valueOf(charArr)`
   + Stirng to Integer: `Integer.parseInt(str)`
   + Integer to String: `Integer.toString(int)`
   + char to int: `(int)c - '0'` or `String.valueOf(c)`

3. Naive way to convert String to number

   int is from $-2^{31}$ to $2^{31} - 1$, which is -2147483648 to 2147483647, we need to check **overflow**

   ```java
   String = "-1234";
   int sign  = 1; // default positive
   char[] arr = string.toCharArray();
   int res = 0;
   int max = Integer.MAX_VALUE;
   int min = Integer.MIN_VALUE;
   for( char c : arr){
     if(res > max / 10 || (res == max / 10 && (c - '0') > max % 10)){
       //overflow
       return sign == 1 ? max : min;
     }else{
       res += res * 10 + (int)(c - '0');
     }
     return sign * res;
     
   }
   ```

   

   ```java
   
   ```

   