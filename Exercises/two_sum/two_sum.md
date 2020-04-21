Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].




---------------------------------------------------
--------------------------------------------------

(rev == INT_MAX / 10 && pop > 7)
(rev == INT_MIN / 10 && pop < -8)

These two are only possible when integer x is either 8463847412 (first digit greater than 7) or -9463847412 (first digit less than -8)
and it is not possible for x to hold these values since they overflow.
(Except if we were using 64 bit integer and performing reverse over the range of 32 bit integer only, which is not the case here)

Moreover, suppose rev == INT_MAX/10 and pop is 7 then rev is 2147483647 which means
original x must be equal to 7463847412 which is not possible for x to hold.
Similarly, rev == INT_MAX/10 and pop is -8 then rev is -2147483648 which means
original x must be equal to -8463847412 which again is not possible for x to hold.
Therefore, the condition given in solution is wrong. It should be:

if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 1)) return 0;
if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -1)) return 0;

We can also write:

(rev > INT_MAX/10 || rev < INT_MIN/10) return 0;

in place of two conditions, checking other condition is unnecessary.