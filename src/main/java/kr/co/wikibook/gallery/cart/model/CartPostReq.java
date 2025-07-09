package kr.co.wikibook.gallery.cart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartPostReq {
    private int memberId;// 세션에 저장된 아이디만 사용함 이건사용하지않음  0이 들어가잇음
    private int itemId;
}
