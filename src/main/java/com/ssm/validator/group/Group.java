package com.ssm.validator.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, GroupA.class, GroupB.class })
public interface Group {
    // 组序列
    // 默认情况下，不同组别的约束验证是无序的，然而在某些情况下，约束验证的顺序却很重要，如下面两个场合：
    // （1）第二个组中的约束验证依赖于一个稳定状态来运行，而这个稳定状态是由第一个组来进行验证的。
    // （2）某个组的验证比较耗时，CPU 和内存的使用率相对比较大，最优的选择是将其放在最后进行验证。
    // 因此，在进行组验证的时候尚需提供一种有序的验证方式，这就提出了组序列的概念。
    //
    // 一个组可以定义为其他组的序列，使用它进行验证的时候必须符合该序列规定的顺序。
    // 在使用组序列验证的时候，如果序列前边的组验证失败，则后面的组将不再给予验证。
    //
    // Group中， default，GroupA，GroupB 均为 Group 的序列。
    // 验证顺序default-->check error
    // 验证顺序default-->check ok-->GroupA-->check error
    // 验证顺序default-->check ok-->GroupA-->check ok-->GroupB
}