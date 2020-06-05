public class script {
     public static void main (String[] args) {
          System.out.print("public " + args[0] + " " + "get");
          System.out.print(args[1].substring(0,1).toUpperCase() +
          args[1].substring(1));
          System.out.println("() {");
          System.out.println("\treturn " + args[1] + ";");
          System.out.print("}");

          System.out.println("\n");
          System.out.print("public void set");
          System.out.print(args[1].substring(0,1).toUpperCase() +
          args[1].substring(1));
          System.out.println("() {");
          System.out.println("\tthis." + args[1] + " = " + args[1] + ";");
          System.out.print("}");
     }
}
