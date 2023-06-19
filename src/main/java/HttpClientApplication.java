import java.io.IOException;

public class HttpClientApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println (HttpStatusChecker.getStatusImage(200));
//        HttpStatusImageDownloader.downloadStatusImage(200);
        HttpImageStatusCli.askStatus();
    }
}
