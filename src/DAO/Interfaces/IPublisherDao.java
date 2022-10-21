/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import model.Publisher;

import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author gabri
 */
public interface IPublisherDao {
    
    void insertPublisher(String name, String url);
    
    void editPublisher(String name, String url, int publisher_id) throws SQLException;

    
    Publisher getPublisherById(int id) throws SQLException;
    
    Map<Integer, Publisher> getAllPublishers();
    
    void deletePublisher(int id);
}
