import database.ConectionDB;
import model.Book;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Aplication {

    public static void main(String args[]) {

        var conexao = ConectionDB.conector();

        String sql = "select * from books where title = ?";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            Book booke = new Book();
            var titles = JOptionPane.showInputDialog(booke.getTitle());
            pst.setString(1, titles);


            ResultSet rs = pst.executeQuery();

            Book book = null;
            if (rs.next()) {
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                double price = rs.getDouble("price");
                String publishers = rs.getString("publisher_id");

                book = new Book(title, isbn, price, publishers);
                System.out.println("TITULO: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("PRICE: " + book.getPrice());
                System.out.println("PUBLISHERS: " + book.getPublishers());

            } else {
                System.out.println("Nenhum livro encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }


    }
