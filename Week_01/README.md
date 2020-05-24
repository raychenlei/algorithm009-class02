## Week01-学习笔记

### 数组

* 可以随机访问，时间复杂度O(1)
* 删除和添加的复杂度O(n)
* ArrayList中add(int index, E element)方法在指定的index处插入元素，需要进行大量的数组copy，效率较低

### 链表

* 常见的链表：单项链表、双向链表、循环链表

* 链表的简单实现

  * ```java
    class LinkedList { 
        Node head; // head of list 
      
        /* Linked list Node*/
        class Node { 
            int data; 
            Node next; 
      
            // Constructor to create a new node 
            // Next is by default initialized 
            // as null 
            Node(int d) { data = d; } 
        } 
    }
    ```

* Java中的实现

  * ```java
    private static class Node<E> {
      E item;
      Node<E> next;
      Node<E> prev;
    
      Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
      }
    }
    //Java中LinkedList的实现是双向链表
    ```

* 链表的时间复杂度
  * 追加、插入、删除操作都是O(1)
  * 查找的操作是O(n)



### 跳表 SkipList

* 有序链表+多级索引 = 跳表
* 使用了升维的思想，用空间换时间
* 查找的时间复杂度：O(logn)
* 原始链表包含 n 个元素，则一级索引元素个数为 n/2、二级索引元素个数为 n/4、三级索引元素个数为 n/8，索引节点的总和是：n/2 n/4 n/8 … 8 4 2 = n-2，**空间复杂度是 O(n)**
* 跳表在Redis中的应用：作为有序集类型zset的底层数据结构



### 数组、链表类的解题思路

* 一位数组要注意数组的坐标变换
* 常见技巧：快慢双指针，双指针左右夹逼法
* LinkedList的解法都很固定，要注意next指针的相互转换
* 懵逼的时候
  * 能不能暴力求解
  * 看一下最基本的情况
  * 找最近重复子问题，找规律，利用for-loop，recursion求解



### 栈、队列、双端队列、优先队列

* 用 add first 或 add last 这套新的 API 改写 Deque 的代码

  ```java
  Deque<String> deque = new LinkedList<>();
  deque.addFirst("a");
  deque.addFirst("b");
  deque.addFirst("c");
  System.out.println(deque);
  
  String str = deque.peekFirst();
  System.out.println(str);
  System.out.println(deque);
  
  while (deque.size() > 0){
    System.out.println(deque.removeFirst());
  }
  System.out.println(deque);
  ```

* Java中的Queue

  * Queue接口扩展了Collection接口。
  * 子接口：BlockingQueue, Deque, BlobkingDequeue
  * 常见的实现类：LinkedList，ArrayBlickingQueue, LinkedBlockingQueue，PriorityQueue, PriorityBlockingQueue
  * 提供的方法
    * add(E e)：将指定的元素插入队列（如果立即可行且不会违反容量限制），在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException
    * element()：获取但不移除队列的头
    * offer(E e)：将指定的元素插入队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常
    * peek()：获取但不移除队列的头；如果队列为空，则返回 null
    * poll()：获取并移除队列的头，如果此队列为空，则返回 null
    * remove()：获取并移除队列的头

* Java中的PriorityQueue

  * 实现接口：Queue
  * 可以对其中元素进行排序，默认排列顺序是升序排列，对于自定义类型的元素来说，需要自己定义比较器Comparator。
    每次取出的元素都是队列中权值最小的
  * 提供的方法
    1. add()和offer：向队列中插入元素，add在插入失败时抛出异常，offer则会返回false，并且不允许放入null元素。
       当达到容量上限后，调用grow()方法进行扩容。
       插入元素可能会影响队列的队列优先级特性，通过`siftUp(int k, E x)`方法向上进行调整
    2. element()和peek():获取但不删除队首元素，也就是队列中权值最小的那个元素,当方法失败时前者抛出异常，后者返回null
    3. remove()和poll()：获取并删除队首元素，当方法失败时前者抛出异常，后者返回null
       删除操作会改变队列的优先级特性，通过`siftDown(int k, E x)`方法向下进行调整
    4. remove(Object o)：删除队列中跟`o`相等的某一个元素（如果有多个相等，只删除一个）

