The Stack is a **LIFO (Last-In, First-Out)** data structure. In DSA interviews, a stack is the perfect tool whenever a problem requires you to remember previous states, but you only ever need to interact with the *most recently seen* state first.



If you encounter a problem that requires matching pairs, evaluating nested structures, or finding the "next closest" item that meets a certain condition, you should immediately think of a stack.

Here are the definitive patterns of DSA problems that can be solved using a Stack.

### 1. The Monotonic Stack (The Most Common Interview Pattern)
This is the most critical stack pattern to master for advanced interviews. A monotonic stack is simply a stack whose elements are always sorted (either strictly increasing or strictly decreasing).
* **How to identify it:** The problem asks you to find the **"next greater"** or **"next smaller"** element for every item in an array, or it asks you to calculate spans/areas based on peaks and valleys.
* **How it works:** You iterate through the array. If the current element breaks the monotonic property (e.g., you are keeping a decreasing stack, but the new element is larger than the top of the stack), you pop elements off the stack until the property is restored, calculating your answer for the popped elements along the way.
* **Classic Problems:**
    * *Next Greater Element* (Find the first element to the right that is larger)
    * *Daily Temperatures* (How many days until a warmer day)
    * *Largest Rectangle in Histogram*
    * *Trapping Rain Water*
    * *Online Stock Span*



### 2. Nested Structures & Matching Pairs
Because a stack natively handles "inside-out" resolution, it is the standard tool for parsing strings that have nested boundaries or pairs that must be matched and closed in the correct order.
* **How to identify it:** The problem involves brackets, parentheses, HTML tags, or evaluating nested string formats.
* **How it works:** When you see an "opening" character, push it to the stack. When you see a "closing" character, pop the top of the stack and verify they match. If the stack is empty at the end, the string is valid.
* **Classic Problems:**
    * *Valid Parentheses*
    * *Minimum Add to Make Parentheses Valid*
    * *Decode String* (e.g., decoding `3[a2[c]]` into `accaccacc`)

### 3. String Parsing & Adjacent Removals
Stacks are excellent for string manipulation problems where the current character you are looking at might dictate that you delete a character you just saw a moment ago.
* **How to identify it:** The problem asks you to remove adjacent duplicates, delete characters based on a condition (like backspaces), or simplify a path.
* **How it works:** Push characters to the stack one by one. If the current character and the top of the stack trigger a deletion rule, pop the stack and ignore the current character.
* **Classic Problems:**
    * *Remove All Adjacent Duplicates In String* (e.g., transforming `abbaca` to `ca`)
    * *Backspace String Compare*
    * *Simplify Path* (Converting `/a/./b/../../c/` to `/c`)

### 4. Expression Evaluation
Stacks are the foundational data structure for how compilers evaluate mathematical expressions.
* **How to identify it:** The problem asks you to calculate the result of a mathematical string or convert between different notations (Infix, Postfix, Prefix).
* **How it works:** For Postfix (Reverse Polish Notation), you push numbers to the stack. When you see an operator (`+`, `-`, `*`), you pop the top two numbers, apply the operator, and push the result back onto the stack.
* **Classic Problems:**
    * *Evaluate Reverse Polish Notation*
    * *Basic Calculator (I, II, III)*

### 5. Simulating Recursion (Iterative DFS)
Any recursive algorithm runs on the CPU's Call Stack. Therefore, any recursive algorithm can be rewritten iteratively by managing your own explicit Stack data structure.
* **How to identify it:** You need to perform a Depth-First Search (DFS) on a Graph or a Tree, but the recursive approach causes a `StackOverflowError` due to extreme depth, or the interviewer explicitly asks for an iterative solution.
* **How it works:** Push the root node to the stack. While the stack is not empty, pop a node, process it, and push its children to the stack.
* **Classic Problems:**
    * *Binary Tree Inorder/Preorder/Postorder Traversal* (Iterative versions)
    * *Number of Islands* (Using iterative DFS instead of recursive)

### 6. Stack Design Problems
Sometimes the problem isn't about *using* a stack, but *modifying* how a stack works under the hood to achieve `O(1)` time complexity for specific operations.
* **How to identify it:** The problem asks you to build a custom stack class with extra features.
* **How it works:** Usually involves maintaining two stacks in parallel, or storing tuples `(value, current_min)` inside a single stack.
* **Classic Problems:**
    * *Min Stack* (Design a stack that supports `push`, `pop`, `top`, and retrieving the minimum element in constant time)
    * *Implement Queue using Stacks*