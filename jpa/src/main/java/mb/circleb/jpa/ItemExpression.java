package mb.circleb.jpa;

import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;

public class ItemExpression {

    @QueryDelegate(Item.class)
    public static BooleanExpression isExpensive(QItem item, Integer price){
        return item.price.gt(price);
    }

    @QueryDelegate(String.class)
    public static BooleanExpression isItemNameStart(StringPath stringPath){
        return stringPath.startsWith("상품8");
    }
}
