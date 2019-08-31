import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
 import static java.lang.System.out;
/*
* 演示获取继承类的实际泛型参数
* */
class People<T>{}
public class Student extends People <String>{
  public static void main(String [] args){
    //创建对象
    Student student=new Student();
    //获取对应的类
    Class clazz=student.getClass();
    out.println(clazz);
    //获取该类的父类
    Class superClass =clazz.getSuperclass();
    out.println(superClass);
    //获取该类的超类，只是如果该超类含有泛型化参数时该泛型也必须显示
    Type genericSuperclass=clazz.getGenericSuperclass();
    out.println(genericSuperclass instanceof Type);
    out.println(genericSuperclass);
    //将获取到的Type数据强转为ParameterizedType泛型类型,实际应用中应该有一个判断
    ParameterizedType p = (ParameterizedType)genericSuperclass;
    //获取泛型参数列表，因为可能存在多个泛型
    Type type[] = p.getActualTypeArguments();
    //获取到泛型
    Class t=(Class)type[0];
    out.println(t);
  }

}
