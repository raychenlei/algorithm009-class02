学习笔记

DFS的代码模板

```java
class Dfs{
    List<Integer> list = null;
    public Dfs(){
        list = new ArrayList<>();
    }
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        list.add(root.val);
        
        // process current node here.
        // ......
        List<TreeNode> childrens = root.children;
        for (int i = 0; i < chidrens.size(); i++) {
            dfs(chidrens.get(i));
        }
        return Arrays.toArray(list);
    }
}
```



二分查找的前提：

1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

代码模板：

```java
let left = 0, right = array.length - 1;
while (left <= right) {
    let mid = (left + right) / 2;
    if (array[mid] == target){
        // find the target!!
        break or return result;
    } else if (array[mid] < target){
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```