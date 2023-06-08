package com.leaning.desensitized;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestApi {

    @GetMapping
    public TestDTO test(){
        TestDTO testDTO = new TestDTO();
        testDTO.setPhone("17677772345");
        return testDTO;
    }


    @PostMapping("/test-annotation")
    public TestAnnotationDTO testAnnotation(@RequestBody TestAnnotationDTO testAnnotationDTO){
//        TestAnnotationDTO testAnnotationDTO = new TestAnnotationDTO();
//        testAnnotationDTO.setPhone("17677772345");
//        testAnnotationDTO.setCustom("111111111111111111");
//        testAnnotationDTO.setEmail("1433926101@qq.com");
//        testAnnotationDTO.setIdCard("4444199810015555");
        System.out.println(testAnnotationDTO);
        return testAnnotationDTO;
    }
}