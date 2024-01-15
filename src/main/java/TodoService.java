/*
* File: Saclient.java
* Author: Németh Ottó
* Copyright: 2024, Németh Ottó
* Group: Szoft 2-E
* Date: 2024-01-15
* Github: https://github.com/Ottoburg17/
* Licenc: GNU GPL
*/


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TodoService {

    /**
     * @return
     */
    public List<Todo> getTodos() {
        List<Todo> todoList = null;

        try {
         
            String apiUrl = "https://jsonplaceholder.typicode.com/todos";

          
            URL url = new URL(apiUrl);

          
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

           
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
               
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

           
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

              
                Todo[] todosArray = new Gson().fromJson(response.toString(), Todo[].class);
                todoList = Arrays.asList(todosArray);
            } else {
                System.out.println("Hiba a válasz kód alapján: " + responseCode);
            }

            
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return todoList;
    }

    public static void main(String[] args) {
        TodoService todoService = new TodoService();
        List<Todo> todos = todoService.getTodos(); 
        
        if (todos != null) {
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }
}

