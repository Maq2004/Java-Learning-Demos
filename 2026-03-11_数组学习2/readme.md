1. 二分查找（Binary Search）
核心逻辑： 必须在有序数组里玩。
避雷：

循环条件： 必须是 while (left <= right)。因为当 left 和 right 指向同一个数时，那个数还没被检查过，漏了就可能找不着。

指针挪动： left = mid + 1 或 right = mid - 1。这是为了打破取整带来的“原地踏步”，如果没有这 +1/-1，在区间只剩两个数时，程序会一直卡死在同一个 mid 上。

Java
public static int MyArrayBinarySearch(int[] a, int data) {
    int LeftIndex = 0;
    int RightIndex = a.length - 1;
    while (LeftIndex <= RightIndex) {
        int MidIndex = (LeftIndex + RightIndex) / 2;
        if (data < a[MidIndex]) {
            RightIndex = MidIndex - 1;
        } else if (data > a[MidIndex]) {
            LeftIndex = MidIndex + 1;
        } else {
            return MidIndex;
        }
    }
    return -1;
}
2. 回型方阵（正向与反向）
核心规律：寻找点到边缘的距离。

对称性公理
公式： j + 对称点 = n - 1。

原理： 左右对称点到各自边缘的距离是相等的。既然从左往右走 j 步，那从最右端（索引 n-1）往回退 j 步就是对称点。所以代码里赋值的时候直接用 n-1-j。

“L型”层数探测器
逻辑： 坐标 [i][j] 中较小的那个数，决定了它在第几圈。

正向逻辑： value = Math.min(i, j) + 1。将物理上的 0 步偏移映射成视觉上的第 1 层。

反向逻辑： value = (n + 1) / 2 - Math.min(i, j)。先算出总层数（最大值），然后往里走一步，值就减 1。

避坑：关于那一圈 0 的由来
原因： 第一版代码从索引 1 开始，人为跳过了索引 0。数组初始化默认是 0，所以我没碰过的 0 索引那一圈就被晾在了外面。

解决： 回归 0 索引，用 Math.min(i, j) 配合数值偏移来实现严丝合缝的打印。

3. 内存模型的理解
栈 (Stack)： 存变量名字和数组的“遥控器”（地址）。

堆 (Heap)： 存 new 出来的实体。

关键点： 二维数组在堆里是“地址的地址”。当我写 arr[n-1-i][n-1-j] = value 时，我是顺着地址找到了那个独立的格子。因为格子地址不重叠，所以那四行对称赋值的代码顺序随便打乱，结果都不会变。