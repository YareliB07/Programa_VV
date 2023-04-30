package E1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Restaurant {
    private static final Logger logger = Logger.getLogger(Restaurant.class.getName());
    ArrayList<MenuItem> menuItems;
    ArrayList<Order> orders;

    public Restaurant(List<MenuItem> menuItems) {
        this.menuItems = (ArrayList<MenuItem>) menuItems;
        this.orders = new ArrayList<>();
    }

    public void agregarOrden(Order order) {
        this.orders.add(order);
    }

    public void imprimirMenu() {
        for (MenuItem item : menuItems) {
            logger.log(Level.INFO, "{0}: ${1}", new Object[]{item.nombre, item.precio});
        }
    }

    public void verOrdenes() {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            logger.log(Level.INFO, "Customer name: {0}", order.customerName);
            logger.log(Level.INFO, "Items:");
            for (OrderItem item : order.items) {
                logger.log(Level.INFO, "{0} x{1} ${2}", new Object[]{item.nombre, item.cantidad, item.precio * item.cantidad});
            }
            logger.log(Level.INFO, "Total price: ${0}", order.calcularPrecioTotal());
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