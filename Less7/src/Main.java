

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    private static Class c = TestClass.class;
    private static Set<Method> sortedSet = new TreeSet<>(Comparator.comparing(Method::toString)); //Самосортировка
    private static Method beforeMethod = null;
    private static Method afterMethod = null;

    public static void main(String[] args) throws Exception {
        for (Method o : c.getDeclaredMethods()) {
            valideAndAdd(o); //Валидация и добавление
        }
        startingMethodTest(); //Запуск методов
        }
    private static void valideAndAdd(Method o){
            if (o.isAnnotationPresent(Test.class)) { //isAnnotationPresent проверка наличии аннотации
                sortedSet.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null){
                    beforeMethod = o;
                }else{
                    throw new RuntimeException("BeforeSuite > одного");
                }
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null){
                    afterMethod = o;
                }else{
                    throw new RuntimeException("AfterSuite > одного");
                };
            }
    }
      private static void startingMethodTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
          Object testObj = c.newInstance(); //

          if (beforeMethod != null){
               beforeMethod.invoke(testObj);
           };
           for (Method o : sortedSet){
               o.invoke(testObj);
           };
           if (afterMethod != null){
               afterMethod.invoke(testObj);
           };
       }
}

