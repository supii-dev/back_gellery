package kr.co.wikibook.gallery.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemPostDto {
    private String orderId;
    private String itemId;

}
