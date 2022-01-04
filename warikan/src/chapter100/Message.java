package chapter100;

import java.util.Random;

public class Message {

	//randomメッセージ
	private String message[] = {
			"今日、一番笑った人","今日、一番たくさん話した人","ここから家が一番遠い人",
			"一番最初にお店に到着した人","一番最後にお店に入った人","今日、トークが一番面白かった人",
			"今日、一番みんなを笑わせた人"
	};


	int num  = new Random().nextInt(message.length - 1);

	String msg = message[num];

	//ゲッター
	String getMsg() {
		return msg;
	}
}
