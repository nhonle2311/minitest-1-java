import java.util.Scanner;

public class MiniTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean loggedIn = false;

        while (count < 3 && !loggedIn) {
            System.out.print("Nhập user: ");
            String user = scanner.nextLine();
            System.out.print("Nhập password: ");
            String password = scanner.nextLine();

            if (user.equals("admin") && password.equals("123456")) {
                loggedIn = true;
            } else {
                count++;
                System.out.println("Thông tin đăng nhập không đúng. Vui lòng thử lại.");
            }
        }

        if (loggedIn) {
            System.out.println("Đăng nhập thành công!");
            displayMenu(scanner);
        } else {
            System.out.println("Bạn đã nhập sai quá 3 lần. Chương trình sẽ thoát.");
        }
    }

    static void displayMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Vẽ hình chữ nhật");
            System.out.println("2. Vẽ tam giác vuông");
            System.out.println("3. Vẽ tam giác cân");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    drawShape(scanner, "hình chữ nhật");
                    break;
                case 2:
                    drawShape(scanner, "tam giác vuông");
                    break;
                case 3:
                    drawShape(scanner, "tam giác cân");
                    break;
                case 4:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);
    }

    static void drawShape(Scanner scanner, String shape) {
        if (shape.equals("hình chữ nhật")) {
            System.out.print("Nhập chiều rộng: ");
            int width = scanner.nextInt();
            System.out.print("Nhập chiều cao: ");
            int height = scanner.nextInt();
            drawRectangle(width, height);
        } else if (shape.equals("tam giác vuông")) {
            System.out.print("Nhập cạnh góc vuông: ");
            int leg = scanner.nextInt();
            drawRightAngleTriangle(leg);
        } else if (shape.equals("tam giác cân")) {
            System.out.print("Nhập chiều cao tam giác cân: ");
            int triangleHeight = scanner.nextInt();
            System.out.print("Nhập cạnh đáy tam giác cân: ");
            int triangleBase = scanner.nextInt();
            drawIsoscelesTriangle(triangleHeight, triangleBase);
        }
    }

    static void drawRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void drawRightAngleTriangle(int leg) {
        for (int i = 1; i <= leg; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void drawIsoscelesTriangle(int height, int base) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= base; j++) {
                if (j <= (base - i) / 2 || j > base - (base - i) / 2) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
