import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
class KVServerTest {
	KVServer kvServer;
	@BeforeEach
	void start() throws IOException {
		 kvServer = new KVServer();
		 kvServer.start();
	}

	@AfterEach
	void stop() {
		kvServer.stop();
	}

	@Test
	void testServer() {

	}

	@Test
	void getTasks() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		URI url = URI.create("http://localhost:8080/tasks/task");
		HttpRequest request = HttpRequest.newBuilder().uri(url).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		assertEquals(200, response.statusCode());

		final Task task = gson.fromJson(json, Task.class); // Будет работать
		final List<Task> tasks = gson.fromJson(json, ArrayList<Task>.class); // Не будет работать.
		final List<Object> tasks = gson.fromJson(json, ArrayList<Object>.class); // Не будет работать.

		final List<Task> tasks = gson.fromJson(response.body(), new TypeToken<ArrayList<Task>>() {
		}.getType());

		assertNotNull(tasks, "Задачи на возвращаются");
		assertEquals(1, tasks.size(), "Не верное количество задач");
		assertEquals(task, tasks.get(0), "Задачи не совпадают");
	}

}