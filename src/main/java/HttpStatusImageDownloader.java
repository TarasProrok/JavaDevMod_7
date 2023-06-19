import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws IOException, InterruptedException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String urlImage = httpStatusChecker.getStatusImage(code);

        URL url = new URL(urlImage);
        try (InputStream in = url.openStream()) {
            Path path = Paths.get("./" + code + ".jpg");
            File file = new File(path.toUri());
            Files.copy(in, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
