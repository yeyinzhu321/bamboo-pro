package base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Json 工具类
 *
 * @author : bamboo
 * @date : 2020-07-14
 */
public class JsonUtil extends BaseJsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    public static final ObjectMapper OBJECT_MAPPER_SON = new ObjectMapper();
    private static final DateTimeFormatter MY_DATE_TIME;
    private static final DateTimeFormatter MY_DATE;

    public JsonUtil() {
    }

    private static String writeValue(Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof String) {
            return (String) object;
        } else {
            try {
                return OBJECT_MAPPER_SON.writeValueAsString(object);
            } catch (JsonProcessingException var2) {
                LOGGER.error("writeJsonValue error, ", var2);
                return null;
            }
        }
    }

    private static <T> T readValue(String json, Class<T> t) {
        if (json == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER_SON.readValue(json, t);
            } catch (Exception var3) {
                LOGGER.error("readJsonValue error, ", var3);
                return null;
            }
        }
    }

    private static <T> T readValue(String json, TypeReference<T> t) {
        if (json == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER_SON.readValue(json, t);
            } catch (Exception var3) {
                LOGGER.error("readJsonValue error, ", var3);
                return null;
            }
        }
    }

    public static String toString(Object object) {
        return writeValue(object);
    }

    public static <T> T toBean(String json, Class<T> t) {
        return readValue(json, t);
    }

    public static <T> List<T> toList(String json) {
        return (List) readValue(json, new TypeReference<List<T>>() {
        });
    }

    public static <K, V> Map<K, V> toMap(String json) {
        return (Map) readValue(json, new TypeReference<Map<K, V>>() {
        });
    }

    public static <T> T toBean(String json, TypeReference<T> t) {
        return readValue(json, t);
    }

    static {
        MY_DATE_TIME = (new DateTimeFormatterBuilder()).appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral(' ').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
        MY_DATE = (new DateTimeFormatterBuilder()).appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
        OBJECT_MAPPER_SON.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(MY_DATE_TIME));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(MY_DATE_TIME));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(MY_DATE));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(MY_DATE));
        OBJECT_MAPPER_SON.registerModule(javaTimeModule);
        OBJECT_MAPPER_SON.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER_SON.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER_SON.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        OBJECT_MAPPER_SON.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(
                    Object value,
                    JsonGenerator jg,
                    SerializerProvider sp) throws IOException, JsonProcessingException {
                jg.writeString("");
            }
        });
        OBJECT_MAPPER_SON.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * @param json  准备转换json
     * @param clazz 集合元素类型
     * @return
     * @description json字符串转换成对象集合
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            return (List<T>) OBJECT_MAPPER_SON.readValue(json, javaType);
        } catch (IOException e) {
            LOGGER.error("parseJsonList  ", e);
        }
        return null;
    }

    /**
     * @param collectionClass 集合类
     * @param elementClasses  集合元素类
     * @return
     * @description 获取泛型的 CollectionType
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER_SON.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
