## OpenBot

### 开发
#### 构建  
有2种构建方式:  
- 普通构建
- 快速构建 (**仅供开发**)

##### 普通构建
```shell
./gradlew build
```
这会生成一个普通的OpenBot Jar文件，并且~~最慢~~

##### Fast Build
```shell
./gradlew build -x test -x check --parallel --build-cache
```
这会生成一个普通的OpenBot Jar文件。  
**!** 以及它会 **跳过** 一些步骤:
- [x] 代码检查
- [x] 测试  
___你也可以用*Shadow*来改善构建速度___

##### Tips
特别地，默认构建用的是**Shadow**, if you need raw gradle build, remove this in `build.gradle.kts`:
```kotlin
tasks.build {
    dependsOn(tasks.shadowJar)
}
```

