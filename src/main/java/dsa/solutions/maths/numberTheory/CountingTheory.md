# Counting Theory

## 1. Fundamental Principles of Counting

### ✅ A. Addition Principle

If there are *m* ways to do one thing and *n* ways to do another, and these events are mutually exclusive (cannot happen together), then the total number of ways to do either one is:

**m + n**

✅ **Example:**  
You can travel to work by bus (3 routes) or train (2 routes). The total number of ways to commute is:

**3 + 2 = 5**

---

### ✅ B. Multiplication Principle

If there are *m* ways to do one thing and *n* ways to do another, and both events must happen together, then the total number of ways is:

**m × n**

✅ **Example:**  
You have **4 shirts** and **3 pants**. The number of different outfits you can wear is:

**4 × 3 = 12**

---

## 2. Permutations (Ordered Arrangements)

### ✅ A. Permutations without Repetition

If you have *n* objects and you want to arrange *r* of them, the number of ways is:

**P(n, r) = n! / (n-r)!**

✅ **Example:**  
How many ways can you arrange 3 letters from "ABCDE"?

**P(5,3) = 5! / (5-3)! = 5! / 2! = (5 × 4 × 3 × 2!) / 2! = 60**

---

### ✅ B. Permutations with Repetition

If some elements are identical, the formula is:

**n! / (k₁! k₂! ... kₘ!)**

✅ **Example:**  
How many ways can you arrange "AAB"?

**3! / (2!1!) = 6 / 2 = 3**  
(AAB, ABA, BAA)

---

## 3. Combinations (Choosing without Order)

### ✅ A. Formula for Combinations

**C(n, r) = n! / [r!(n-r)!]**

✅ **Example:**  
How many ways can you select 3 students from a group of 5?

**C(5,3) = 5! / (3!(5-3)!) = 5! / (3!2!) = (5 × 4) / (2 × 1) = 10**

---

## 4. Binomial Theorem

The expansion of **(a + b)ⁿ** follows:

**(a + b)ⁿ = Σ C(n, r) aⁿ⁻ʳ bʳ**

✅ **Example:**  
Expand **(x + y)³**

**(x + y)³ = C(3,0)x³ + C(3,1)x²y + C(3,2)xy² + C(3,3)y³**

**= 1x³ + 3x²y + 3xy² + 1y³**

---

## 5. Special Counting Techniques

### ✅ A. Inclusion-Exclusion Principle

For two sets *A* and *B*:

**|A ∪ B| = |A| + |B| - |A ∩ B|**

✅ **Example:**  
In a class of 50 students:

- 30 like math
- 25 like science
- 10 like both

Students who like at least one subject:

**30 + 25 - 10 = 45**

---

### ✅ B. Stars and Bars (Distributing Objects into Groups)

If you want to distribute *n* identical objects into *k* distinct groups, the formula is:

**C(n+k-1, k-1)**

✅ **Example:**  
How many ways to distribute 5 chocolates among 3 kids?

**C(5+3-1, 3-1) = C(7,2) = 7! / (2!5!) = (7 × 6) / 2 = 21**

---

## 6. Advanced Topics

### ✅ A. Derangements

A derangement is a permutation where no element appears in its original position. The formula for derangements of *n* objects (*!n*) is:

**!n = n! × Σ (-1)ᵏ / k!**

✅ **Example:**  
If 4 people put their hats in a box and each picks one at random, the number of ways none of them gets their own hat is:

**!4 = 4!(1 - 1/1! + 1/2! - 1/3! + 1/4!) = 9**

---

### ✅ B. Pigeonhole Principle

If *n* objects are placed into *m* boxes and *n > m*, then at least one box must contain more than one object.

✅ **Example:**  
If 6 socks are placed into 5 drawers, at least one drawer must contain **at least 2 socks**.

---

### ✅ C. Generating Functions

Generating functions are used in combinatorial proofs and solving recurrence relations. A basic generating function is:

**G(x) = Σ aₙxⁿ**

✅ **Example:**  
The generating function for the sequence {1, 1, 1, 1, ...} is:

**G(x) = 1 / (1 - x)**

---

### ✅ D. Catalan Numbers

Catalan numbers appear in many counting problems, including balanced parentheses, binary trees, and polygon triangulations. The formula is:

**Cₙ = (1 / (n + 1)) × C(2n, n) = (2n)! / [(n + 1)! n!]**

✅ **Example:** The number of ways to correctly match n pairs of parentheses:

**C₃ = (2 × 3)! / [(3 + 1)! 3!] = 5**

#### 🔹 Applications of Catalan Numbers

1. **Balanced Parentheses**
    - You have *n* pairs of parentheses.
    - You need to ensure every opening `(` has a matching closing `)`.
    - The sequence should never have more closing brackets before an opening bracket.
    - The number of valid ways to arrange them is given by **Cₙ**.

   ✅ **Example:** For *n = 3*:  
   ((())), (()()), (())(), ()(()), ()()() → 5 valid sequences.

2. **Binary Trees**
    - The number of distinct binary trees that can be made with *n* labeled nodes is **Cₙ**.
    - Trees must be structured such that each node has at most two children.

   ✅ **Example:** For *n = 3*, possible binary trees are 5.

3. **Triangulations of Polygons**
    - Given an *n*-sided polygon, the number of ways to divide it into triangles using non-crossing diagonals is **Cₙ-2**.

   ✅ **Example:** A 5-sided pentagon (*n=5*) can be divided into triangles in **C₃ = 5** ways.

4. **Mountain Ranges**
    - Counting valid ways to form mountain-like paths with *n* up and *n* down steps.
    - Each step up (U) must be followed by a down (D), ensuring the path never goes below the starting point.

   ✅ **Example:** For *n = 3*, valid sequences:  
   UUUDDD, UUDUDD, UUDDUD, UDUUDD, UDUDUD → 5 valid paths.

---

