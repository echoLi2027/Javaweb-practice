package jdbc;

import domain.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEncapsulateObj08 {

    public static void main(String[] args) {
        JdbcEncapsulateObj08 obj08 = new JdbcEncapsulateObj08();
        List<Emp> all = obj08.findAll2();
        System.out.println(all);
        System.out.println(all.size());
    }

    public List<Emp> findAll() {

        Statement stat = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> emps = new ArrayList<Emp>();
//        1. import driver package
//        2. register driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            3.get db connection obj
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practive2", "root", "root");
//        4.define sql sentence
            String sql = "select * from emp";
//        5. get statement obj which can execute sql obj
            stat = conn.createStatement();
//        6.execute sql sentence
            rs = stat.executeQuery(sql);
//        7.process result
//            7.1 let mouse move to next line
            Emp emp = null;
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date date = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(name);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(date);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                emps.add(emp);

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

//        8.release resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            return emps;
        }
    }


    public List<Emp> findAll2() {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        List<Emp> emps = new ArrayList<Emp>();
//        1. import driver package
//        2. register driver

        try {
            conn = JDBCUtils.getConnection();
//        4.define sql sentence
            String sql = "select * from emp";
//        5. get statement obj which can execute sql obj
            stat = conn.createStatement();
//        6.execute sql sentence
            rs = stat.executeQuery(sql);
//        7.process result
//            7.1 let mouse move to next line
            Emp emp = null;
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date date = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(name);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(date);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                emps.add(emp);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            JDBCUtils.close(rs,stat,conn);

            return emps;
        }
    }
}

