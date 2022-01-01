//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 队列 👍 363 👎 0


import com.sun.deploy.util.DeployUIManager;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Deque<Integer> head;
    Deque<Integer> tail;

    public CQueue() {
        head = new LinkedList<>();
        tail = new LinkedList<>();
    }
    // 经典的双栈模拟队列, 入队 = 入 tail
    // 出队 =
    //       头栈 != null 直接 pop
    //       头栈 == null 把 tail 依次压入头栈后再出队
    public void appendTail(int value) {
        tail.push(value);
    }

    public int deleteHead() {
        if(!head.isEmpty()){
            return head.pop();
        }
        else {
            if(tail.isEmpty()){
                return -1;
            }
            while (!tail.isEmpty()){
                head.push(tail.pop());
            }
            return deleteHead();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
