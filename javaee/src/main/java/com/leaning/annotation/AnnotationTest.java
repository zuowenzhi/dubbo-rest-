package com.leaning.annotation;

import cn.hutool.core.util.ReflectUtil;
import com.leaning.annotation.annotation.DataTransForm;
import com.leaning.annotation.annotation.DataTransFormClass;
import com.leaning.annotation.annotation.DataTransFormList;
import com.leaning.annotation.entity.MerchtInfo;
import com.leaning.annotation.entity.TestEntity;
import com.leaning.annotation.entity.UserInfo;
import com.leaning.annotation.handler.TransformHandle;
import com.leaning.annotation.handler.TransformHandleImpl;
import com.leaning.annotation.strategy.IdCardStargy;
import com.leaning.annotation.strategy.TransformStargy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: zuowenzhi 2023/6/21 created
 * @Description: com.leaning.annotation
 * @version: 1.0
 */
@Slf4j
public class AnnotationTest {

//    @Resource
    private TransformHandle transformHandle = new TransformHandleImpl();

    @Test
    public void annotitionTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setMobilePhone("13312345678");
        userInfo.setIdCard("101727198801206789");
        userInfo.setUsername("张三李四");
        userInfo.setPassword("12312321");
        TestEntity testEntity = new TestEntity();
        testEntity.setUser(userInfo);

        ArrayList<MerchtInfo> merchtInfos = new ArrayList<>();
        MerchtInfo merchtInfo = new MerchtInfo();
        merchtInfo.setBankcardNo("1232189742343214432");

        merchtInfos.add(merchtInfo);
        testEntity.setMerchtInfoList(merchtInfos);
        dataTrans(testEntity);
    }

    public Object dataTrans(Object object){
        try {
            //获取当前运行时类的所有属性
            Field[] fields = ReflectUtil.getFields(object.getClass());
            for (Field field : fields) {
                //保证当前属性是可访问的
                field.setAccessible(true);
                /*if (null != field.getType() && null != field.getType().getClass().getClassLoader()) {
                    Object o = field.get(object);
                    if (o != null) {
                        dataTrans(o);
                    }
                }*/
                //获取标记的注解字段
                DataTransFormClass dataTransFormClass = AnnotatedElementUtils.getMergedAnnotation(field, DataTransFormClass.class);
                if (null != dataTransFormClass){
                    Object o = field.get(object);
                    if (o != null) {
                        dataTrans(o);
                    }
                }
                if (null != AnnotatedElementUtils.getMergedAnnotation(field, DataTransFormList.class)){
                    List o = (List) field.get(object);
                    if (o != null) {
                        for (int i = 0;i<o.size();i++){
                            dataTrans(o.get(i));
                        }
                    }
                }
                DataTransForm mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(field, DataTransForm.class);
                if (null == mergedAnnotation) {
                    continue;
                }
                //先加密
                if (mergedAnnotation.isEncipher()){
                    Object fieldValue= field.get(object);
                    if (StringUtils.isNotBlank(mergedAnnotation.encipherFieldName()) && Objects.nonNull(fieldValue)){
                        //回调Kms加密方法
//                        String sm4Value = commonRepository.sm4Encode(String.valueOf(fieldValue));
//                        ReflectUtil.setFieldValue(object,mergedAnnotation.encipherFieldName(),sm4Value);
                    }
                }
                //后脱敏 比如:12*****234
                if (mergedAnnotation.isDesensitize()) {
//                    TransformStargy stargy = containerMap.getStargy(mergedAnnotation.stargy());
                    //获取某个对象的当前属性值
                    Object value = field.get(object);
                    if(Objects.nonNull(value)) {
                        //脱敏值
                        Object excute = transformHandle.excute(value,new IdCardStargy() );
                        //脱敏通过反射的替换
                        field.set(object, excute);
                    }
                }
                //解密
                if (mergedAnnotation.isDecrypt()) {
                    //获取Enc加密字段属性值
                    Object fieldValue = ReflectUtil.getFieldValue(object,mergedAnnotation.encipherFieldName());
                    if (StringUtils.isNotBlank(mergedAnnotation.encipherFieldName()) && Objects.nonNull(fieldValue)){
                        //回调Kms解密方法
//                        String value = commonRepository.sm4Decode(String.valueOf(fieldValue));
                        //解密的值 反射替换脱敏字段
                        field.set(object, "加密后的字段");
                    }
                }
                //Url Oss转换
                if (mergedAnnotation.isUrlConvert()){
                    String orgiUrl = (String)field.get(object);
                    if(StringUtils.isNotBlank(orgiUrl)){
                        if(orgiUrl.contains("aliyuncs")){
                            orgiUrl = orgiUrl.substring(orgiUrl.indexOf("aliyuncs")+13);
                            //解码url
                            orgiUrl = URLDecoder.decode(orgiUrl,"UTF-8");
//                            URL url = client.generatePresignedUrl(bucketName, orgiUrl, DateUtils.addMinutes(new Date(), 5));
                            field.set(object, "解析OSS地址");
                        }
                    }
                }

            }
        } catch (Exception e){
            log.error("处理敏感数据失败",e);
        }
        return object;
    }
}


