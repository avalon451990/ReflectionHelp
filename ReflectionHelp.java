package aa.zz.com.myapplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created on 2016/10/19.
 */

public class ReflectionHelp {

    //调用构造函数
    public static Object reflectConstructor(String packageName, String constructorName, Object... args) throws Exception{
        Class<?> threadClass = Class.forName(packageName);
        Method[] methods = threadClass.getMethods();
        Object object = null;
        for (Method method:methods) {
            if (constructorName.equals(method.getName())){
                Class[] params = method.getParameterTypes();
                Constructor constructor = threadClass.getConstructor(params);
                object = constructor.newInstance(args);
                break;
            }
        }
        return object;
    }

    //调用静态方法
    @Deprecated
    public static Object reflectStaticMethod(String packageName, String methodName, Object... args) throws Exception{
        Class<?> threadClass = Class.forName(packageName);
        Method[] methods = threadClass.getMethods();
        Object object = null;
        for (Method method:methods) {
            if (methodName.equals(method.getName())){
                object = method.invoke(null,args);
                break;
            }
        }
        return object;
    }

    //调用
    public static Object reflectMethod(String packageName, String methodName, boolean isStatic, Object... args) throws Exception{
        Class<?> threadClass = Class.forName(packageName);
        Method[] methods = threadClass.getMethods();
        Object object = null;
        for (Method method:methods) {
            if (methodName.equals(method.getName())){
                if (isStatic){
                    object = method.invoke(null,args);
                }else{
                    object = method.invoke(args);
                }
                break;
            }
        }
        return object;
    }
}
