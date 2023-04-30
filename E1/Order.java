package E1;

import java.util.ArrayList;

class Order {
    String customerName;
    ArrayList<OrderItem> items;
  
    public Order(String customerName, ArrayList<OrderItem> items) {
      this.customerName = customerName;
      this.items = items;
    }
  
    public int calcularPrecioTotal() {
      int total = 0;
      for (OrderItem item : items) {
        total += item.precio * item.cantidad;
      }
      return total;
    }
  }
