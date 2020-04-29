package main.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class OrderSpec {

    public static Specification<Order> memberNameLike(final String memberName) {
        return (Specification<Order>) (root, query, builder) -> {

            if (StringUtils.isEmpty(memberName)) return null;

            Join<Order, Member> m = root.join("member", JoinType.INNER); //회원과 조인
            return builder.like(m.get("name"), "%" + memberName + "%");
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return (Specification<Order>) (root, query, builder) -> {

            if (orderStatus == null) return null;

            return builder.equal(root.get("status"), orderStatus);
        };
    }
}