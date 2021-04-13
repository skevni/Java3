package ru.geekbrains.sklyarov.java3core.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RunTests {
    /***
     * priority:  HIGHEST = 1, LOWEST = 10
     * @param testClass - class
     */
    static void start(Class testClass) {
        boolean isBeforeSuite = false;
        boolean isAfterSuite = false;
        ArrayList<Method> listMethods;
        SortedMap<Integer, ArrayList<Method>> orderedMethod = new TreeMap<>(Comparator.naturalOrder());
        Method[] methods = testClass.getDeclaredMethods();
        for(Method m: methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (isBeforeSuite){
                    throw new RuntimeException("Annotated BeforeSuite method must be in one instance");
                }
                orderedMethod.put(0, new ArrayList<>(Collections.singleton(m)));
                isBeforeSuite = true;
            }
            if (m.isAnnotationPresent(Test.class)){
                if(m.getAnnotation(Test.class).priority()>10 || m.getAnnotation(Test.class).priority()<1){
                    throw new RuntimeException("Annotation priority must be between 1 and 10");
                }
                if (!orderedMethod.containsKey(m.getAnnotation(Test.class).priority())) {
                    orderedMethod.put(m.getAnnotation(Test.class).priority(), new ArrayList<>());
                }
                listMethods = orderedMethod.get(m.getAnnotation(Test.class).priority());
                listMethods.add(m);

                orderedMethod.put(m.getAnnotation(Test.class).priority(), listMethods);
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                if (isAfterSuite){
                    throw new RuntimeException("Annotated AfterSuite method must be in one instance");
                }
                orderedMethod.put(11, new ArrayList<>(Collections.singleton(m)));
                isAfterSuite = true;
            }
        }
        orderedMethod.forEach((key, value) ->{
            for (Method m: value){
                try {
                    Object objClass = testClass.getDeclaredConstructor().newInstance();
                    m.invoke(objClass);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
