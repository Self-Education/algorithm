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

