import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String URL = "https://http.cat/";
    static String getStatusImage(int code) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL + code + ".jpg"))
                .GET()
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = String.valueOf(httpResponse.statusCode());
        if (response.startsWith("4")) {
            throw new IllegalArgumentException("Bad status code. Code must be between 100 and 200");
        }
        return String.valueOf(httpResponse.uri());
    }
}
