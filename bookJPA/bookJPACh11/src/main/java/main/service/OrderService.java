package main.service;

import main.domain.*;
import main.domain.item.Item;
import main.repository.MemberRepository;
import main.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public OrderService(MemberRepository memberRepository, OrderRepository orderRepository, ItemService itemService) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    /**
     * 주문
     */
    public Long order(Long memberId, Long itemId, int count) {

        //엔티티 조회
        Member member = memberRepository.findById(memberId).orElse(null);
        Item item = itemService.findById(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }


    /**
     * 주문 취소
     */
    public void cancelOrder(Long orderId) {

        //주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElse(null);

        //주문 취소
        order.cancel();
    }

    /**
     * 주문 검색
     */
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }

}
