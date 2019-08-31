import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
* 演示直接获取本类的泛型类型
* */
class A<T>{
  private T data;
  private List<Integer> list;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public List<Integer> getList() {
    return list;
  }

  public void setList(List<Integer> list) {
    this.list = list;
  }

  public static void main(String []args){

    A a=new A();
    Object object="kdjfkdjf";

    a.setData(object);






  }

}

