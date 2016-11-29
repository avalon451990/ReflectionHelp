package aa.zz.com.myapplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created on 2016/10/19.
 *
 * 如若参数中有float类型，则必须在该参数后添加"f"标识符，以和double做区别
 */

public class ReflectionHelp {

    //调用构造函数
    public static Object reflectConstructor(String packageName, String constructorName, Object... params) throws Exception{
        Class<?> threadClass = Class.forName(packageName);
        Method[] methods = threadClass.getMethods();
        Object object = null;
        for (Method method:methods) {
            if (constructorName.equals(method.getName())){
                Class[] types = method.getParameterTypes();
                if (isOk(types, params)) {
                    Constructor constructor = threadClass.getConstructor(types);
                    object = constructor.newInstance(params);
                    break;
                }
            }
        }
        return object;
    }

    //调用
    public static Object reflectMethod(String packageName, String methodName, Object object, Object... params) throws Exception{
        Class<?> threadClass = Class.forName(packageName);
        Method[] methods = threadClass.getMethods();
        Object ret = null;
        for (Method method:methods) {
            if (methodName.equals(method.getName())){
                if (isOk(method.getParameterTypes(), params)) {
                    ret = method.invoke(object, params);
                    break;
                }
            }
        }
        return ret;
    }

    private static boolean isOk(Class[] types, Object... params){
        int len = params == null ? 0 : params.length;
        if (types.length != len){
            return false;
        }
        for (int i = 0; i < len; i++){
            if (!types[i].getName().equals(getType(params[i]))){
                return false;
            }
        }
        return true;
    }

    /*
    这里将封装类型转成了原始类型
     */
    private static String getType(Object o){
        String name = o.getClass().getName();
        switch (name){
            case "java.lang.Integer":
                return "int";
            case "java.lang.Byte":
                return "byte";
            case "java.lang.Character":
                return "char";
            case "java.lang.Double":
                return "double";
            case "java.lang.Float":
                return "float";
            case "java.lang.Long":
                return "long";
            case "java.lang.Boolean":
                return "boolean";
            case "java.lang.Short":
                return "short";
            default:
                return name;
        }
    }
}
