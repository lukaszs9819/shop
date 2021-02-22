package com.shop;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;

public class Database {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lukaszS1!";

    private static final Logger log = Logger.getLogger(Database.class);

    static public int logging(String loginField, String passField) {
        Connection conn = null;
        Statement stmt = null;
        int state=-1;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");

            stmt = conn.createStatement();
            String sql;

            sql = "SELECT password, admin FROM Users where login = '" + loginField +"'";
            //sql = "SELECT password, admin FROM Users WHERE login = 'lsobon'";
            ResultSet rs = stmt.executeQuery(sql);


            if(rs.next()) { //rs.nest() zwraca "true" jeśli istniej następny obiekt
                //Retrieve by column name
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                if (passField.equals(password)) {
                    if (admin)
                        state= 1;
                    else
                        state=0;
                }

            }
            else {
                log.warn("No such account");
            }

            rs.close();
            stmt.close();
            conn.close();
            log.info("Logining done");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try
        return state;
    }

    static public void addToDatabase(String table, String insertValues){
        Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");
            stmt = conn.createStatement();
            String sql;
            if(table.equals("Users")|| table.equals("orders") ) {
                sql = "SELECT MAX(id) AS id FROM " + table;
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                int id = rs.getInt("id");
                insertValues= Integer.toString(++id)+ ", "+insertValues;
                rs.close();
            }
            stmt.close();
            conn.close();
            conn = null;
            stmt = null;
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            log.info("INSERT INTO " + table + " VALUES (" + insertValues + ")");
            sql = "INSERT INTO " + table + " VALUES (" + insertValues + ")";
            stmt.executeUpdate(sql);
            log.info("Add to " + table + " successfully");
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try

    }

    static public Product selectForSale(String barcode, float amount){
        Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Products WHERE Barcode =  " + barcode;

            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                String barecode = rs.getString("barcode");
                String name = rs.getString("name");
                float number = rs.getFloat("amount");
                float price = rs.getFloat("price");
                String provider = rs.getString("Provider");
                if(number<amount)
                    log.warn("Impossible, not enough in warehouse");
                else{
                    log.info("Product to sold "+barecode+ " " + name +" "+ number);
                    return new Product(Integer.valueOf(barecode), name, price, number, provider);
                }
            }
            else{
                log.warn("Not such product in warhouse");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try

        return null;
    }

