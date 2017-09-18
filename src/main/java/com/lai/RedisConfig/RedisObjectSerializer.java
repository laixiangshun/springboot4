package com.lai.RedisConfig;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by lailai on 2017/9/18.
 * 使用RedisTemplate<String,Object>
 * 实现对象的序列化，反序列化接口——springboot对spring-data-redis的接口RedisTemplate<K,V>不能直接使用，
 * 需要先实现RedisSerializer<T>接口来对传入的对象进行序列化和反序列化
 */
public class RedisObjectSerializer implements RedisSerializer<Object>{

    private Converter<Object,byte[]> serializer=new SerializingConverter();
    private Converter<byte[],Object> deserializer=new DeserializingConverter();
    private static final byte[] EMPTY_ARRAY=new byte[0];
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o==null){
            return EMPTY_ARRAY;
        }
        try {
            return serializer.convert(o);
        }catch (Exception ex){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
       if(isEmpty(bytes)){
           return null;
       }
        try {
            return deserializer.convert(bytes);
        }catch (Exception ex){
            throw new SerializationException("Connot deserialize",ex);
        }
    }

    private boolean isEmpty(byte[] data){
        return (data ==null || data.length==0);
    }
}
