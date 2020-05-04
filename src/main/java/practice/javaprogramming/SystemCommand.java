package practice.javaprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.*;

public class SystemCommand {
	public static void main(String[] args) {
		int counter = 1;
		while(true){
			try {
				String preCommand = "curl -v  http://omdbapi.com/?s=";
				String word = "waterworld";
				String postCommand = "&page=";
				String  executeCommand = preCommand+word+postCommand+counter; 
				Process p = Runtime.getRuntime().exec(executeCommand);
				counter++;
				p.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line=reader.readLine();

				if (line != null) {    

					JSONObject obj;
					try {
						obj = new JSONObject(line);

						JSONArray arr = obj.getJSONArray("Search");
						for (int i = 0; i < arr.length(); i++)
						{
							String post_id = arr.getJSONObject(i).getString("Title");
							System.out.println(post_id);
						}
					} catch (JSONException e) {
						break;
					}
				}

			}
			catch(IOException e1) {}
			catch(InterruptedException e2) {}
		}
	}
}
