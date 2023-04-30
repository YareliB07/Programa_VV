package E1;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa_VV {

  public static void main(String[] args) {
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    menuItems.add(new MenuItem("Hamburguesa", 10, 1));
    menuItems.add(new MenuItem("Papas", 5, 1));
    menuItems.add(new MenuItem("Bebida", 2, 1));

    Restaurant restaurant = new Restaurant(menuItems);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("1. Imprimir menu");
      System.out.println("2. Agregar orden");
      System.out.println("3. Ver ordenes");
      System.out.println("4. Calcular ingresos totales");
      System.out.println("5. Exit");
      System.out.print("Introduzca su opcion: ");
      int choice = scanner.nextInt();

      if (choice == 1) {
        restaurant.imprimirMenu();
      }
      else if (choice == 2) {
        System.out.print("Ingrese el nombre de usuario: ");
        String customerName = scanner.next();
        ArrayList<OrderItem> items = new ArrayList<OrderItem>();
        while (true) {
          System.out.print("Ingrese el nombre del item (ingresa 0 para detener): ");
          String itemName = scanner.next();
          if (itemName.equalsIgnoreCase("0")) {
            break;
          }
          System.out.print("Ingrese cantidad: ");
          int cantidad = scanner.nextInt();
          for (MenuItem item : menuItems) {
            if (item.nombre.equals(itemName)) {
              items.add(new OrderItem(itemName, item.precio, cantidad));
              break;
            }
          }
        }
        Order orden = new Order(customerName, items);
        restaurant.agregarOrden(orden);
      }
      else if (choice == 3) {
        restaurant.verOrdenes();
      }
      else if (choice == 4) {
        int totalRevenue = restaurant.calcularGananciaTotal();
        System.out.println("Ganancia total: $" + totalRevenue);
      }
      else if (choice == 5) {
        break;
      }
    }
  }
}