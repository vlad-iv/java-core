import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Main {
	public static void main(String[] args) throws IOException {
		KVServer kvServer = new KVServer(); // 8078
		kvServer.start();

		// TODO
		new HttpTaskManager(load=true); --> KVClient.load
		HttpTaskManager taskManager = new HttpTaskManager(); // получает URL или порт 8078 где запущен KVServer
		// HttpTaskManager -> KVClient (8078) -> /register -> сохраняет API_KEY
		// KVClient.save и KVClient.load

		// HttpTaskManager extends FileBackedTaskManager
		// FileBackedTaskManager.save() private -> protected
		// HttpTaskManager.save() -> KVClient.save(key, json)
		// TaskManager (tasks, subtasks, epics - HashMap -> list, + history (List id))
		// TaskManager.tasks -> json -> KVClient.save("tasks", json) -> KVClient ["tasks"->json]

		Gson gson = new Gson();
		gson.toJson(task);
		gson.fromJson(json, new TypeToken<ArrayList<Task>>() {
		}.getType());
		// Subtask.epic -> Subtask.epicId

		HttpTaskServer taskServer = HttpTaskServer(8080, Managers.getDefault()); // 8080
		taskServer.start()
//		taskServer.stop()
		TaskManager taskManager = Managers.getDefault() // возвращает HttpTaskManager
				// 1. new InMemoryTaskManager()
				// 2. new FileBackedTaskManager()
				// 3. new HttpTaskManager()

//		kvServer.stop();
	}
}
