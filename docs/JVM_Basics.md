# JVM Basics

## 1. What are JDK, JRE, and JVM?

### JVM (Java Virtual Machine)
The JVM is the part of Java that actually **runs your program**.  
When you execute a Java application, the JVM takes care of reading the compiled code and running it on your system.

It understands **bytecode**, manages memory, handles garbage collection, and applies security rules.  
Each operating system (Windows, Linux, macOS) has its own JVM implementation, but they all behave the same way.

---

### JRE (Java Runtime Environment)
The JRE is what you need **only to run Java programs**.

It contains:
- The JVM
- All the standard Java libraries required at runtime

It does **not** include tools for writing or compiling code. If you just want to run a Java application, the JRE is enough.

---

### JDK (Java Development Kit)
The JDK is meant for developers.

It includes:
- The JRE
- The Java compiler (`javac`)
- Other tools for debugging and packaging applications

In short, if you want to **write, compile, and run** Java programs, you need the JDK.

---

## 2. What is Bytecode?

When you write Java code in a `.java` file and compile it, the compiler does not generate machine-specific code.  
Instead, it produces **bytecode**, stored in `.class` files.

This bytecode is a middle layer—it is not tied to any operating system or hardware.  
At runtime, the JVM converts this bytecode into instructions that your system understands.

---

## 3. Write Once, Run Anywhere (WORA)

Java follows the principle of **Write Once, Run Anywhere**.

You write and compile your code once, which produces bytecode.  
As long as a system has a compatible JVM, that same bytecode can run on it—whether it’s Windows, Linux, or macOS.

Because of this approach, Java programs do not need to be rewritten for different platforms, which makes Java highly portable and platform-independent.
