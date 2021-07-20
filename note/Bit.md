## Set range of bits as 1

```java
range = (((1 << (l - 1)) - 1) ^ ((1 << (r)) - 1));
```



### check bit

`& 1`  will check if origin bit is 1 or not, `0010 & (1 << 1)` -> `0010 & 0010 = 0010`

`| 1` will set bit, `0011 | 0010 = 0010`

`& 0` will set bit into 0

`| 0` will check bit.

`n >> index& 1` will check bit at index, `0100 >> 2 & 1` --> `0001 & 0001 = 0001 = 1`

### Gray code

1. #### **Convert Binary number to Gray number**: 

   + keep the **Most Significant Bit** (MSB);
   + XOR each pair of adjcent bits

   ##### **<u>Example: convert A= `110111`,</u>**

   + the most left (5th from right side) bit `1` is the MSB, the **Res** = `1 _ _ _ _ _ `
   + then `A[5] ^ A[4] = 1 ^ 1 = 0`,  **Res** = `1 0 _ _ _ _ `
   + `A[4] ^ A[3] = 1 ^ 0 = 1`,  **Res** = `1 0 1 _ _ _ `
   + `A[3] ^ A[2] = 0 ^ 1 = 1`,  **Res** = `1 0 1 1 _ _ `
   + `A[2] ^ A[1] = 1 ^ 1 = 0`,  **Res** = `1 0 1 1 0 _ `
   + `A[1] ^ A[0] = 1 ^ 1 = 0`,  **Res** = `1 0 1 1 0 0`

   ##### **<u>formula</u>**

   ​	we noticed that `A[i] ^ A[i - 1]`, then formula is `A ^ A >> 1`

   ```java
   int binary2Gray(int n){
       return n ^ n >> 1;
   }
   ```

   

2. #### Convert Gray to Binary

   + keep the MSB
   + XOR the MSB with the next bit, get the new bit, lets call it `nb`
   + XOR the `nb` with the next bit, get new `nb`
   + keep doing until the end

```java
int gray2Binary(int n){
    int mask = n >> 1;
    while(mask > 0){
        n = n ^ mask;
        mask = mask >> 1;
    }
    return n;
}
```

## Use bitmask as memo

[464. Can I Win -- Medium](https://leetcode.com/problems/can-i-win/)