    static public LinkedList<Product> selectInOrder(String table, String order){
        Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            LinkedList<Product> temporary = new LinkedList();
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM " + table + " ORDER BY " + order ;

            ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    //Retrieve by column name
                    int barcode = rs.getInt("Barcode");
                    String name = rs.getString("Name");
                    float amount = rs.getFloat("Amount");
                    String Category = rs.getString("Category");
                    float price = rs.getFloat("Price");
                    String provider = rs.getString("provider");
                    Product temp = new Product(barcode,name, price,amount,provider);
                    temp.setCategory(Category);
                    temporary.add(temp);
                }
                if(!temporary.isEmpty()) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    log.info("Data from Database successfully downloaded");
                    return temporary;
                }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Data from Database not downloaded");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try
    return null;
    }

    static public void changeAmount(String barcode, float amount){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");
            stmt = conn.createStatement();
            String sql = "UPDATE Products " + "SET amount = " + amount + " WHERE barcode = " + barcode + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            log.info("Database update successfully");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try


    }

    static public LinkedList<Product> searchInDatabase(String table, String searchBy, String exactWord){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Conected to Database");
            stmt = conn.createStatement();
            LinkedList<Product> searched = new LinkedList();

            String sql = "SELECT * FROM "+ table + " WHERE " + searchBy + " LIKE '%" + exactWord + "%';";
            ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int barcode = rs.getInt("Barcode");
                    String name = rs.getString("Name");
                    float amount = rs.getFloat("Amount");
                    String Category = rs.getString("Category");
                    float price = rs.getFloat("Price");
                    String provider = rs.getString("provider");
                    Product temp = new Product(barcode,name, price,amount,provider);
                    temp.setCategory(Category);
                    searched.add(temp);
                }
                if(!searched.isEmpty()){
                    stmt.close();
                    conn.close();
                    log.info("Data successfully download");
                    return searched;
                }



            stmt.close();
            conn.close();
            log.info("Data not download, not such data as need");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try


        return null;
    }

    static public LinkedList<PromoCode> searchForPromos(String searchBy){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            LinkedList<PromoCode> searched = new LinkedList();

            String sql = "SELECT * FROM Discount ORDER BY " + searchBy ;
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()){
                    String code = rs.getString("code");
                    int discount = rs.getInt("discount");
                    PromoCode temp = new PromoCode(discount,code);
                    searched.add(temp);
            }
            if(!searched.isEmpty()) {
                stmt.close();
                conn.close();
                log.info("Data successfully download");
                return searched;
            }
            stmt.close();
            conn.close();
            log.info("No such data");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try


        return null;
    }

    static public LinkedList<Providers> searchForProviders(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            LinkedList<Providers> searched = new LinkedList();

            String sql = "SELECT * FROM Providers ORDER BY name";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()){
                String name = rs.getString("name");
                String adres = rs.getString("adress");
                double nip = rs.getInt("nip");
                Providers temp = new Providers(nip,adres,name);
                searched.add(temp);
            }
            if(!searched.isEmpty()) {
                stmt.close();
                conn.close();
                log.info("Data successfully download");
                return searched;
            }
            stmt.close();
            conn.close();
            log.info("Data not download");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try


        return null;
    }

    static public LinkedList<Users> selectUsers( String order){
        Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            LinkedList<Users> temporary = new LinkedList();
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users ORDER BY " + order ;

            ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String login = rs.getString("login");
                    String password = rs.getString("login");
                    boolean admin = rs.getBoolean("admin");
                    Users temp = new Users(id,name,surname,login,password,admin);
                    temporary.add(temp);
                }
                if(!temporary.isEmpty()) {
                    stmt.close();
                    conn.close();
                    log.info("Data successfully downloaded");
                    return temporary;
                }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Data not downloaded");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try
        return null;
    }

    static public void deleteFromTable(String table, String column, String keyWord){Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM "+ table + " WHERE " + column + " = '" + keyWord +"'";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            log.info("Deleted successfully");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try



    }

    static public LinkedList<Orders> searchForOrders(){Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Successfully connected");
            stmt = conn.createStatement();
            LinkedList<Orders> searched = new LinkedList();

            String sql = "SELECT * FROM Orders ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String adres = rs.getString("addres");
                String code = rs.getString("code");
                String city = rs.getString("city");
                String payment = rs.getString("payment");
                Orders temp = new Orders(id,name,surname,adres,code,city,payment);
                searched.add(temp);
            }
            if(!searched.isEmpty()) {
                stmt.close();
                conn.close();
                log.info("Successfully downloaded data");
                return searched;
            }
            stmt.close();
            conn.close();
            log.info("Not downloaded");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try


        return null;

    }

    static public boolean updateField(String table, String columnChange, String columnKey, String keyWord, String newValue){
        boolean pom;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            String sql = "UPDATE " + table  + " SET " + columnChange + " = '"+ newValue + "' WHERE " + columnKey + " = " + keyWord + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            pom=true;
            log.info("Successfully updated field");
        } catch (SQLException se) {
            pom=false;
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            pom=false;
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try
        return pom;
    }

    static public LinkedList<Product> shortage(){
        Connection conn = null;
        Statement stmt = null;
        int state=0;
        try {
            LinkedList<Product> temporary = new LinkedList();
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            log.info("Connected to Database");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM products WHERE amount < 10 ORDER BY name;" ;

            ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int barcode = rs.getInt("Barcode");
                    String name = rs.getString("Name");
                    float amount = rs.getFloat("Amount");
                    String Category = rs.getString("Category");
                    float price = rs.getFloat("Price");
                    String provider = rs.getString("provider");
                    Product temp = new Product(barcode,name, price,amount,provider);
                    temp.setCategory(Category);
                    temporary.add(temp);
                }
                if(!temporary.isEmpty()) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    log.info("Successfully downloaded");
                    return temporary;
                }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Not downloaded");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

        }//end try
        return null;
    }

}