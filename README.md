# QQ 
## Elaina Chung, YuQi Wu, Rihui Zheng

## Our Method Selections:

add(E e) - adds element e to the back of the deque

addFirst(E e) - adds element e to the beginning of deque

remove() - removes the last element of deque

remove(E e) - removes the first occurence of e

removeFirst() - removes the first element of deque

size() - returns the number of elements in deque

contains(Object o) - returns whether or not object o is in the deque

getFirst() - returns first element in deque without removing

getLast() - returns last element in deque without removing

clear() - clears the deque

isEmpty() - returns whether the deque is empty


## Doubly Linked Nodes

We have decided to use a doubly linked nodes because we want more practice with nodes, and using a doubly linked node is helpful for certain methods. For example, add, addFirst, remove, removeFirst, size, getFirst, clear() and getLast are all O(1) using a doubly linked node.


## Fixed Bugs

- Changed == to equals() 
- Made toString able to process more than just String QQ
- Fixed addFirst()'s inability to process QQ with the size of 0
