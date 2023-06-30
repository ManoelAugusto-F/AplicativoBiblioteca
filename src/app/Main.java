package app;

import Form.LivroForm;
import dao.DBConnect;

public class Main {
    public static void main(String[] args) {
       DBConnect.createTable();
        new LivroForm();
    }
}
