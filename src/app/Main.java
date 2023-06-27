package app;

import Form.LivroForm;
import dao.DBConnect;

public class Main {
    public static void main(String[] args) {
       DBConnect.getConnection();
       DBConnect.createTable();
        new LivroForm();
    }
}
