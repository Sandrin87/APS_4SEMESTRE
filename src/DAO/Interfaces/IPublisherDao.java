/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import java.util.List;
import java.util.Map;
import model.Publisher;

/**
 *
 * @author gabri
 */
public interface IPublisherDao {
    
    void insertPublisher(String name, String url);
    
    void editPublisher(String name, String url);
    
    Publisher getPublisherById(int id);
    
    List<Publisher> getAllPublishers();
    
    void deletePublisher(int id);
}
