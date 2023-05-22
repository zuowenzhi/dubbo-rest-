package com.leaning.hutoolcopyprpperty;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

/**
 * @author: zuowenzhi 2023/5/19 created
 * @Description: com.leaning.hutoolcopyprpperty
 * @version: 1.0
 */

public class CopyPropertyTest {

    @Test
    public void test(){
        // 前端传输的对象
//        DiagramDTO diagramDTO = new DiagramDTO();
//        // 如果前端传入的id事包含e的，升级后就会报错
//        diagramDTO.setId("3m3dgqsgmn0");
//        diagramDTO.setCode("de1");
//        diagramDTO.setName("图表");
//
//        Diagram diagram = new Diagram();
//        // 关键点，数据拷贝 ,id原来是string,转换后是integer,再copy的时候,需要将string转换为integer,
//        // 在转换的时候,如果string中包含了e,就会抛出异常
//        BeanUtil.copyProperties(diagramDTO, diagram);
//        System.out.println("数据实体对象：" + diagram);
//        //设置id为空，自增
//        diagram.setId(null);

        int i = NumberUtil.parseInt("12e");
        int i1 = Integer.parseInt("12e");
        System.out.println(i1);

    }
}


