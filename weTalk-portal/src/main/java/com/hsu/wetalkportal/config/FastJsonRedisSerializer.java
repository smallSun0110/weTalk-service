package com.hsu.wetalkportal.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author zhouxq
 * @date 2022/10/8
 */
public class FastJsonRedisSerializer implements RedisSerializer<Object> {

	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public FastJsonRedisSerializer() {
		super();
	}

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		if (t == null) {
			return new byte[0];
		}

		if (t instanceof String) {
			return ((String) t).getBytes();
		}
		return JSON.toJSONString(t, SerializerFeature.DisableCircularReferenceDetect).getBytes(DEFAULT_CHARSET);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		return new String(bytes, DEFAULT_CHARSET);
	}
}
