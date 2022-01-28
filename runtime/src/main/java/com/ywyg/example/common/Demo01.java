package com.ywyg.example.common;

import com.ywyg.annotation.Time;
import org.springframework.stereotype.Service;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@Service
public class Demo01 {

    public void method01() {
        System.out.println("I'm method01");
    }

//    @forTest
//    public void method02() {
//        System.out.println("I'm method02");
//    }
//
//    @Time
//    public void method03() {
//        System.out.println("I'm method03");
//    }

    @Time
    public void method04(){
        System.out.println("I'm method04");
    }


}
