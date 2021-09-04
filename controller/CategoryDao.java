/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.controller;

import New.connect.MyConnection;
import New.dao.Dao;
import New.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class CategoryDao implements Dao<Category>{
      MyConnection myConnection=MyConnection.getInstance();
     
    @Override
    public List<Category> getAll() { 
        Connection conn=myConnection.getConnection();
        List<Category> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String query="select * from bai9";
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
              Category c=new Category(rs.getInt("id"), rs.getString("name"),rs.getString("moTa"));
              list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
             myConnection.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Object get(int id) {
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Category c=new Category();
        try {
            String query="select * from bai9 where id=?";
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
               c.setId(rs.getInt("id"));
               c.setName(rs.getString("name"));
               c.setDesc(rs.getString("moTa"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean insert(Category c) {
       Connection conn = myConnection.getConnection();
        PreparedStatement ps = null;
        
       
        try {
            String sql_insert = "insert into bai9 values(?,?,?)";
            ps = conn.prepareStatement(sql_insert);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getDesc());
            if(ps.executeUpdate()>0){
               
                 return true;
                 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConnection.closeConnection(conn);
        }
        
        return false;
    }

    @Override
    public boolean update(Category c) {
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_Update="Update bai9 set name=?,moTa=? where id=?";
            ps=conn.prepareStatement(sql_Update);
            ps.setString(1,c.getName());
            ps.setString(2,c.getDesc());
            ps.setInt(3, c.getId());
            if(ps.executeUpdate()>0){
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           myConnection.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean delete(Category c) {
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_Delete="Delete from bai9 where id=?";
            ps=conn.prepareStatement(sql_Delete);
            ps.setInt(1, c.getId());
            if(ps.executeUpdate()>0){
              return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
             myConnection.closeConnection(conn);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String query_Delete="Delete from bai9 where id=?";
            ps=conn.prepareStatement(query_Delete);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
              return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    @Override
    public List<Category> search(Category c) {
        List<Category> list=new ArrayList<>();
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_find="select * from bai9 where id >0";
            if(!c.getName().equals("")){
              sql_find +=" AND name like '%"+c.getName()+"%'";
            }
            ps=conn.prepareStatement(sql_find);
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               int id=rs.getInt("id");
               String name=rs.getString("name");
               String desc=rs.getString("moTa");
               list.add(new Category(id, name, desc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//    public static void main(String[] args) {
//        Category cate=new Category(6,"phu kien","phụ kien pc va laptop");
//        CategoryDao c=new CategoryDao();
//        //c.insert(cate);
//        List<Category> list=c.getAll();
//        for (Category category : list) {
//            System.out.println(category);
//        }
//        c.delete(cate);
//       // List<Category> list=c.getAll();
//        for (Category category : list) {
//            System.out.println(category);
//        }
//        
//  
//    }

   
}
