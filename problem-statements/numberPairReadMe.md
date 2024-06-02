###Problem

Given a collection of Numbers, find out whether all numbers in collection are in pair.

e.g. Given input array [1, 2, 3, 10, 4, 3, 10, 2, 4, 1, -1, -1, -1, -1]  result should be true

##### if size of array is odd then result will be false

> when size of array is even need to count each item
>- count of 1 is 2
>- count of 2 is 2 
>- count of 3 is 2
>- count of 10 is 2
>- count of 4 is 2
>- count of 1 is 2
>- count of -1 is 4
>> All number's count is even, so they are all in pair, and result is true

e.g. Given input array [1, 10, 4, 3, 10, 2, 4, 1]  result should be **false**

> count of each number present in array
>- count of 1 is 2 (even) 
>- count of 10 is 2 (even)
>- count of 4 is 2 (even)
>- count of 3 is 1 (odd)
>- count of 2 is 1 (odd)
>> Number 2 and 3 are odd so result is false





