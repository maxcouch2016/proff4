package action07;

/*
1. Написать "сервер", который умеет многопоточно выполнять задачи:
 а) Считывать информацию с консоли. 
  Он считывает строку и номер клиента.
  После считывания, строка отправляется на соответствующий клиент
 b) Умеет "ждать" подключения нового клиента, при новом подключении клиента, 
  сокет соединения помещается в новый поток для "общения сокета клиента и сокета сервера".
 с) Класс потока для общения с клиентом
  (для каждого клиента сервер выделяет новый сокет дял общения)
Также написать класс "клиент", который соединяется с сервером. 
Задача клиента принять строку и вывести ее в формате "Client 1:"+stroka или "Client 2:"+stroka.
 */

public class ServerClientsTest {

	public static void main(String[] args) {
		int port = 3235;
		new MyServer(port).start();
		new MyClient("localhost", port).start();
		new MyClient("localhost", port).start();
		new MyClient("localhost", port).start();
		new MyClient("localhost", port).start();
		new MyClient("localhost", port).start();
		new MyClient("localhost", port).start();
	}
	
}
