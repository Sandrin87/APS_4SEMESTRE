/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import java.util.Map;
import model.Publishers;

/**
 *
 * @author gabri
 */
public interface IPublisherDao {
    
    void insertPublisher(String name, String url);
    
    void editPublisher(String name, String url);
    
    Publishers getPublisherById(int id);
    
    Map<Integer, Publishers> getAllPublishers();
    
    void deletePublisher(int id);
}
