package com.zcj.lang;

/**
 * String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
 * new 创建的对象放在堆中。可以使用 `intern()`会将字符串常量池，如果已经存在相同的字符串，就复用它。
 *
 *  内存区域	Java	Objective-C	作用
 * 代码区	方法区（元空间）	代码区	存储类的元数据和编译后的代码
 * 常量区	常量池（方法区的一部分）	常量区	存储字符串常量和字面量
 * 堆	堆	堆	存储对象实例和数组
 * 栈	栈	栈	存储局部变量和方法调用
 * @author zcj
 * */
public class StringTutorial {

    public static void main(String[] args) {
        String s1 = "Runoob";              // ① 直接创建（字符串常量池）
        String s2 = "Runoob";              // ② 直接创建（复用常量池）
        String s3 = s1;                    // ③ 赋值引用（s3 和 s1 指向同一地址）
        String s4 = new String("Runoob");   // ④ new 关键字（堆内存创建新对象）
        String s5 = new String("Runoob");   // ⑤ new 关键字（创建新的对象）

        String s6 = new String("Runoob").intern();
        System.out.println(s1 == s6);  // true
        System.out.printf("%x %x %x %x %x %x\n",
                System.identityHashCode(s1),
                System.identityHashCode(s2),
                System.identityHashCode(s3),
                System.identityHashCode(s4),
                System.identityHashCode(s5),
                System.identityHashCode(s6)
        );
        // 6acbcfc0 6acbcfc0 6acbcfc0 5f184fc6 3feba861 6acbcfc0

        float floatVar = 10.0f;
        int intVar = 1;
        String stringVar = "java";
        String fs;
        fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", floatVar, intVar, stringVar);
    }

    /*
     * 很像iOS中的description方法。
     * */
    @Override
    public String toString() {
        return super.toString();
    }
}
