package kr.co.wikibook.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtils {

    //세션입력 개인사물함이라고 생각하라 브라우저마다 만들어진다
    //세션에 데이터 저장
    public static void setSession(HttpServletRequest req,String key,Object value){
        req.getSession().setAttribute(key,value);
        // 물건맡기러가서 이름이랑 물건맡긴다
    }
    // 세션의 저장된 데이터 얻기
    public static Object getSessionValue(HttpServletRequest req,String key){
        return req.getSession().getAttribute(key);
        //그럼 내이름만 말하면 물건줌여
    }
    //세션에 저장된 데이터 삭제
    public static void removeSessionValue(HttpServletRequest req,String key){
        req.getSession().removeAttribute(key);
    }


}
