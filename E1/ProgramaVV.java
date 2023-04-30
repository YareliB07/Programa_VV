package E1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProgramaVV {
  private static final Logger logger = Logger.getLogger(ProgramaVV.class.getName());

  public static void main(String[] args) {
    ArrayList<MenuItem> menuItems = new ArrayList<>();
    menuItems.add(new MenuItem("Hamburguesa", 10, 1));
    menuItems.add(new MenuItem("Papas", 5, 1));
    menuItems.add(new MenuItem("Bebida", 2, 1));

    Restaurant restaurant = new Restaurant(menuItems);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      logger.info("1. Imprimir menu");
      logger.info("2. Agregar orden");
      logger.info("3. Ver ordenes");
      logger.info("4. Calcular ingresos totales");
      logger.info("5. Exit");
      logger.info("Introduzca su opcion: ");
      int choice = scanner.nextInt();

      if (choice == 1) {
        restaurant.imprimirMenu();
      }
      else if (choice == 2) {
        logger.info("Ingrese el nombre de usuario: ");
        String customerName = scanner.next();
        ArrayList<OrderItem> items = new ArrayList<>();
        while (true) {
          logger.info("Ingrese el nombre del item (ingresa 0 para detener): ");
          String itemName = scanner.next();
          if (itemName.equalsIgnoreCase("0")) {
            break;
          }
          logger.info("Ingrese cantidad: ");
          int cantidad = scanner.nextInt();
          for (MenuItem item : menuItems) {
            if (item.nombre.equals(itemName)) {
              items.add(new OrderItem(itemName, item.precio, cantidad));
              break;
            }
          }
        }
        Order order = new Order(customerName, items);
        restaurant.agregarOrden(order);
      }
      else if (choice == 3) {
        restaurant.verOrdenes();
      }
      else if (choice == 4) {
        int totalRevenue = restaurant.calcularGananciaTotal();
        logger.info("Total revenue: $" + totalRevenue);
      }
      else if (choice == 5) {
        scanner.close();
        break;
      }
      else {
        logger.warning("Opcion invalida");
      }
    }
  }
}