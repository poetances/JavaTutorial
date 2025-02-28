package com.zcj.lang;

/**
 * Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
 * Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。
 *
 * @author zcj
 * */
public class MathTutorial {

    public static void main(String[] args) {
        System.out.println("90 度的正弦值：" + java.lang.Math.sin(java.lang.Math.PI/2));
        System.out.println("0度的余弦值：" + java.lang.Math.cos(0));
        System.out.println("60度的正切值：" + java.lang.Math.tan(java.lang.Math.PI/3));
        System.out.println("1的反正切值： " + java.lang.Math.atan(1));
        System.out.println("π/2的角度值：" + java.lang.Math.toDegrees(java.lang.Math.PI/2));
        System.out.println(java.lang.Math.PI);
    }
}
