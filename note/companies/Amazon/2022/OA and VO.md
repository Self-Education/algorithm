

1. [370. Range Addition](https://leetcode.com/problems/range-addition)

2. find good camping days

3. armor Game (first blood)

4. min stock price difference

5. [group movie](https://leetcode.com/discuss/interview-question/1735633/Amazon-OA-2022/1246722)

6. pascal encoding 

    ![image-20220228105253673](images/image-20220228105253673.png)

    

7. Maximum Quality, packets and channel **???**

    You are given a list of packets of varying sizes and there are `n` channels.

    

    - Each of the `n` channel must have a single packet
    - Each packet can only be on a single channel

    

    The quality of a channel is described as the `median` of the packet sizes on that channel. The total quality is defined as sum of the quality of all channels (round to integer in case of float). Given the `packets []int32` and `channels int32` find the maximum quality.

    **Example 1:**

    

    ```
    packets := []int32{1, 2, 3, 4, 5}
    channels := 2
    
    // Explaination: If packet {1, 2, 3, 4} is sent to channel 1, the median of that channel would be 2.5.
    //               If packet {5} is sent to channel 2 its median would be 5. 
    //               Total quality would be 2.5 + 5 = 7.5 ~ 8
    answer := 8
    ```

    

    **Example 2:**

    

    ```
    packets := []int32{5, 2, 2, 1, 5, 3}
    channels := 2
    
    // Explaination: Channel 1: {2, 2, 1, 3} (median: 2)
    //               Channel 2: {5, 5}       (median: 5)
    //               Total Quality : 2 + 5 = 7
    
    // Explaination 2: Channel 1: {5, 2, 2, 1, 3} (median: 2)
    //                 Channel 2: {5}             (median: 5)
    //                 Total Quality : 2 + 5 = 7
    answer := 7
    ```

8. [828. Count Unique Characters of All Substrings of a Given String](https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string)

9. decreasing ratings

10. min swap to group 1s and 0s

11. ##### Max deviation among all substrings ??? [link](https://leetcode.com/discuss/interview-question/1742621/Amazon-or-OA-or-Max-deviation-among-all-substrings)

      1. https://www.1point3acres.com/bbs/thread-856338-1-1.html
      1. https://leetcode.com/discuss/interview-question/1742621/Amazon-or-OA-or-Max-dev&amp;#8205;&amp;#8204;&amp;#8205;&amp;#8204;&amp;#8204;&amp;#8205;&amp;#8205;&amp;#8204;&amp;#8205;&amp;#8205;&amp;#8204;&amp;#8205;&amp;#8205;&amp;#8205;&amp;#8204;&amp;#8204;&amp;#8205;&amp;#8205;&amp;#8204;iation-among-all-substrings

12. ##### Max Length of Valid Server Cluster [link](https://www.1point3acres.com/bbs/thread-856589-1-1.html)

13. subarray imbalance **????** [link](https://www.1point3acres.com/bbs/thread-856918-1-1.html)

14. shipment sum(max) - sum(min)

15. [灰度](https://www.1point3acres.com/bbs/thread-842588-1-1.html)**？？？？**

16. given array, move prime to the left and no-prime to the right

17. given a integer, remove one 5 to get max

18. [partition parenthese array](https://leetcode.com/discuss/interview-question/1332412/amazon-online-assessment-question)

      ![image-20220228171051385](images/image-20220228171051385.png)

19. ##### [K best combo / Find K maximum Priority](https://leetcode.com/discuss/interview-question/1625460/amazon-oa-find-k-maximum-priority)

20. [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures)

21. aggregate temperature

      ![62152fcz899mkwxv3sp0f](images/62152fcz899mkwxv3sp0f.jpg)

22. parcels and trucks

      ![62156hedsxwfqkasmvxvd](images/62156hedsxwfqkasmvxvd.jpg)

23. [926. Flip String to Monotone Increasing](https://leetcode.com/problems/flip-string-to-monotone-increasing)

24. giving a string with parentheses, return the string after removing the invalid parentheses.   a)bc(de))f -> abc(de)f

25. [527. Word Abbreviation](https://leetcode.com/problems/word-abbreviation)

26. kindle page mark (three pages)

      ![image-20220228171830362](images/image-20220228171830362.png)

28. [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces)

29. [680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

30. [1268. Search Suggestions System](https://leetcode.com/problems/search-suggestions-system)

30. discounted prices

     ![220700h8qe686fftf8fug8](images/220700h8qe686fftf8fug8.png)

     The product array element are in the form ['price', 'tag1', 'tag2'.....tagm-1.] There maybe zero or more discount codes associated with the product.Discount tags in product array maybe 'EMPTY' which is the same as NULL value.The Discount Array elements are in form['tag', 'type', 'amount']

     If a privileged member buys product 1 listed at a price of 10 with two discount available:

     Under discount d0 of type 1 , the discounted price is 10- 10*0.27 = 7.30, round 7. Under discount of d1 of type 2, the discounted price price is 10-5 = 5

     The price to purchase the product :

     1 is the lowest of the two, or 5 in this case.

     The second product is priced at 15 because there are no discounts available

     The third product is priced at 20 .Using discount tag d1 of type 2, the discount price is 20-5 = 15

     the total price to purchase the three item is 5+15+15 = 35.

     *NOTES: Not all items will have the Maximum number of tags. Empty tags may just not exist in input or they maybe filled with the string Empty.These are equivalent as demonstrated in the example above*

     

     **FUNCTION DESCRIPTION**

     

     Complete the function. Find *LowestPrice* in the editor below.

     

     [string] products[n][m]: a 2D array of product descriptors as strings:price followed up by up to m-1 discount tags.
     [string] discounts[3] : a 2D array of tag descriptors as string: tag, type amount. int: the total amount paid in for all listed products , discounts to privileged members pricing.

     **Constraints** 1<n, m ,d<1000 // meant less or equal to.

31. Maximize invest profit 

     https://leetcode.com/discuss/interview-question/1321204/efficient-harvest-faang-oa-question-2021

     ![220729pqttqgsjz5sqwn5d](images/220729pqttqgsjz5sqwn5d.png)

32. merge package to get the heaviest package

33. Routers![213006ul4b6xcp7szf4pfs](images/213006ul4b6xcp7szf4pfs.png)

34. Minimize Memory

35. find password strength

37. [Sort Order](https://leetcode.com/discuss/interview-question/1261316/amazon-oa-sde-1-new-grad-2021-batch-india)