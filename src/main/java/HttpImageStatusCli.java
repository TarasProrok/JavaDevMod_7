import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() throws IOException, InterruptedException {

        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter HTTP status code: ");
            String code = scanner.nextLine();
            if (code.matches("\\d+")) {
                httpStatusImageDownloader.downloadStatusImage(Integer.parseInt(code));
                System.out.println("Image found and downloaded!");
            } else {
                System.out.println("There is not image for HTTP status " + code);
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid code between 100 and 300");
        }
    }
}
