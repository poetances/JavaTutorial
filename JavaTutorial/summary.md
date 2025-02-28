
## 2.26
### 1. Java JDK的介绍
Java 代码运行时，主要依赖 **JDK** 中的以下部分：

- **javac（Java 编译器）**：把 `.java` 编译成 `.class`
- **JVM（Java 虚拟机）**：负责运行 `.class` 文件
- **Java 标准库（Java API）**：比如 `System.out.println()` 需要 `java.lang` 库

### JDK vs JRE vs JVM

| 组件                                | 作用                                   |
|-----------------------------------|--------------------------------------|
| **JDK（Java Development Kit）**     | Java 开发工具包，包含 JRE + 编译器（javac）+ 其他工具 |
| **JRE（Java Runtime Environment）** | 运行 Java 程序的环境，包含 JVM 和标准库            |
| **JVM（Java Virtual Machine）**     | 负责解释 `.class` 字节码，转换成机器码             |

**Java垃圾回收机制（Java GC）**是属于JVM的一部分。Java程序运行时候，JVM会想物理RAM申请内存，同时JVM
会将其分为：堆、栈、方法区等。iOS程序运行同样会申请分配内存，然后将其划分为栈、堆、静态区等。注意这里的内存
划分是对虚拟地址的划分，他们会映射到物理内存中。

## 2.27
### 1.Java访问修饰符。
    private defalut protected public
    对应的iOS有：
    private internal public open
### 2. Java运算符。
    跟其他语言没什么区别，这里不再赘述。

### 3. Java条件语句。
    跟其他语言也没什么区别，if(boolen表达式)...else

### 4. Java循环控制。
    三种：while、do...while、for.
    while(boolen表达式){}
    do {} while(boolen表达式)
    for(初始化；boolen表达式；更新) {}
**JAVA增强for循环**
    `for(声明语句 : 表达式) {}`其中声明很好理解。表达式一般就是：数组、数据表达式。
    其实这个跟for..in很像。里面同样可以借助`break、return、continue`这样来中断循环。

### 5.Java witch case语句。
`switch(expression) { case value: 语句 break }`其中expression可以是byte、short、int、char.

### 6.Java Meth&Number。
一般我们使用基本数据类型就可以。但是实际开发中，我们经常会使用对象，而不是内置基本数据类型。Java给每个基本数据类型
提供了对应的包装类。

| 包装类      | 基本数据类型 |
|----------|--------|
| Byte     | byte   |
| Short    | short  |
| Interger | int    |
| Long     | long   |
| Float    | float  |
| Double   | double |
| Charcter | char   |
| Boolen   | boolen |

然后，我们可能需要关注下他们的继承关系。
* Object
  * Number
    * Byte (byte)
    * Short (short)
    * Integer (int)
    * Long (long)
    * Float (float)
    * Double (double)
* Boolean (boolean)
* Character (char)

### 7、Java中Math类。
Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。

## 2.28
### 1、Java和OC中内存管理的相关知识。
| **内存区域** | **Java**     | **Objective-C** | **作用**              |
|----------|--------------|-----------------|---------------------|
| 代码区      | 方法区（元空间）     | 代码区             | 存储类的元数据和编译后的代码      |
| 常量区      | 常量池（方法区的一部分） | 常量区             | 存储字符串常量和字面量         |
| 堆        | 堆            | 堆               | 存储对象实例和数组           |
| 栈        | 栈            | 栈               | 存储局部变量和方法调用         |
| 本地方法栈    | 本地方法栈        | 调用 C/C++ 代码时的栈  | 支持本地方法调用            |
| 程序计数器    | 程序计数器        | 指令指针            | 记录当前线程执行的字节码指令地址    |
| 直接内存     | 直接内存         | `malloc` 分配的内存  | 存储通过 `NIO` 直接分配的缓冲区 |

```text
+-------------------+
|     常量区         |
| 存储 @"hello"     | <--- static NSString *xx
+-------------------+        NSString *str (方法内部)
|     堆            |
| 动态创建的字符串   | <--- [NSString stringWithFormat:]
+-------------------+
|     栈            |
| 局部变量指针（str）| ---> 指向常量区或堆
+-------------------+
```
### 2、StringBuilder和StringBuffer.

```text
Interface Layer (红色标注)
├── **CharSequence**       # 字符序列接口（如字符串的只读操作）
└── **Appendable**         # 可追加内容接口

Abstract Class Layer (黑色标注)
└── **AbstractStringBuilder**  
    ├── Implements: CharSequence, Appendable  # 实现上述两个接口
    ├── 核心功能: 动态修改字符串的底层实现

Concrete Class Layer (黑色标注)
├── **String**             
│   └── Implements: CharSequence  # 直接实现 CharSequence（不可变字符串）
│
└── **AbstractStringBuilder**  
    ├── **StringBuilder**  # 非线程安全的可变字符串
    └── **StringBuffer**   # 线程安全的可变字符串（方法用 synchronized 修饰）
```

### 3、Java中的格式化输出。
```text
占位符	说明	示例
%s	字符串	"Name: %s", "Alice"
%d	整数	"Age: %d", 25
%f	浮点数	"Price: %.2f", 9.99
%c	单个字符	"Letter: %c", 'A'
%b	布尔值	"Flag: %b", true
%t	日期/时间（需搭配子符）	"%tF", new Date()
```
一般自定义对象