package userInterface;
import java.util.Scanner;

class Mat {
    int rows, cols;
    int[][] data;

    public Mat(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public void fill(Scanner sc, String name) {
        System.out.println("Enter elements for " + name + " (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = sc.nextInt();
            }
        }
    }

    public void show(String op) {
        System.out.println(op + " Result:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Add extends Thread {
    Mat a, b, res;

    public Add(Mat a, Mat b, Mat res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Override
    public void run() {
        System.out.println("Performing addition...");
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        res.show("Addition");
    }
}

class Sub extends Thread {
    Mat a, b, res;

    public Sub(Mat a, Mat b, Mat res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Override
    public void run() {
        System.out.println("Performing subtraction...");
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        res.show("Subtraction");
    }
}

class Mul extends Thread {
    Mat a, b, res;

    public Mul(Mat a, Mat b, Mat res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Override
    public void run() {
        System.out.println("Performing multiplication...");
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                res.data[i][j] = 0;
                for (int k = 0; k < a.cols; k++) {
                    res.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        res.show("Multiplication");
    }
}

public class MatrixOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and cols for matrices: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        Mat a = new Mat(rows, cols);
        Mat b = new Mat(rows, cols);
        Mat resAdd = new Mat(rows, cols);
        Mat resSub = new Mat(rows, cols);
        Mat resMul = new Mat(rows, cols);

        a.fill(sc, "Matrix A");
        b.fill(sc, "Matrix B");

        System.out.println("\nStarting operations...\n");

        // Perform addition
        Thread addThread = new Add(a, b, resAdd);
        addThread.start();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform subtraction
        Thread subThread = new Sub(a, b, resSub);
        subThread.start();
        try {
            subThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform multiplication
        Thread mulThread = new Mul(a, b, resMul);
        mulThread.start();
        try {
            mulThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
