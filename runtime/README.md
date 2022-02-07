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

### Time注解

`Time` 注解是工具特有的注解，被`@Time`注解修饰的方法同样会被记录时间

### 自定义格式

自定义格式需要继承`RecordTemplate`，主要是需要记录的属性补充，同时，需要继承并实现`MethodUpper`，`MethodUpper`的`cost`方法参数分别是方法代理和记录代理对象，需使用者自定义记录过程，现有如下示例：

其中 `MyRecordTemplate`是`RecordTemplate`实现类，`MyMethodUpper`是`MethodUpper`子类。

```java
@Service
public class MyMethodUpper implements MethodUpper {

    @Override
    public Object cost(MethodInvocation invocation, OutResult outResult) throws Throwable {
        outResult.record(MyRecordTemplate.builder().build());
        return invocation.proceed();
    }
}
```

<font color="red">注意:</font> `MyRecordTemplate` 必须标记为`Bean`对象。

补充：如果使用 `elasticsearch` 记录，`index` 是 `record_log`