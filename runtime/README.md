# record_runtime

## 背景

项目上需要记录一些方法执行时间，如果使用AOP会对现有程序有较多的修改和侵入，为了避免这种情况，同时满足尽可能方便指定那些方法需要记录，因此经过两天的开发，这个小工具诞生了，这个工具诞生的目的就是为了记录方法，因此他应当具有这些功能：

* 不修改目标代码
* 可以编辑记录格式
* 可以有多个渠道存储记录结果

## 使用方法

### 添加依赖

**Maven**

```html
<dependencies>
  <dependency>
    <groupId>com.ywyg</groupId>
    <artifactId>runtime</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </dependency>
</dependencies>
```

**Gradle**

```gr
implementation 'com.gv:gv-common-runtime:0.0.1-SNAPSHOT'
```

### 编辑`application.yml`

```yaml
runtime:
  annotations: "注解全限定名,多个请用 `,` 分隔开"  ##所有被这些注解修饰的方法都会被记录 
  type: {CONSOLE|FILE|ELASTICSEARCH}
  path: "you.path"  ## 当type是FILE时生效
spring:
  elasticsearch:
    rest:
      uris: "http://localhost:9200" ## 当type是ELASTICSEARCH时生效

```

### Time

`Time` 注解是工具特有的注解，被`@Time`注解修饰的方法同样会被记录时间

