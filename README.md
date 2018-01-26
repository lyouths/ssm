# Java中String、StringBuilder和StringBuffer的区别

------   

在网上查找知识点时很容易产生当时看了就会，下次又遇到这个知识点时却不得不再次上网查看这个知识点的毛病。于是打算以后将自己领悟不清的知识点写下来（相信这也是大多数人喜欢写博客的原因吧），一方面为了给后来者借鉴，另一方面也是为了自己加深印象和自己对知识的总结。

今天就来谈谈自己java中**String**、**StringBuilder**和**StringBuffer**知识点的理解。

------   



> * String字符串常量
> * StringBuffer字符串变量(线程安全）
> * StringBuilder字符串变量（非线程安全）

运行速度快慢为：StringBuilder > StringBuffer > String

## String
所谓常量，即该对象的值已经被赋予了，不能再更改。若非要更改，则只能再重新创建另一个对象，在这个新创建的对象上再进行赋值。因此，每次在对String类型的对象进行改变的时候其实都等同于生成了一个新的String对象，然后将指针指向新的String对象，所以经常改变内容的字符串最好不要用String，因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后，JVM的GC就会开始工作，那速度是一定会相当慢的。

原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。以下面一段代码为例：
```
String str="abc";
System.out.println(str);
str=str+"de";
System.out.println(str);

```
　如果运行这段代码会发现先输出“abc”，然后又输出“abcde”，好像是str这个对象被更改了，其实，这只是一种假象罢了，JVM对于这几行代码是这样处理的，首先创建一个String对象str，并把“abc”赋值给str，然后在第三行中，其实JVM又创建了一个新的对象也名为str，然后再把原来的str的值和“de”加起来再赋值给新的str，而原来的str就会被JVM的垃圾回收机制（GC）给回收掉了，所以，str实际上并没有被更改，也就是前面说的String对象一旦创建之后就不可更改了。所以，Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。
　
　　而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

另外，有时候我们会这样对字符串进行赋值
```
String str="abc"+"de";
StringBuilder stringBuilder=new StringBuilder().append("abc").append("de");
System.out.println(str);
System.out.println(stringBuilder.toString());
```

这样输出结果也是“abcde”和“abcde”，但是String的速度却比StringBuilder的反应速度要快很多，这是因为第1行中的操作和
```
String str="abcde";
```
是完全一样的，所以会很快，而如果写成下面这种形式
```
String str1="abc";
String str2="de";
String str=str1+str2;
```
那么JVM就会像上面说的那样，不断的创建、回收对象来进行这个操作了。速度就会很慢。

## StringBuffer
所谓变量，即是可以随时变化的量。如果对StringBuffer对象进行改变，每次结果都会对StringBuffer对象进行操作，而不是生成新的对象。所以一般字符串要经常变化的话我推荐使用StringBuffer。


## StringBuilder
StringBuilder和StringBuffer类功能基本相似，方法也差不多，主要区别在于StringBuffer类的方法是多线程安全的，而StringBuilder不是线程安全的，相比而言StringBuilder类会略微快一点。

**题外话:** 现在很多互联网公司面试java的面试官都喜欢问这样一个问题,

>  请你谈谈StringBuffer和StringBuilder的区别。

大多数人肯定会直接说前者是线程安全的而后者是非线程安全的。其实这个时候才是面试官真正想问的，他会顺着你的回答又问你，那请你谈谈什么是线程…balabalabala。哈哈，要想顺利通过面试，所以对知识的了解还是全面点吧～！


## 总结
在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的。

如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，那么就要使用StringBuffer，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder。

- [x] String：适用于少量的字符串操作的情况
- [x] StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
- [x] StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

------


写在最后：以上这些总结的内容绝大多数是我从网上以及书上找来的，写在这里是想把自己所学的分享给大家，方便大家学习，同时也有助于自己记忆，如果有哪里不对的恳请指正.

## Contact:
 - [Blog](www.liuyu.pw)
 - Email:i@byliuyu.com
 - [Github](github.com/liuyu1994)

   


