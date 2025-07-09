package kr.co.wikibook.gallery.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor //기본생성자 넣는고
public class AccountJoinReq {
    private String name;
    private String loginId;
    private String loginPw;
}
