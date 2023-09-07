package HomeWork29.coffee.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private static int nextOrderNumber = 0;
    @Builder.Default
    private int orderNumber = nextOrderNumber++;
    private String customerName;
}
