# java-opengl-starter

A starter template for OpenGL projects with the Java programming language.

### Dependencies
---

- [Java 17][1]
- [Maven][2]
- [LWJGL][3]
- [WiX Toolset][4] (Required to generate an application installer with jpackage on Windows)

### Generate Installer
---

```
$ jpackage --input ./ --main-class Main --main-jar java-opengl-minimal-1.0.0.jar
```

[1]:https://jdk.java.net/17/
[2]:https://maven.apache.org
[3]:https://www.lwjgl.org/
[4]:https://wixtoolset.org/ 
