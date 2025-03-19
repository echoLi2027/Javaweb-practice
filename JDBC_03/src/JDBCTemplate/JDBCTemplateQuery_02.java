package JDBCTemplate;

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.DruidJDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTemplateQuery_02 {

    JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());

    @Test
    public void testUpdate() {
        int updated = template.update("update emp set bonus = 10000 where id = ?", 1001);
        System.out.println(updated);
    }

    @Test
    public void testInsert(){
        int updated = template.update("insert into emp(id,ename, salary) values(?,?,?)", 1015,"sheldon", 10000);
        System.out.println(updated);
    }

    @Test
    public void testDelete(){
        int updated = template.update("delete from emp where id = ?", 1015);
        System.out.println(updated);
    }

    @Test
    public void testQueryMapper(){
        Map<String, Object> map = template.queryForMap("select * from emp where id = ?", 1001);
        System.out.println(map);
    }

    @Test
    public void testQueryList(){
        List<Map<String, Object>> maps = template.queryForList("select * from emp");
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void testQueryRowMapper(){
        List<Emp> emp = template.query("select * from emp", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {

                Emp emp = new Emp();
                emp.setId(resultSet.getInt("id"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob_id(resultSet.getInt("job_id"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setSalary(resultSet.getDouble("salary"));
                emp.setBonus(resultSet.getDouble("bonus"));
                emp.setJoindate(resultSet.getDate("joindate"));
                emp.setDept_id(resultSet.getInt("dept_id"));

                return emp;
            }
        });
        System.out.println(emp);
    }

    @Test
    public void testQueryRowMapper2(){
        List<Emp> emps = template.query("select * from emp", new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testQueryforObject(){
        Object o = template.queryForObject("select count(id) from emp", Integer.class);
        System.out.println(o);
    }







}
