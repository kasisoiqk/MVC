/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.controller;

import New.connect.MyConnection;
import New.dao.Dao;
import New.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class ProductDao implements Dao<Product>{
       MyConnection myConnection=MyConnection.getInstance();
       
    @Override
    public List<Product> getAll() {
        List<Product> list=new ArrayList<>();
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select * from product";
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              int id=rs.getInt("id");
              String code=rs.getString("code");
              String name=rs.getString("name");
              Float price=rs.getFloat("price");
              int quanlity=rs.getInt("quanlity");
              String desc=rs.getString("description");
              int cateId=rs.getInt("cateid");
              list.add(new Product(id, code, name, quanlity, 0, desc, cateId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Object get(int id) {
        Product p=new Product();
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select * from product where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              p.setId(rs.getInt("id"));
              p.setCode(rs.getString("code"));
              p.setName(rs.getString("name"));
             p.setPrice(rs.getFloat("price"));
              p.setQuantity(rs.getInt("quanlity"));
              p.setDesc(rs.getString("description"));
              p.setCateId(rs.getInt("cateid"));
              
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean insert(Product p) {
      Connection conn = myConnection.getConnection();
        PreparedStatement ps = null;
        
       
        try {
            String sql_insert = "insert into bai9 values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql_insert);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getCode());
            ps.setString(3, p.getName());
            ps.setFloat(4, p.getPrice());
            ps.setInt(5,p.getQuantity());
            ps.setString(6,p.getDesc());
            ps.setInt(7, p.getCateId());
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
    public boolean update(Product p) {
          Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_Update="Update bai9 set name=?,moTa=? where id=?";
            ps=conn.prepareStatement(sql_Update);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getCode());
            ps.setString(3, p.getName());
            ps.setFloat(4, p.getPrice());
            ps.setInt(5,p.getQuantity());
            ps.setString(6,p.getDesc());
            ps.setInt(7, p.getCateId());
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
    public boolean delete(Product p) {
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_Delete="Delete from bai9 where id=?";
            ps=conn.prepareStatement(sql_Delete);
            ps.setInt(1, p.getId());
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
            String sql_Delete="Delete from bai9 where id=?";
            ps=conn.prepareStatement(sql_Delete);
            ps.setInt(1, id);
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
    public List<Product> search(Product p) {
         List<Product> list=new ArrayList<>();
        Connection conn=myConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String sql_find="select * from bai9 where id >0";
            if(!p.getName().equals("")){
              sql_find +=" AND name like '%"+p.getName()+"%'";
            }
            ps=conn.prepareStatement(sql_find);
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              int id=rs.getInt("id");
              String code=rs.getString("code");
              String name=rs.getString("name");
              Float price=rs.getFloat("price");
              int quanlity=rs.getInt("quanlity");
              String desc=rs.getString("description");
              int cateId=rs.getInt("cateid");
               list.add(new Product(id, code, name, quanlity, 0, desc, cateId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
