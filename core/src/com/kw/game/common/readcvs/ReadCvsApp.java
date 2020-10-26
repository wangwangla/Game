package com.kw.game.common.readcvs;

import com.badlogic.gdx.utils.Array;

import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReadCvsApp {
    HashMap<Class<?> ,String> hashMap = new HashMap<>();

    public ReadCvsApp(){
        hashMap.put(byte.class,"byte");
        hashMap.put(int.class,"int");
        hashMap.put(float.class,"float");
        hashMap.put(double.class,"double");
        hashMap.put(long.class,"long");
        hashMap.put(boolean.class,"boolean");
    }

    /**
     * 直接通过字段赋值
     * @param array   数据保存的集合
     * @param fileReader  文件名字（路径）
     * @param clazz  所需要封装的嘞
     * @return  返回数组
     * @throws Exception
     */
    public Array cvsToArrayPassFeild(Array array, Reader fileReader, Class clazz) {
        try {
            CsvReader reader = new CsvReader(fileReader);
            reader.skipRecord();
            reader.readHeaders();
            reader.skipRecord();
            while (reader.readRecord()) {
                try {
                    Object tempObject = clazz.getDeclaredConstructor().newInstance();
                    for (Field declaredField : clazz.getDeclaredFields()) {
                        String value = Interpreter.iteratorAnnotations(declaredField);
                        declaredField.setAccessible(true);
                        fieldSetValue(declaredField, reader.get(value), tempObject);
                    }
                    array.add(tempObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return array;
        }catch (Exception e){
            e.printStackTrace();
            return array;
        }
    }


    /**
     * 直接通过字段赋值
     * @param array   数据保存的集合
     * @param fileReader  文件名字（路径）
     * @param clazz  所需要封装的嘞
     * @return  返回数组
     * @throws Exception
     */
    public Array readMethodMethod(Array array, Reader fileReader, Class clazz) {
        try {
            CsvReader reader = new CsvReader(fileReader);
            reader.skipRecord();
            reader.readHeaders();
            reader.skipRecord();
            while (reader.readRecord()) {
                try {
                    //创建对象
                    Object tempObject = clazz.getDeclaredConstructor().newInstance();
                    //获取字段
                    for (Field declaredField : clazz.getDeclaredFields()) {
                        //通过注解得到字段的名称，  如果字段和表是一样的，就不需要注解
                        String value = Interpreter.iteratorAnnotations(declaredField);
                        declaredField.setAccessible(true);
                        //方法名称
                        String methodName = parSetName(declaredField.getName());
//                        参数类型
                        Class<?> aClass = checkType(declaredField.getType());
                        //得到方法
                        Method method = clazz.getMethod(methodName, aClass);
                        //设置值
                        mathodSetValue(method,reader.get(value),tempObject,declaredField);
                    }
                    array.add(tempObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return array;
        }catch (Exception e){
            e.printStackTrace(System.err);
            return array;
        }
    }

    private void fieldSetValue(Field declaredField, String value, Object o) throws IllegalAccessException {
        if (feildBoolean(declaredField,"byte")) {
            declaredField.set(o,ConvertUtil.convertToByte(value,(byte) 0));
        }else if (feildBoolean(declaredField,"int")){
            declaredField.set(o,ConvertUtil.convertToInt(value,0));
        }else if (feildBoolean(declaredField,"float")){
            declaredField.set(o,ConvertUtil.convertToFloat(value,0F));
        }else if (feildBoolean(declaredField,"double")){
            declaredField.set(o,ConvertUtil.convertToFloat(value,0));
        }else if (feildBoolean(declaredField,"long")){
            declaredField.set(o,ConvertUtil.convertToLong(value,0L));
        }else if (feildBoolean(declaredField,"boolean")){
            declaredField.set(o,ConvertUtil.convertToBoolean(value,false));
        }else {
            System.out.println();
            declaredField.set(o,value);
        }
    }

    private Class<?>  checkType(Class<?> type){
        if (hashMap.containsKey(type)) {
            return type;
        }
        return String.class;
    }

    private void mathodSetValue(Method declaredMethod, String value, Object o,Field declaredField) throws IllegalAccessException, InvocationTargetException {
        if (feildBoolean(declaredField,"byte")) {
            declaredMethod.invoke(o, ConvertUtil.convertToByte(value,(byte) 0));
        }else if (feildBoolean(declaredField,"int")){
            declaredMethod.invoke(o,ConvertUtil.convertToInt(value,0));
        }else if (feildBoolean(declaredField,"float")){
            declaredMethod.invoke(o,ConvertUtil.convertToFloat(value,0F));
        }else if (feildBoolean(declaredField,"double")){
            declaredMethod.invoke(o,ConvertUtil.convertToFloat(value,0));
        }else if (feildBoolean(declaredField,"long")){
            declaredMethod.invoke(o,ConvertUtil.convertToLong(value,0L));
        }else if (feildBoolean(declaredField,"boolean")){
            declaredMethod.invoke(o,ConvertUtil.convertToBoolean(value,false));
        }else {
            declaredMethod.invoke(o,value);
        }
    }
    public String parSetName(String fieldName) {
        //通过字段拼接出方法名称
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "set"+ fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

    private boolean feildBoolean(Field field, String type){
        return field.getGenericType().toString().equals(type);
    }
}

