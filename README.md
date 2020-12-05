# TechUtil
取代枚举，使用lambda表达式取普通bean中的方法名，作为字符标识返回

**从中央库引入jar**
````
    <dependency>
        <groupId>com.github.jeffreyning</groupId>
        <artifactId>TechUtil</artifactId>
        <version>1.0.0</version>
    </dependency>
````

**在实体类有get方法**
````
public class TEntity {
    private String c1;
    private String ccDaoCal;
    private String colStoreThree;
    public String getC1() {
        return c1;
    }
    public void setC1(String c1) {
        this.c1 = c1;
    }
    public String getCcDaoCal() {
        return ccDaoCal;
    }
    public void setCcDaoCal(String ccDaoCal) {
        this.ccDaoCal = ccDaoCal;
    }
    public String getColStoreThree() {
        return colStoreThree;
    }
    public void setColStoreThree(String colStoreThree) {
        this.colStoreThree = colStoreThree;
    }
}

````

**通过lambda表达式获取实体类方法名字符串**
````
    public static void main(String[] args) throws Exception {
        System.out.println(TechUtil.pn(TEntity::getC1));
        System.out.println(TechUtil.pn(TEntity::getColStoreThree));
        System.out.println(TechUtil.pn(TEntity::getCcDaoCal));
    }
````
输出结果为<br>
c1<br>
colStoreThree<br>
ccDaoCal<br>


扫描订阅公众号，进行技术交流
![Image text](http://www.jrnsoft.com/qrcode_for_gh.jpg)

