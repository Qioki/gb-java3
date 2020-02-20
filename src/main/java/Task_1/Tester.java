package Task_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.xml.validation.Validator;

public class Tester {

    /*
     * Создать класс, который может выполнять «тесты». В качестве тестов выступают
     * классы с наборами методов с аннотациями @Test. Для этого у него должен быть
     * статический метод start(), которому в качестве параметра передается или
     * объект типа Class, или имя класса. Из «класса-теста» вначале должен быть
     * запущен метод с аннотацией @BeforeSuite, если такой имеется. Далее запущены
     * методы с аннотациями @Test, а по завершении всех тестов – метод с
     * аннотацией @AfterSuite. К каждому тесту необходимо добавить приоритеты (int
     * числа от 1 до 10), в соответствии с которыми будет выбираться порядок их
     * выполнения. Если приоритет одинаковый, то порядок не имеет значения. Методы с
     * аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
     * экземпляре, иначе необходимо бросить RuntimeException при запуске
     * «тестирования».
     */

    public static void main(String[] arg) throws Exception {
        start(TestClass1.class);
    }

    public static void start(Class c) throws Exception {

        Object obj = c.getConstructor().newInstance();

        Method[] methods = c.getDeclaredMethods();
        Method beforeMeth = null;
        Method afterMeth = null;

        ArrayList<Method> methodList = new ArrayList<>();
        Collections.addAll(methodList, methods);

        TreeMap<Integer, List<Method>> sortedList = new TreeMap<Integer, List<Method>>();

        for (Method meth : methodList) {
            if (meth.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMeth != null)
                    throw new RuntimeException();
                beforeMeth = meth;
            } else if (meth.isAnnotationPresent(AfterSuite.class)) {
                if (afterMeth != null)
                    throw new RuntimeException();
                afterMeth = meth;
            } else if (meth.isAnnotationPresent(Test.class)) {
                sortedList.computeIfAbsent(meth.getAnnotation(Test.class).priotity(), k -> new ArrayList<>()).add(meth);
            }
        }


        if (beforeMeth != null)
            beforeMeth.invoke(obj); 

        sortedList.forEach((k, v) -> v.forEach(m -> {
            try {
                m.invoke(obj);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }));
        
        if (afterMeth != null)
            afterMeth.invoke(obj);
    }
}