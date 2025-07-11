package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.cart.CartMapper;
import kr.co.wikibook.gallery.item.ItemMapper;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final ItemMapper itemMapper;
    private final CartMapper cartMapper;

    @Transactional // 에러터지면 되돌림 , 롤백
    public int saveOrder(OrderPostReq req,int logginedMemberId) {
        List<ItemGetRes> itemList = itemMapper.findAllByIdIn(req.getItemIds());
        log.info("itemList={}", itemList);
        int amount = 0;
        for(ItemGetRes item : itemList ){
            amount += item.getPrice() - (item.getPrice()*item.getDiscountPer())/100;
        }
        log.info("sum={}",amount);

        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setMemberId(logginedMemberId);
        orderPostDto.setName(req.getName());
        orderPostDto.setAddress(req.getAddress());
        orderPostDto.setPayment(req.getPayment());
        orderPostDto.setCardNumber(req.getCardNumber());
        orderPostDto.setAmount(amount);
        log.info("before-orderPostDto={}", orderPostDto);
        int result = orderMapper.save(orderPostDto);
        log.info("after-orderPostDto={}", orderPostDto);

        OrderItemPostDto orderItemPostDto = new OrderItemPostDto(orderPostDto.getOrderId(),req.getItemIds());
        int resultDetail = orderItemMapper.save(orderItemPostDto);

        cartMapper.deleteByMemberId(logginedMemberId);


        return 1;

    }
        public List<OrderGetRes> findAll(int memberId){
        return orderMapper.findAllByMemberIdOrderByIdDesc(memberId);
        }
        public OrderDetailGetRes detail(OrderDetailGetReq req){
        OrderDetailGetRes result = orderMapper.findByOrderIdAndMemberId(req);
        log.info("result={}", result);
        return result;
        }
}

