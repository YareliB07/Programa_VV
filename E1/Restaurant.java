package E1;

import java.util.ArrayList;

class Restaurant {
    ArrayList<MenuItem> menuItems;
    ArrayList<Order> orders;
  
    public Restaurant(ArrayList<MenuItem> menuItems) {
      this.menuItems = menuItems;
      this.orders = new ArrayList<Order>();
    }
  
    public void agregarOrden(Order order) {
      this.orders.add(order);
    }
  
    public void imprimirMenu() {
      for (MenuItem item : menuItems) {
        System.out.println(item.nombre + ": $" + item.precio);
      }
    }
  
    public void verOrdenes() {
      for (int i = 0; i < orders.size(); i++) {
        Order order = orders.get(i);
        System.out.println("Customer name: " + order.customerName);
        System.out.println("Items:");
        for (OrderItem item : order.items) {
          System.out.println(item.nombre + " x" + item.cantidad + " $" + item.precio * item.cantidad);
        }
        System.out.println("Total price: $" + order.calcularPrecioTotal());
      }
    }
  
    public int calcularGananciaTotal() {
      int totalRevenue = 0;
      for (Order order : orders) {
        totalRevenue += order.calcularPrecioTotal();
      }
      return totalRevenue;
    }
  
    public int calcularMenuItemCantidad(String itemName) {
      for (MenuItem item : menuItems) {
        if (item.nombre.equals(itemName)) {
          return item.cantidad;
        }
      }
      return 0;
    }
  
    public void actualizaMenuItemCantidad(String itemName, int newQuantity) {
      for (MenuItem item : menuItems) {
        if (item.nombre.equals(itemName)) {
          item.cantidad = newQuantity;
          break;
        }
      }
    }
}

