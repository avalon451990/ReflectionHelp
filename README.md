# ReflectionHelp
封装了两个方法，在使用反射调用方法时不用再去写函数参数的类型。

1.reflectConstructor调用构造函数
  #String packageName 类的路径
  #String constructorName 构造函数名称
  #Object... args 构造函数参数列表
  
2.reflectMethod调用其他函数
  #String packageName 类的路径
  #String constructorName 函数名称
  #boolean isStatic 是否是静态方法
  #Object... args 参数列表
