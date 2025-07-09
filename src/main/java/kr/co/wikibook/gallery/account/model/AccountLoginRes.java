package kr.co.wikibook.gallery.account.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountLoginRes {
    private int id;
    @JsonIgnore
    private String loginPw;
}
