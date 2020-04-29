package main.service;

import main.domain.Address;
import main.domain.Member;
import main.domain.Order;
import main.domain.OrderStatus;
import main.domain.item.Book;
import main.domain.item.Item;
import main.repository.ItemRepository;
import main.repository.MemberRepository;
import main.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;

//    @Test
//    public void 상품주문() {
//
//        //Given
//        Member member = createMember();
//        Item item = createBook("시골 JPA", 10000, 10); //이름, 가격, 재고
//        int orderCount = 2;
//
//        //When
//        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
//
//        //Then
//        Order getOrder = orderRepository.findById(orderId).orElse(null);
//
//        assertEquals(OrderStatus.ORDER.toString(), getOrder.getStatus().toString(), "상품 주문시 상태는 주문(ORDER)이다.");
//        assertEquals(1, getOrder.getOrderItems().size(), "주문한 상품 종류 수가 정확해야 한다.");
//        assertEquals(10000 * 2, getOrder.getTotalPrice(), "주문 가격은 가격 * 수량이다.");
//        assertEquals(8, item.getStockQuantity(), "주문 수량만큼 재고가 줄어야 한다.");
//    }
//
//@Test(expected = NotEnoughStockException.class)
//public void 상품주문_재고수량초과() throws Exception {
//
//    //Given
//    Member member = createMember();
//    Item item = createBook("시골 JPA", 10000, 10);
//
//    int orderCount = 11; //재고 보다 많은 수량
//
//    //When
//    orderService.order(member.getId(), item.getId(), orderCount);
//
//    //Then
//    fail("재고 수량 부족 예외가 발생해야 한다.");
//}
//
//
//    @Test
//    public void 주문취소() {
//
//        //Given
//        Member member = createMember();
//        Item item = createBook("시골 JPA", 10000, 10);
//        int orderCount = 2;
//
//        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
//
//        //When
//        orderService.cancelOrder(orderId);
//
//        //Then
//        Order getOrder = orderRepository.findOne(orderId);
//
//        assertEquals("주문 취소시 상태는 CANCEL 이다.",OrderStatus.CANCEL, getOrder.getStatus());
//        assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야 한다.", 10, item.getStockQuantity());
//    }

//    private Member createMember() {
//        Member member = new Member();
//        member.setName("회원1");
//        member.setAddress(new Address("서울", "강가", "123-123"));
//        memberRepository.save(member);
//        return member;
//    }
//
//    private Book createBook(String name, int price, int stockQuantity) {
//        Book book = new Book();
//        book.setName(name);
//        book.setStockQuantity(stockQuantity);
//        book.setPrice(price);
//        itemRepository.save(book);
//        return book;
//    }
}